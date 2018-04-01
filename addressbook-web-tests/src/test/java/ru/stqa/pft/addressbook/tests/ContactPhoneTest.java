package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

public class ContactPhoneTest extends TestBase {

    @Test
    public void testCintactPhones(){
        app.goTo().gotoHomePage();
        ContactDate contact = app.contact().all().iterator().next();
        ContactDate contactInfoFromEditForm = app.contact().infoFormEditForm(contact);
    }
}
