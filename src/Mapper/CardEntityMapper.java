package Mapper;

import Entities.CardEntity;
import Entities.ClientEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CardEntityMapper implements RowMapper<CardEntity> {
    public CardEntity mapRow(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String number = resultSet.getString("number");
        String expirationDate = resultSet.getString("expirationDate");
        int cvv = resultSet.getInt("cvv");
        float balance = resultSet.getFloat("balance");
        int ownerId = resultSet.getInt("ownerId");

        return new CardEntity(id, number, expirationDate, cvv, balance, ownerId);
    }
}
