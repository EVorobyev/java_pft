package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().goHome();
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("testfirstname1", "testmiddlename1", "testlastname1", "testnickname1", "testtitle1", "testcompany1", "testmobile1", "testemail1"));
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContacts();
        app.getContactHelper().closeDialogWindow();
        app.getNavigationHelper().goHome();
    }

}
