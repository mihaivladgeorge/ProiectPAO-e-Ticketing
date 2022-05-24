package Repositories;

import Cards.Card;
import Entities.CardEntity;
import Mapper.CardEntityMapper;
import Services.DatabaseQueryExecutorService;

import java.util.ArrayList;
import java.util.List;

public class CardRepository {

    public static CardEntity findCard(int id) {
        List<Object> objects = DatabaseQueryExecutorService.executeReadQuery("select * from card where ownerId=" + id, new CardEntityMapper());
        CardEntity result = new CardEntity();

        for(Object o:objects) {
            if(o instanceof CardEntity) {
                result = (CardEntity) o;
            }
        }
        return result;
    }

    public static void addCard(CardEntity cardEntity) {
        DatabaseQueryExecutorService.executeUpdateQuery("insert into card(id, number, expirationDate, cvv, balance, ownerId) values('"
        + cardEntity.getId() + "', '"
        + cardEntity.getNumber() + "', '"
        + cardEntity.getExpirationDate() + "', '"
        + cardEntity.getCvv() + "', '"
        + cardEntity.getBalance() + "', '"
        + cardEntity.getOwnerId() + "')");
    }

    public static void updateCard(CardEntity cardEntity, float newBalance) {
        DatabaseQueryExecutorService.executeUpdateQuery("update card set balance=" + newBalance + " where id=" + cardEntity.getId());
    }

    public static void deleteCard(CardEntity cardEntity) {
        DatabaseQueryExecutorService.executeUpdateQuery("delete from card where id=" + cardEntity.getId());
    }
}
