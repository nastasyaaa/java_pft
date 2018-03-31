package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactDate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactHelper extends HelperBase {


    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void contactPage() {
        click(By.linkText("home"));
    }

    public void fillContactCreation(ContactDate contactDate, boolean creation) {
        type(By.name("firstname"), contactDate.getFirstname());
        type(By.name("lastname"), contactDate.getLastname());
        type(By.name("nickname"), contactDate.getNickname());
        type(By.name("company"), contactDate.getCompany());
        type(By.name("address"), contactDate.getAddress());

    }

    public void newContactCreation() {
        click(By.linkText("add new"));
    }

    public void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void deleteContact() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void intContactModification() {
        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public void endDeleteContact() {
        wd.switchTo().alert().accept();
    }

    public void submitContactCreation() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void create(ContactDate contact, boolean c) {
        newContactCreation();
        fillContactCreation(contact, c);
        submitContactCreation();
        contactPage();
    }

    public boolean isThisAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public Set<ContactDate> all() {
        Set<ContactDate> contacts = new HashSet<ContactDate>();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            String firstname = element.findElements(By.tagName("td")).get(2).getText();
            String lastname = element.findElements(By.tagName("td")).get(1).getText();
            contacts.add(new ContactDate().withId(id).withFirstname(firstname).withLastname(lastname));
        }
        return contacts;
    }

    public void fillContactForm(ContactDate contactDate, boolean creation) {
        type(By.name("firstname"), contactDate.getFirstname());
        type(By.name("lastname"), contactDate.getLastname());
        type(By.name("nickname"), contactDate.getNickname());
        type(By.name("company"), contactDate.getCompany());
        type(By.name("address"), contactDate.getAddress());

    }

    public void modifi(ContactDate contact) {
        selectContactById(contact.getId());
        intContactModification();
        fillContactForm(contact, false);
        submitContactModification();
        contactPage();
    }

    public void delete(ContactDate contact) {
        selectContactById(contact.getId());
        deleteContact();
        endDeleteContact();
    }
}
