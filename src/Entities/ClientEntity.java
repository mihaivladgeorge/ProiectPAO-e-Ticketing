package Entities;

import java.util.Date;

public class ClientEntity {
    private int id;
    private String lastName;
    private String firstName;
    private String birthday;
    private String address;
    private int cardId;

    public ClientEntity(int id, String lastName, String firstName, String birthday, String address, int cardId) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthday = birthday;
        this.address = address;
        this.cardId = cardId;
    }

    public ClientEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    @Override
    public String toString() {
        return "ClientEntity{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                ", cardId=" + cardId +
                '}';
    }
}
