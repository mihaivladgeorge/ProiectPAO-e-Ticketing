package Cards;

import java.util.Date;

abstract public class Card {
    protected String number;
    protected Date expirationDate;
    protected int CVV;
    protected float balance;
    private static int id;

    public static void IncrementId() {
        id++;
    }

    @Override
    public String toString() {
        return "Card{" +
                "number='" + this.number + '\'' +
                ", expirationDate='" + this.expirationDate + '\'' +
                ", CVV='" + this.CVV + '\'' +
                ", balance='" + this.balance + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getCVV() {
        return CVV;
    }

    public void setCVV(int CVV) {
        this.CVV = CVV;
    }

    public float getBalance() {
        return balance;
    }

    public Card(String number, Date expirationDate, int CVV, float balance) {
        this.number = number;
        this.expirationDate = expirationDate;
        this.CVV = CVV;
        this.balance = balance;
        Card.IncrementId();
    }

    public Card() {
        this.number = null;
        this.expirationDate = null;
        this.CVV = 0;
        this.balance = 0;
    }

    abstract public boolean makeTransaction(float price);
}
