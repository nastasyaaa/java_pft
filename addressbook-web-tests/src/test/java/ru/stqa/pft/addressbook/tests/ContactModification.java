package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

import java.util.Set;

public class ContactModification extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.contact().contactPage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactDate()
                    .withFirstname("Petrov").withLastname("Petr").withNickname("Petroff").withCompany("LKK").withAddress("RF"), true);
        }
    }

    @Test
    public void testContactModification() {
        Set<ContactDate> before = app.contact().all();
        ContactDate modifideContact = before.iterator().next();
        ContactDate contact = new ContactDate().
                withId(modifideContact.getId()).withFirstname("Ivanov").withLastname("Ivan").withNickname("Ivancik").withCompany("LK").withAddress("RF");
        app.contact().modifi(contact);
        Set<ContactDate> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size());

        before.remove(modifideContact);
        before.add(contact);
        Assert.assertEquals(before, after);

    }


}
