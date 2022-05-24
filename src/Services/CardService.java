package Services;

import Cards.Card;
import Cards.CreditCard;
import Cards.DebitCard;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class CardService {

    public CardService() {
    }

    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public Card addCardHard(){
        Card crd;
        try {
            crd = new CreditCard("1234567891011125",
                    sdf.parse("29-10-2000"),
                    123,
                    10534);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return crd;
    }

    public Card addCard() {
        Scanner in = new Scanner(System.in);
        System.out.println("New Card data:");
        System.out.println("Enter type of Card: ");
        System.out.println("1. Credit Card; 2. Debit Card");
        int type = in.nextInt();
        in.nextLine();
        System.out.print("Enter Card Number: ");
        String number = in.nextLine();
        System.out.print("Enter Card Expiration Date: ");
        String expirationDate = in.nextLine();
        System.out.print("Enter Card CVV: ");
        int CVV = in.nextInt();
        in.nextLine();
        System.out.print("Enter Card Balance: ");
        int balance = in.nextInt();
        in.nextLine();

        Card crd;
        if(type == 1) {
            try {
                crd = new CreditCard(number, sdf.parse(expirationDate), CVV, balance);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            try {
                crd = new DebitCard(number, sdf.parse(expirationDate), CVV, balance);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }        }
        return crd;
    }

    public void printCard(Card crd){
        System.out.println(crd.toString());
    }

}
