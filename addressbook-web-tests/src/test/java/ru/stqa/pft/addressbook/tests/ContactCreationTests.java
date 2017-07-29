package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getContactHelper().createContact(new ContactData("testfirstname1", "testmiddlename1", "testlastname1", "testnickname1", "testtitle1", "testcompany1", "testmobile1", "testemail1"));
    app.getNavigationHelper().goHome();
  }

}
