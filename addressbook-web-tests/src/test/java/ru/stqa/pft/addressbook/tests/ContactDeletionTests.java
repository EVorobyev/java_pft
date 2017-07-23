package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase2 {

    @Test
    public void testContactDeletion() {
        app2.selectContact();
        app2.deleteSelectedContacts();
        app2.closeDialogWindow();
        app2.goHome();
    }

}
