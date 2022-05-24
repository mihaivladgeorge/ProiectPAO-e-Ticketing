package Mapper;

import Entities.EventEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EventEntityMapper implements RowMapper<EventEntity> {
    public EventEntity mapRow(ResultSet resultSet) throws SQLException {

        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String genre = resultSet.getString("genre");
        int lengthMinutes = resultSet.getInt("lengthMinutes");
        float basePrice = resultSet.getFloat("basePrice");

        return new EventEntity(id, name, genre, lengthMinutes, basePrice);
    }
}
