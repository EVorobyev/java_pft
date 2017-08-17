package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContacts() {
    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[] {new ContactData().withFirstname("testfirstname 1").withMiddlename("testmiddlename 1").withLastname("testlastname 1")
            .withNickname("testnickname 1").withTitle("testtitle 1").withCompany("testcompany 1")});
    list.add(new Object[] {new ContactData().withFirstname("testfirstname 2").withMiddlename("testmiddlename 2").withLastname("testlastname 2")
            .withNickname("testnickname 2").withTitle("testtitle 2").withCompany("testcompany 2")});
    list.add(new Object[] {new ContactData().withFirstname("testfirstname 3").withMiddlename("testmiddlename 3").withLastname("testlastname 3")
            .withNickname("testnickname 3").withTitle("testtitle 3").withCompany("testcompany 3")});
    return list.iterator();

  }

  @Test(dataProvider = "validContacts")
  public void testContactCreation(ContactData contact) {
    app.goTo().home();
    Contacts before = app.contact().all();
    File photo = new File("src/test/resources/stru.png");
    app.contact().create(contact);
    app.goTo().home();
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }

  @Test(enabled = false)
  public void testCurrentDir() {
    File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());
    File photo = new File("src/test/resources/stru.png");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());
  }

  @Test(enabled = false)
  public void testBadContactCreation() {
    app.goTo().home();
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withFirstname("testfirstname2'").withMiddlename("testmiddlename1").withLastname("testlastname1")
            .withNickname("testnickname1").withTitle("testtitle1").withCompany("testcompany1").withMobile("testmobile1").withEmail("testemail1");
    app.contact().create(contact);
    app.goTo().home();
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before));
  }
}
