package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.newContactCreation();
        app.fillContactCreation(new ContactDate("Ivanov", "Ivan", "Ivancik", "LK", "Russia"));
        app.submitContactCreation();
        app.returnToContactPage();
    }


}
