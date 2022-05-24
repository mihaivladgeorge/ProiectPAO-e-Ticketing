package Services;

import Cards.Card;
import Cards.CreditCard;
import Entities.CardEntity;
import Repositories.CardRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DBCardService {

    public static Card getCard(int id) throws ParseException {
        CardEntity cardEntity = CardRepository.findCard(id);
        Card card = new CreditCard();

        card = new CreditCard(cardEntity.getNumber(),
                new SimpleDateFormat("dd-MM-yyyy").parse(cardEntity.getExpirationDate()),
                cardEntity.getCvv(),
                cardEntity.getBalance());

        return card;
    }

    public static void addCard(Card card, int id) {
        CardEntity cardEntity = new CardEntity();
        cardEntity.setId(card.getId());
        cardEntity.setNumber(card.getNumber());
        cardEntity.setExpirationDate(new SimpleDateFormat("dd-MM-yyyy").format(card.getExpirationDate()));
        cardEntity.setCvv(card.getCVV());
        cardEntity.setOwnerId(id);

        CardRepository.addCard(cardEntity);
    }

    public static void updateCard(Card card, int id, float newBalance) {
        CardEntity cardEntity = new CardEntity();
        cardEntity.setId(card.getId());
        cardEntity.setNumber(card.getNumber());
        cardEntity.setExpirationDate(new SimpleDateFormat("dd-MM-yyyy").format(card.getExpirationDate()));
        cardEntity.setCvv(card.getCVV());
        cardEntity.setOwnerId(id);

        CardRepository.updateCard(cardEntity, newBalance);
    }

    public static void deleteCard(Card card, int id) {
        CardEntity cardEntity = new CardEntity();
        cardEntity.setId(card.getId());
        cardEntity.setNumber(card.getNumber());
        cardEntity.setExpirationDate(new SimpleDateFormat("dd-MM-yyyy").format(card.getExpirationDate()));
        cardEntity.setCvv(card.getCVV());
        cardEntity.setOwnerId(id);

        CardRepository.deleteCard(cardEntity);
    }
}
