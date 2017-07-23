package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase2 {

    @Test
    public void testContactDeletion() {
        selectContact();
        deleteSelectedContacts();
        closeDialogWindow();
        goHome();
    }

}
