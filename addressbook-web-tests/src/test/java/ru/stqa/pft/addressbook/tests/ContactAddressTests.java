package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactAddressTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.contact().contactPage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactDate().withFirstname("Ivanov").withLastname("Ivan").withNickname("Ivancik").withCompany("LK").withAddress("RF"), true);
        }
    }

    @Test
    public void testContactAddress(){
        app.goTo().gotoHomePage();
        ContactDate contact = app.contact().all().iterator().next();
        ContactDate contactInfoFromEditForm = app.contact().infoFormEditForm(contact);

        assertThat(contact.getAddress(), equalTo(cleanedAddress(contactInfoFromEditForm.getAddress())));

    }

    public static String cleanedAddress(String address) {
        return address.replaceAll("\n","");
    }






}
