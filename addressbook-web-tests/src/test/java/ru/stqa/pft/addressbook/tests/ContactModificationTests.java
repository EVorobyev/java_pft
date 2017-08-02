package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by EOnegin on 24.07.2017.
 */
public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().goHome();
    int before = app.getContactHelper().getContactCount();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("testfirstname1", "testmiddlename1", "testlastname1", "testnickname1", "testtitle1", "testcompany1", "testmobile1", "testemail1"));
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("testfirstname1", "testmiddlename1", "testlastname1", "testnickname1", "testtitle1", "testcompany1", "testmobile1", "testemail1"));
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().goHome();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before);
  }
}
