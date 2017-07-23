package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase2 {

  @Test
  public void testContactCreation() {
    initContactCreation();
    fillContactForm(new ContactData("testfirstname1", "testmiddlename1", "testlastname1", "testnickname1", "testtitle1", "testcompany1", "testmobile1", "testemail1"));
    submitContactCreation();
    goHome();
  }

}
