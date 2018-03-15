package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        app.getContactHelper().returnToContactPage();
        int before = app.getContactHelper().getContactCount();
        if (!app.getContactHelper().isThisAContact()) {
            app.getContactHelper().creationContact(new ContactDate("Ivanov", "Ivan", "Ivancik", "LK", "Russia", "test1"), true);
        }
        app.getContactHelper().selectContact(before -1);
        app.getContactHelper().deleteContact();
        app.getContactHelper().endDeleteContact();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before - 1);
    }
}
