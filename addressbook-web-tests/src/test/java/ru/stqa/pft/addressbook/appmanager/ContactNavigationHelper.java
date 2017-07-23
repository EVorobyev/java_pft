package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by EOnegin on 23.07.2017.
 */
public class ContactNavigationHelper {
  private FirefoxDriver wd;

  public ContactNavigationHelper(FirefoxDriver wd) {
    this.wd = wd;
  }

  public void goHome() {
    wd.findElement(By.linkText("home")).click();
  }
}
