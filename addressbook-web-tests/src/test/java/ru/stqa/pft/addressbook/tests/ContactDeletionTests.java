package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().goHome();
        int before = app.getContactHelper().getContactCount();
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("testfirstname1", "testmiddlename1", "testlastname1", "testnickname1", "testtitle1", "testcompany1", "testmobile1", "testemail1"));
        }
        app.getContactHelper().selectContact(before - 1);
        app.getContactHelper().deleteSelectedContacts();
        app.getContactHelper().closeDialogWindow();
        app.getNavigationHelper().goHome();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before - 1);
    }

}
