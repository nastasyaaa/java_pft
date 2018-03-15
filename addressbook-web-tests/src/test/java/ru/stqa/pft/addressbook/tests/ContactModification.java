package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

public class ContactModification extends TestBase {
    @Test
    public void testContactModification() {
        app.getContactHelper().returnToContactPage();
        int before = app.getContactHelper().getContactCount();
        if (!app.getContactHelper().isThisAContact()) {
            app.getContactHelper().creationContact(new ContactDate("Petrov", "Petr", "Petroff", "LKK", "RF", null), true);
        }
        app.getContactHelper().selectContact(before -1);
        app.getContactHelper().intContactModification();
        app.getContactHelper().fillContactCreation(new ContactDate("Ivanov", "Ivan", "Ivancik", "LK", "Russia", null), false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToContactPage();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before);
    }
}
