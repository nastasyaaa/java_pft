package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

import java.util.Comparator;
import java.util.List;

public class ContactModification extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.getContactHelper().returnToContactPage();
        if (!app.getContactHelper().isThisAContact()) {
            app.getContactHelper().creationContact(new ContactDate("Petrov", "Petr", "Petroff", "LKK", "RF", null), true);
        }
    }

    @Test
    public void testContactModification() {
        List<ContactDate> before = app.getContactHelper().getContactList();
        //app.getContactHelper().selectContact(before.size() - 1);
        ContactDate contact = new ContactDate("Ivanov", "Ivan", "Ivancik", "LK", "Russia", null);
        app.getContactHelper().modifiContact(contact);

        List<ContactDate> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());
        before.remove(before.size()-1);
        before.add(contact);

        Comparator<ContactDate> comparator = Comparator.comparing(ContactDate::getLastname);
        before.sort(comparator);
        after.sort(comparator);
        Assert.assertEquals(before, after);

    }


}
