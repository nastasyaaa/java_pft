package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

import java.util.Set;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.contact().contactPage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactDate().withFirstname("Ivanov").withLastname("Ivan").withNickname("Ivancik").withCompany("LK").withAddress("RF"), true);
        }
    }

    @Test
    public void testContactDeletion() {
        Set<ContactDate> before = app.contact().all();
        ContactDate deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        Set<ContactDate> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() - 1);


        before.remove(deletedContact);
        Assert.assertEquals(before, after);

    }


}
