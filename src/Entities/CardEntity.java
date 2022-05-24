package Entities;

public class CardEntity {
    private int id;
    private String number;
    private String expirationDate;
    private int cvv;
    private float balance;
    private int ownerId;

    public CardEntity(int id, String number, String expirationDate, int cvv, float balance, int ownerId) {
        this.id = id;
        this.number = number;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
        this.balance = balance;
        this.ownerId = ownerId;
    }

    public CardEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public String toString() {
        return "CardEntity{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                ", cvv=" + cvv +
                ", balance=" + balance +
                ", ownerId=" + ownerId +
                '}';
    }
}
