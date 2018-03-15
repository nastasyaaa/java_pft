package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

import java.util.List;

public class ContactModification extends TestBase {
    @Test
    public void testContactModification() {
        app.getContactHelper().returnToContactPage();
        if (!app.getContactHelper().isThisAContact()) {
            app.getContactHelper().creationContact(new ContactDate("Petrov", "Petr", "Petroff", "LKK", "RF", null), true);
        }
        List<ContactDate> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().intContactModification();
        app.getContactHelper().fillContactCreation(new ContactDate("Ivanov", "Ivan", "Ivancik", "LK", "Russia", null), false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToContactPage();
        List<ContactDate> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());
    }
}
