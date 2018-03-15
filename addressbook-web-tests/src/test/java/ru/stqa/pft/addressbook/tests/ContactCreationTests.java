package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getContactHelper().returnToContactPage();
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().creationContact(new ContactDate("Ivanov", "Ivan", "Ivancik", "LK", "Russia", "test1"), true);
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before + 1);
    }


}
