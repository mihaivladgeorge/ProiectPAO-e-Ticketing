package Entities;

public class TicketEntity {
    private int id;
    private int eventId;
    private int venueId;

    public TicketEntity(int id, int eventId, int venueId) {
        this.id = id;
        this.eventId = eventId;
        this.venueId = venueId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getVenueId() {
        return venueId;
    }

    public void setVenueId(int venueId) {
        this.venueId = venueId;
    }

    @Override
    public String toString() {
        return "TicketEntity{" +
                "id=" + id +
                ", eventId=" + eventId +
                ", venueId=" + venueId +
                '}';
    }
}
