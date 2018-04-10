package ru.stqa.pft.addressbook.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

@XStreamAlias("contact")
@Entity
@Table(name = "addressbook")
public class ContactDate {
    @XStreamOmitField

    @Id
    @Column(name = "id")
    private int id = Integer.MAX_VALUE;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "company")
    private String company;

    @Column(name = "address")
    @Type(type = "text")
    private String address;

    @Column(name = "home")
    @Type(type = "text")
    private String homePhone;

    @Column(name = "mobile")
    @Type(type = "text")
    private String mobilePhone;

    @Column(name = "work")
    @Type(type = "text")
    private String workPhone;

    @Transient
    private String allPhones;

    @Column(name = "email")
    @Type(type = "text")
    private String email;

    @Column(name = "email2")
    @Type(type = "text")
    private String email2;

    @Column(name = "email3")
    @Type(type = "text")
    private String email3;

    @Transient
    private String allEmails;

    @Column(name = "photo")
    @Type(type = "text")
    private String photo;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "address_in_groups",
            joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "group_id"))
    private Set<GroupDate> groups = new HashSet<GroupDate>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactDate that = (ContactDate) o;

        if (id != that.id) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        return result;
    }

    //   public File getPhoto() { return new File(photo);    }

    public ContactDate withPhoto(File photo) {
        this.photo = photo.getPath();
        return this;
    }

    public ContactDate withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }

    public ContactDate withEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactDate withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public ContactDate withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

     public ContactDate withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public ContactDate withId(int id) {
        this.id = id;
        return this;
    }

    public ContactDate withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ContactDate withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactDate withNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public ContactDate withCompany(String company) {
        this.company = company;
        return this;
    }

    public ContactDate withAddress(String address) {
        this.address = address;
        return this;
    }

      public ContactDate withHomePhone(String homePhone){
        this.homePhone = homePhone;
        return this;
    }

    public ContactDate withMobilePhone(String mobilePhone){
        this.mobilePhone = mobilePhone;
        return this;
    }

    public ContactDate withWorkPhone(String workPhone){
        this.workPhone = workPhone;
        return this;
    }

    public int getId() { return id; }

    public String getFirstname() {return firstname; }

    public String getLastname() { return lastname; }

    public String getNickname() { return nickname; }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public Groups getGroups() { return new Groups(groups); }

    public String getHomePhone() { return homePhone; }

    public String getMobilePhone() { return mobilePhone; }

    public String getWorkPhone() { return workPhone; }

    public String getAllPhones() { return allPhones; }

    public String getEmail() { return email; }

    public String getEmail2() { return email2; }

    public String getEmail3() { return email3; }

    public String getAllEmails() { return allEmails; }

    @Override
    public String toString() {
        return "ContactDate{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }


}
