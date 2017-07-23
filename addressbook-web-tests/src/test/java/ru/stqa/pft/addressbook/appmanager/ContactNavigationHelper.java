package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by EOnegin on 23.07.2017.
 */
public class ContactNavigationHelper extends ContactHelperBase {

  public ContactNavigationHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void goHome() {
    click(By.linkText("home"));
  }
}
