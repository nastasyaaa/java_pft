package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getContactHelper().returnToContactPage();
        List<ContactDate> before = app.getContactHelper().getContactList();
        ContactDate contact = new ContactDate("Ivanov", "Ivan", "Ivancik", "LK", "Russia", "test1");
        app.getContactHelper().creationContact(contact, true);
        List<ContactDate> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);

        before.add(contact);
        Comparator<ContactDate> comparator = Comparator.comparing(ContactDate::getLastname);
        before.sort(comparator);
        after.sort(comparator);
        Assert.assertEquals(before, after);
    }


}
