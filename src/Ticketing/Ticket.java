package Ticketing;

public class Ticket {
    private static int id;
    private Event event;
    private Venue venue;

    private float price;

    @Override
    public String toString() {
        return "Ticket{" +
                "id='" + Ticket.getId() + '\'' + ", " +  "\n\t\t" +
                event.toString() + ", " +  "\n\t\t" +
                venue.toString() +
                ", \n\t\tprice='" + this.price + '\'' +
                '}';
    }

    public static void IncrementId() {
        id++;
    }

    public Ticket(Event event, Venue venue) {
        this.event = event;
        this.venue = venue;
        Ticket.IncrementId();
        this.price = event.getBasePrice() * venue.getPriceMultiplier();
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Ticket.id = id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }
}
