package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase2 {

    @Test
    public void testContactDeletion() {
        app2.getContactHelper().selectContact();
        app2.getContactHelper().deleteSelectedContacts();
        app2.getContactHelper().closeDialogWindow();
        app2.getContactNavigationHelper().goHome();
    }

}
