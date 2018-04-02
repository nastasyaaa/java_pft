package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactDate;
import ru.stqa.pft.addressbook.model.Contacts;
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
            String allPhones = element.findElements(By.tagName("td")).get(5).getText();

            contactCache.add(new ContactDate().withId(id).withFirstname(firstname).withLastname(lastname)
                    .withAllPhones(allPhones));
        }
        return new Contacts(contactCache);
    }

    public ContactDate infoFormEditForm(ContactDate contact) {
    intContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    wd.navigate().back();
    return new ContactDate()
            .withId(contact.getId())
            .withFirstname(firstname)
            .withLastname(lastname)
            .withHomePhone(home)
            .withMobilePhone(mobile)
            .withWorkPhone(work);
    }
}
