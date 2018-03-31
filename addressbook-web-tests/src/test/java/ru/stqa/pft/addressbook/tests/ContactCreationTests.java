package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

import java.util.Set;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.contact().contactPage();
        Set<ContactDate> before = app.contact().all();
        ContactDate contact = new ContactDate().withFirstname("Ivanov").withLastname("Ivan").withNickname("Ivancik").withCompany("LK").withAddress("RF");
        app.contact().create(contact, true);
        Set<ContactDate> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() + 1);

        contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
        before.add(contact);
        Assert.assertEquals(before, after);
    }


}
