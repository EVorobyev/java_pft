package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.appmanager.HttpSession;
import ru.stqa.pft.mantis.model.MailMessage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

/**
 * Created by EOnegin on 24.09.2017.
 */
public class ChangePasswordTest extends TestBase {

//  @BeforeMethod
  public void startMailServer() {
    app.mail().start();
  }

  @Test
  public void testChangePassword() throws IOException, MessagingException {
    HttpSession session = app.newSession();
    String newPassword = "newpassword";
    app.session().login("administrator", "root");
    app.resetPassword().goToManagePage();
    app.resetPassword().goToManageOfUsersPage();
    app.resetPassword().chooseUser();
    String user = app.resetPassword().getUserName();
    String email = app.resetPassword().getMail();
    app.resetPassword().resetPassword();
    List<MailMessage> mailMessages = app.mail().waitForMail(1, 10000);
    String resetPasswordLink = findResetPasswordLink(mailMessages, email);

    app.resetPassword().changePasswordFinish(resetPasswordLink, newPassword);
    assertTrue(session.login(user, newPassword));
    assertTrue(session.isLoggedInAsUser(user));
  }

  private String findResetPasswordLink(List<MailMessage> mailMessages, String email) {
    MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }

  @AfterMethod(alwaysRun = true)
  public void stopMailServer() {
    app.mail().stop();
  }

}
