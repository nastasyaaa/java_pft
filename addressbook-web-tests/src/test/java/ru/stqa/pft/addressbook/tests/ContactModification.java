package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

public class ContactModification extends TestBase{
    @Test
    public void testContactModification() {
        app.getContactHelper().selectContact();
        app.getContactHelper().intContactModification();
        app.getContactHelper().fillContactCreation(new ContactDate("Ivanov", "Ivan", "Ivancik", "LK", "Russia", null), false);
        app.getContactHelper().submitContactModification();
}
}
