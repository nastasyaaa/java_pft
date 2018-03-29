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
        app.contact().contactPage();
        if (app.contact().list().size() == 0) {
            app.contact().create(new ContactDate()
                    .withFirstname("Petrov").withLastname("Petr").withNickname("Petroff").withCompany("LKK").withAddress("RF"), true);
        }
    }

    @Test
    public void testContactModification() {
        List<ContactDate> before = app.contact().list();
        //app.contact().selectContact(before.size() - 1);
        ContactDate contact = new ContactDate().withFirstname("Ivanov").withLastname("Ivan").withNickname("Ivancik").withCompany("LK").withAddress("RF");
        app.contact().modifi(contact);

        List<ContactDate> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size());
        before.remove(before.size()-1);
        before.add(contact);

        Comparator<ContactDate> comparator = Comparator.comparing(ContactDate::getLastname);
        before.sort(comparator);
        after.sort(comparator);
        Assert.assertEquals(before, after);

    }


}
