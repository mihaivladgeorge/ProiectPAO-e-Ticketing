package Repositories;

import Entities.VenueEntity;
import Mapper.VenueEntityMapper;
import Services.DatabaseQueryExecutorService;

import java.util.ArrayList;
import java.util.List;

public class VenueRepository {
    public static List<VenueEntity> findAll() {
        List<Object> objects = DatabaseQueryExecutorService.executeReadQuery("select * from venue", new VenueEntityMapper());
        List<VenueEntity> result = new ArrayList<>();

        for(Object o:objects) {
            if(o instanceof VenueEntity) {
                result.add((VenueEntity) o);
            }
            else {
                throw new RuntimeException("exception");
            }
        }
        return result;
    }

    public static void addVenue(VenueEntity venueEntity) {
        DatabaseQueryExecutorService.executeUpdateQuery("insert into venue(id, name, location, priceMultiplier) values('"
                + venueEntity.getId() + "', '"
                + venueEntity.getName() + "', '"
                + venueEntity.getLocation() + "', '" +
                + venueEntity.getPriceMultiplier() + "')");
    }

    public static void updateVenue(VenueEntity venueEntity, String replacement) {
        DatabaseQueryExecutorService.executeUpdateQuery("update venue set name='" + replacement + "' where id=" + venueEntity.getId());
    }

    public static void deleteVenue(VenueEntity venueEntity) {
        DatabaseQueryExecutorService.executeUpdateQuery("delete from venue where id=" + venueEntity.getId());
    }

}
