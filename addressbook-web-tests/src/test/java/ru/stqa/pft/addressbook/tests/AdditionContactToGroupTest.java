package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;
import java.io.File;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by EOnegin on 17.09.2017.
 */
public class AdditionContactToGroupTest extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    if(app.db().groups().size()==0){
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1"));
    }
    if(app.db().contacts().size()==0){
      app.goTo().home();
      app.contact().create(new ContactData().withFirstname("testfirstname2").withMiddlename("testmiddlename1").withLastname("testlastname1")
              .withNickname("testnickname1").withTitle("testtitle1").withCompany("testcompany1").withMobile("testmobile1").withEmail("testemail1"));
    }
  }

  @Test
  public void testContactAdditionToGroup() {
    Groups groupsBefore= app.db().contacts().iterator().next().getGroups();
    Contacts before =app.db().contacts();
    GroupData groupAdd=app.db().groups().iterator().next();
    app.goTo().home();
    app.contact().addContactToGroup(before, groupAdd.getId());
    Groups groupsAfter=app.db().contacts().iterator().next().getGroups();
    assertThat(groupsAfter, equalTo(groupsBefore.withAdded(groupAdd)));
    verifyContactListInUI();
  }

}
