package ru.stqa.pft.addressbook.model;

public class ContactDate {
    private int id = Integer.MAX_VALUE;
    private String firstname;
    private String lastname;
    private String nickname;
    private String company;
    private String address;
    private String group;
    private String homePhone;
    private String mobilePhone;
    private String workPhone;
    private String allPhones;
    private String email;
    private String email2;
    private String email3;
    private String allEmails;

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

    public ContactDate withGroup(String group) {
        this.group = group;
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

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() { return lastname; }

    public String getNickname() {
        return nickname;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public String getGroup() {
        return group;
    }

    public String getHomePhone() { return homePhone; }

    public String getMobilePhone() { return mobilePhone; }

    public String getWorkPhone() { return workPhone; }

    public String getAllPhones() { return allPhones; }

    public String getEmail() { return email; }

    public String getEmail2() { return email2; }

    public String getEmail3() { return email3; }

    public String getAllEmails() { return allEmails; }

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

    @Override
    public String toString() {
        return "ContactDate{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }


}
