package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactDate;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupDate;
import ru.stqa.pft.addressbook.model.Groups;

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
       // attach(By.name("photo"), contactDate.getPhoto());
        type(By.name("nickname"), contactDate.getNickname());
        type(By.name("company"), contactDate.getCompany());
        type(By.name("address"), contactDate.getAddress());
        type(By.name("email"), contactDate.getEmail());
        type(By.name("email2"), contactDate.getEmail2());
        type(By.name("email3"), contactDate.getEmail3());

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

    public void intContactModificationById(int id) {
        wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
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
        contactCache = null;
        contactPage();
    }

    public void fillContactForm(ContactDate contactDate, boolean creation) {
        type(By.name("firstname"), contactDate.getFirstname());
        type(By.name("lastname"), contactDate.getLastname());
        type(By.name("nickname"), contactDate.getNickname());
        type(By.name("company"), contactDate.getCompany());
        type(By.name("address"), contactDate.getAddress());
        type(By.name("email"), contactDate.getEmail());
        type(By.name("email2"), contactDate.getEmail2());
        type(By.name("email3"), contactDate.getEmail3());
    }

    public void modifi(ContactDate contact) {
        intContactModificationById(contact.getId());
        fillContactForm(contact, false);
        submitContactModification();
        contactCache = null;
        contactPage();
    }

    public void delete(ContactDate contact) {
        selectContactById(contact.getId());
        deleteContact();
        endDeleteContact();
        contactCache = null;
    }

    public boolean isThisAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }

    private Contacts contactCache = null;

    public Contacts all() {
        if (contactCache != null){
            return new Contacts(contactCache);
        }
        contactCache = new Contacts();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            String lastname = element.findElements(By.tagName("td")).get(1).getText();
            String firstname = element.findElements(By.tagName("td")).get(2).getText();
            String address = element.findElements(By.tagName("td")).get(3).getText();
            String allEmails = element.findElements(By.tagName("td")).get(4).getText();
            String allPhones = element.findElements(By.tagName("td")).get(5).getText();

            contactCache.add(new ContactDate()
                    .withId(id)
                    .withFirstname(firstname)
                    .withLastname(lastname)
                    .withAddress(address)
                    .withAllPhones(allPhones)
                    .withAllEmails(allEmails));
        }
        return new Contacts(contactCache);
    }

    public ContactDate infoFormEditForm(ContactDate contact) {
    intContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");

    wd.navigate().back();
    return new ContactDate()
            .withId(contact.getId())
            .withFirstname(firstname)
            .withLastname(lastname)
            .withAddress(address)
            .withHomePhone(home)
            .withMobilePhone(mobile)
            .withWorkPhone(work)
            .withEmail(email)
            .withEmail2(email2)
            .withEmail3(email3);
    }

    public void add(ContactDate addContact) {
        selectContactById(addContact.getId());
        submitContactAddInGroup();
        contactPage();
        contactCache = null;
    }

    private void submitContactAddInGroup() {
        click(By.cssSelector("input[name='add']"));

    }

    public void remove(ContactDate contact, GroupDate group) {
        selectRemoveContactById(contact.getId());
        goToContactsFromGroupsPage(group.getId());
        selectContactById(contact.getId());
        submitContactRemoveFromGroup();
        contactPage();
        contactCache = null;

    }

    private void selectRemoveContactById(int id) {
        wd.findElement(By.cssSelector(String.format("a[href='view.php?id=%s']", id))).click();
    }

    private void submitContactRemoveFromGroup() {
        click(By.cssSelector("input[name='remove']"));
    }

    private void goToContactsFromGroupsPage(int group) {
        click(By.xpath("//div/div[4]/i/a"));
        //wd.findElement(By.cssSelector(String.format("a[href='./index.php?group=%s']", group))).click();
    }


    }

