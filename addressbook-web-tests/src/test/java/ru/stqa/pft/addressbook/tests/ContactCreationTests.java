package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupDate;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validContacts() {
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[]{new ContactDate().withFirstname("Ivanov").withLastname("Ivan")});
        list.add(new Object[]{new ContactDate().withFirstname("Petrov").withLastname("Petrov")});
        list.add(new Object[]{new ContactDate().withFirstname("Pavlov").withLastname("Pavel")});
        return list.iterator();
    }

    @Test(dataProvider = "validContacts")
    public void testContactCreation(ContactDate contact) {
        app.contact().contactPage();
        Contacts before = app.contact().all();
        //File photo = new File("src/test/resources/img.png"); путь к фото
       // ContactDate contact = new ContactDate().withFirstname("Ivanov").withLastname("Ivan");
        app.contact().create(contact, true);
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.contact().all();
        assertThat(after.size(), equalTo(before.size() + 1));

        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }

}
