package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.*;


public class ContactModification extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.contact().contactPage();
        if (app.db().contacts().size() == 0) {
            app.contact().create(new ContactDate()
                    .withFirstname("Petrov")
                    .withLastname("Petr")
                    .withNickname("Petroff")
                    .withCompany("LKK")
                    .withAddress("RF")
                    .withEmail("test@test.ru")
                    .withEmail2("test@test1.ru")
                    .withEmail3("test@test2.ru")
                    .withHomePhone("8978220033")
                    .withMobilePhone("8978220033")
                    .withWorkPhone("8978220033"), true);
        }
    }

    @Test
    public void testContactModification() {
        Contacts before = app.db().contacts();
        ContactDate modifideContact = before.iterator().next();
        ContactDate contact = new ContactDate().
                withId(modifideContact.getId())
                .withFirstname("Ivanov")
                .withLastname("Ivan")
                .withNickname("Ivancik")
                .withCompany("LK")
                .withAddress("RF")
                .withEmail("test@test.ru")
                .withEmail2("test@test1.ru")
                .withEmail3("test@test11.ru")
                .withWorkPhone("999633")
                .withMobilePhone("236523")
                .withHomePhone("457878");
        app.contact().modifi(contact);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before.without(modifideContact).withAdded(contact)));
        verifyContactListInUI();
    }


}
