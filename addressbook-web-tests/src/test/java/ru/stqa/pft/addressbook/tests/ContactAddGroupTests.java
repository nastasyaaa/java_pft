package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupDate;
import ru.stqa.pft.addressbook.model.Groups;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddGroupTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().contacts().isEmpty()) {
            Groups groups = app.db().groups();
            GroupDate groupDate;

            if (groups.isEmpty()) {
                app.goTo().groupPage();
                groupDate = new GroupDate()
                        .withName("test");
                app.group().create(groupDate);
            } else {
                groupDate = groups.iterator().next();
            }

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
    }


    @Test
    public void testContactAddGroup() {
        Contacts before = app.db().contacts();
        ContactDate addContact = before.iterator().next();
        app.contact().add(addContact);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before));
        verifyContactListInUI();
    }


}