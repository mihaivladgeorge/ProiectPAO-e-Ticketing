package Services;

import Entities.EventEntity;
import Repositories.EventRepository;
import Ticketing.Event;

import java.util.ArrayList;
import java.util.List;

public class DBEventService {

    public static List<Event> getAllEvents() {
        List<EventEntity> eventEntities = EventRepository.findAll();
        List<Event> result = new ArrayList<>();

        TicketingService ticketingService = new TicketingService();

        for(EventEntity evE:eventEntities) {
            result.add(new Event(evE.getId(), evE.getName(), evE.getGenre(),evE.getLengthMinutes(),evE.getBasePrice()));
        }

        return result;
    }

    public static void addEvent(Event ev) {
        EventEntity eventEntity = new EventEntity();
        eventEntity.setId(ev.getId());
        eventEntity.setName(ev.getName());
        eventEntity.setGenre(ev.getGenre());
        eventEntity.setLengthMinutes(ev.getLengthMinutes());
        eventEntity.setBasePrice(ev.getBasePrice());

        EventRepository.addEvent(eventEntity);
    }

    public static void updateEvent(Event ev, String replacement) {
        EventEntity eventEntity = new EventEntity();
        eventEntity.setId(ev.getId());
        eventEntity.setName(ev.getName());
        eventEntity.setGenre(ev.getGenre());
        eventEntity.setLengthMinutes(ev.getLengthMinutes());
        eventEntity.setBasePrice(ev.getBasePrice());

        EventRepository.updateEvent(eventEntity, replacement);
    }

    public static void deleteEvent(Event ev) {
        EventEntity eventEntity = new EventEntity();
        eventEntity.setId(ev.getId());
        eventEntity.setName(ev.getName());
        eventEntity.setGenre(ev.getGenre());
        eventEntity.setLengthMinutes(ev.getLengthMinutes());
        eventEntity.setBasePrice(ev.getBasePrice());

        EventRepository.deleteEvent(eventEntity);
    }
}
