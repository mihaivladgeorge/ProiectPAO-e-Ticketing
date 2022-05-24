package Mapper;

import Entities.CardEntity;
import Entities.ClientEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientEntityMapper implements RowMapper<ClientEntity> {
    public ClientEntity mapRow(ResultSet resultSet) throws SQLException {

        int id = resultSet.getInt("id");
        String lastname = resultSet.getString("lastname");
        String firstname = resultSet.getString("firstname");
        String birthday = resultSet.getString("birthday");
        String address = resultSet.getString("address");
        int cardId = resultSet.getInt("cardId");

        return new ClientEntity(id, lastname, firstname, birthday, address, cardId);
    }
}
