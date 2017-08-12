package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.Set;

/**
 * Created by EOnegin on 24.07.2017.
 */
public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().home();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstname("testfirstname1").withMiddlename("testmiddlename1").withLastname("testlastname1")
              .withNickname("testnickname1").withTitle("testtitle1").withCompany("testcompany1").withMobile("testmobile1").withEmail("testemail1"));
    }
  }

  @Test
  public void testContactModification() {
    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstname("testfirstname1").withMiddlename("testmiddlename1").withLastname("testlastname1")
            .withNickname("testnickname1").withTitle("testtitle1").withCompany("testcompany1").withMobile("testmobile1").withEmail("testemail1");
    app.contact().modify(contact);
    app.goTo().home();
    Contacts after = app.contact().all();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifiedContact);
    before.add(contact);
    Assert.assertEquals(before, after);
  }
}
