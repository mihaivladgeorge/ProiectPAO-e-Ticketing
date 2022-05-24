package Cards;

import java.util.Date;

public class DebitCard extends Card{
    public DebitCard(String number, Date expirationDate, int CVV, float balance) {
        super(number, expirationDate, CVV, balance);
    }

    @Override
    public boolean makeTransaction(float price) {
        if(this.getBalance() < price)
            return false;
        this.setBalance(this.getBalance() - price);

        return true;
    }
}
