package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactDate;

public class ContactHelper extends HelperBase{


    public ContactHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void returnToContactPage() {
        click(By.linkText("home"));
    }

    public void fillContactCreation(ContactDate contactDate) {
        type(By.name("firstname"), contactDate.getFirstname());
        type(By.name("lastname"), contactDate.getLastname());
        type(By.name("nickname"), contactDate.getNickname());
        type(By.name("company"), contactDate.getCompany());
        type(By.name("address"), contactDate.getAddress());

    }

    public void newContactCreation() {
        click(By.linkText("add new"));
    }
}
