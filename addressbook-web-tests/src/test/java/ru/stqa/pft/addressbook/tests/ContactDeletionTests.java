package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

import java.util.List;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.contact().contactPage();
        if (app.contact().list().size() == 0) {
            app.contact().create(new ContactDate().withFirstname("Ivanov").withLastname("Ivan").withNickname("Ivancik").withCompany("LK").withAddress("RF"), true);
        }
    }

    @Test
    public void testContactDeletion() {
        List<ContactDate> before = app.contact().list();
        int index = before.size() -1;
        app.contact().delete(index);
        List<ContactDate> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() - 1);


        before.remove(index);
        Assert.assertEquals(before, after);


    }


}
