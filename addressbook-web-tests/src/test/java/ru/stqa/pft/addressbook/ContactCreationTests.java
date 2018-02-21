package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        newContactCreation();
        fillContactCreation(new ContactDate("Ivanov", "Ivan", "Ivancik", "LK", "Russia"));
        submitContactCreation();
        returnToContactPage();
    }


}
