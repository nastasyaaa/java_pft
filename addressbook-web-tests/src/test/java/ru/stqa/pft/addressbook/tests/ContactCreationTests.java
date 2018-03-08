package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getContactHelper().newContactCreation();
        app.getContactHelper().fillContactCreation(new ContactDate("Ivanov", "Ivan", "Ivancik", "LK", "Russia", "test1"), true);
        app.submitContactCreation();
        app.getContactHelper().returnToContactPage();
    }


}
