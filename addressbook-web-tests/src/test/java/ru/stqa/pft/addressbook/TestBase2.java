package ru.stqa.pft.addressbook;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Created by EOnegin on 23.07.2017.
 */
public class TestBase2 {

  protected final ApplicationManager2 app2 = new ApplicationManager2();

  @BeforeMethod
  public void setUp() throws Exception {
    app2.init();
  }

  @AfterMethod
  public void tearDown() {
    app2.stop();
  }

}
