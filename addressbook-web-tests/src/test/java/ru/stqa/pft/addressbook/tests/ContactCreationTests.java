package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase2 {

  @Test
  public void testContactCreation() {
    app2.getContactHelper().initContactCreation();
    app2.getContactHelper().fillContactForm(new ContactData("testfirstname1", "testmiddlename1", "testlastname1", "testnickname1", "testtitle1", "testcompany1", "testmobile1", "testemail1"));
    app2.getContactHelper().submitContactCreation();
    app2.getContactNavigationHelper().goHome();
  }

}
