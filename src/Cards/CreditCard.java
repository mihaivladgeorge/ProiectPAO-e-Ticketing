package Cards;

import java.util.Date;

public class CreditCard extends Card{
    public CreditCard(String number, Date expirationDate, int CVV, float balance) {
        super(number, expirationDate, CVV, balance);
    }

    public CreditCard() {
        super();
    }

    @Override
    public boolean makeTransaction(float price) {
        this.setBalance(this.getBalance() - price);

        return true;
    }
}
