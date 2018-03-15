package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getContactHelper().returnToContactPage();
        List<ContactDate> before = app.getContactHelper().getContactList();
        app.getContactHelper().creationContact(new ContactDate("Ivanov", "Ivan", "Ivancik", "LK", "Russia", "test1"), true);
        List<ContactDate> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);
    }


}
