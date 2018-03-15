package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

import java.util.List;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        app.getContactHelper().returnToContactPage();
        if (!app.getContactHelper().isThisAContact()) {
            app.getContactHelper().creationContact(new ContactDate("Ivanov", "Ivan", "Ivancik", "LK", "Russia", "test1"), true);
        }
        List<ContactDate> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() -1);
        app.getContactHelper().deleteContact();
        app.getContactHelper().endDeleteContact();
        List<ContactDate> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);
        
    }
}
