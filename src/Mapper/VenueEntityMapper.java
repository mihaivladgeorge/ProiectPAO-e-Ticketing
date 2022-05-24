package Mapper;

import Entities.EventEntity;
import Entities.VenueEntity;
import org.h2.result.Row;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VenueEntityMapper implements RowMapper<VenueEntity> {

    public VenueEntity mapRow(ResultSet resultSet) throws SQLException {

        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String location = resultSet.getString("location");
        float priceMultiplier = resultSet.getFloat("priceMultiplier");

        return new VenueEntity(id, name, location, priceMultiplier);
    }
}
