package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

public class ContactModification extends TestBase {
    @Test
    public void testContactModification() {
        if (!app.getContactHelper().isThisAContact()) {
            app.getContactHelper().creationContact(new ContactDate("Petrov", "Petr", "Petroff", "LKK", "RF", null), true);
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().intContactModification();
        app.getContactHelper().fillContactCreation(new ContactDate("Ivanov", "Ivan", "Ivancik", "LK", "Russia", null), false);
        app.getContactHelper().submitContactModification();
    }
}
