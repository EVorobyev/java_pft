package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


/**
 * Created by EOnegin on 24.09.2017.
 */
public class SessionHelper extends HelperBase {

  public SessionHelper(ApplicationManager app) {
    super(app);
  }

  public void login(String username, String password) {
    wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
    type(By.name("username"),username);
    type(By.name("password"),password);
    click(By.cssSelector("input[type='submit']"));
    checkUserLogged(username);
  }

  private void checkUserLogged(String username) {
    WebElement element = wd.findElement(By.cssSelector("span[class='italic']"));
    element.getText().equals(username);
  }

}
