package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactEmailTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.contact().contactPage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactDate()
                    .withFirstname("Ivanov")
                    .withLastname("Ivan")
                    .withNickname("Ivancik")
                    .withCompany("LK")
                    .withAddress("RF")
                    .withEmail("test@test.ru")
                    .withEmail2("test2@test.ru")
                    .withEmail3("test3@test.ru"), true);
        }
    }

    @Test
    public void testContactEmail(){
        app.goTo().gotoHomePage();
        ContactDate contact = app.contact().all().iterator().next();
        ContactDate contactInfoFromEditForm = app.contact().infoFormEditForm(contact);

        assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));


    }

    private String mergeEmails(ContactDate contact) {
        return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
                .stream().filter((s) -> ! s.equals(""))
                .map(ContactEmailTests::cleaned)
                .collect(Collectors.joining("\n"));
    }

    private static String cleaned(String email) {
        return email.replaceAll("\\s", "").replaceAll("[()]", "").replaceAll("\n","");

    }
}
