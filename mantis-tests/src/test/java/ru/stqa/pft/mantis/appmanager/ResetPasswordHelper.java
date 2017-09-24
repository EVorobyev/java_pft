package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


/**
 * Created by EOnegin on 24.09.2017.
 */
public class ResetPasswordHelper extends HelperBase {

  public ResetPasswordHelper(ApplicationManager app) {
    super(app);
  }


  public void goToManagePage(){
    wd.findElement(By.linkText("Manage")).click();
  }

  public void goToManageOfUsersPage(){
    wd.findElement(By.linkText("Manage Users")).click();
  }

  public void chooseUser(){
    WebElement webElement = wd.findElement(By.linkText("user%s"));
    webElement.click();
  }
  public void resetPassword(){
    wd.findElement(By.cssSelector("input[value='Reset Password']")).click();
  }

  public String getUserName(){
    String username = wd.findElement(By.cssSelector("input[name='username']")).getAttribute("value");
    return username;
  }

  public String getMail(){
    String email = wd.findElement(By.cssSelector("input[name='email']")).getAttribute("value");
    return email;
  }

  public void changePasswordFinish(String resetPasswordLink, String newpassword){
    wd.get(resetPasswordLink);
    type(By.name("password"),newpassword);
    type(By.name("password_confirm"),newpassword);
    click(By.cssSelector("input[type='submit']"));
  }

}


