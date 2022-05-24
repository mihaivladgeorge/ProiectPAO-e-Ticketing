package Clients;

import java.util.Date;

abstract public class Person {

    protected String lastName;
    protected String firstName;
    protected Date birthday;
    protected String address;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Person(String lastName, String firstName, Date birthday, String address) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthday = birthday;
        this.address = address;
    }

    public Person() {
        this.lastName = null;
        this.firstName = null;
        this.birthday = null;
        this.address = null;
    }

}
