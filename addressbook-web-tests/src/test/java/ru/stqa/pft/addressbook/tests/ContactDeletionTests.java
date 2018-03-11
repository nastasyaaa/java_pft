package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

public class ContactDeletionTests extends TestBase{

    @Test
    public void testContactDeletion(){
        app.getContactHelper().returnToContactPage();
       if (! app.getContactHelper().isThisAContact()){
          app.getContactHelper().creationContact(new ContactDate("Ivanov", "Ivan", "Ivancik", "LK", "Russia", "test1"), true);
    }
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteContact();
        app.getContactHelper().endDeleteContact();
    }
}
