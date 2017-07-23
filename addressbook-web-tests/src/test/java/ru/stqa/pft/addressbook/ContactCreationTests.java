package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase2 {

  @Test
  public void testContactCreation() {
    app2.initContactCreation();
    app2.fillContactForm(new ContactData("testfirstname1", "testmiddlename1", "testlastname1", "testnickname1", "testtitle1", "testcompany1", "testmobile1", "testemail1"));
    app2.submitContactCreation();
    app2.goHome();
  }

}
