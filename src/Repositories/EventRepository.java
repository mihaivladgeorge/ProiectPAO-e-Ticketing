package Repositories;

import Entities.ClientEntity;
import Entities.EventEntity;
import Entities.EventEntity;
import Entities.VenueEntity;
import Mapper.ClientEntityMapper;
import Mapper.EventEntityMapper;
import Services.DatabaseQueryExecutorService;

import java.util.ArrayList;
import java.util.List;

public class EventRepository {

    public static List<EventEntity> findAll() {
        List<Object> objects = DatabaseQueryExecutorService.executeReadQuery("select * from event", new EventEntityMapper());
        List<EventEntity> result = new ArrayList<>();

        for(Object o:objects) {
            if(o instanceof EventEntity) {
                result.add((EventEntity) o);
            }
            else {
                throw new RuntimeException("exception");
            }
        }
        return result;
    }

    public static void addEvent(EventEntity eventEntity) {
        DatabaseQueryExecutorService.executeUpdateQuery("insert into Event(id, name, location, priceMultiplier) values('"
                + eventEntity.getId() + "', '"
                + eventEntity.getName() + "', '"
                + eventEntity.getGenre() + "', '"
                + eventEntity.getLengthMinutes() + "', '"
                + eventEntity.getBasePrice() + "')");
    }

    public static void updateEvent(EventEntity eventEntity, String replacement) {
        DatabaseQueryExecutorService.executeUpdateQuery("update event set name= '" + replacement + "' where id=" + eventEntity.getId());
    }

    public static void deleteEvent(EventEntity eventEntity) {
        DatabaseQueryExecutorService.executeUpdateQuery("delete from event where id=" + eventEntity.getId());
    }
}
