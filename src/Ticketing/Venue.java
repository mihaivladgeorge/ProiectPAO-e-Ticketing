package Ticketing;

import java.util.ArrayList;

public class Venue {
    private int Id;
    private String name;
    private String location;
    private float priceMultiplier;
    ArrayList<Event> events = new ArrayList<>();

    @Override
    public String toString() {
        return "Venue{" +
                "Id='" + this.Id + '\'' +
                ", name='" + this.name + '\'' +
                ", location='" + this.location + '\'' +
                ", priceMultiplier='" + this.priceMultiplier + '\'' +
                '}';
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public void printEvents() {
        for(Event item:events) {
            System.out.println(item.toString());
        }
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public float getPriceMultiplier() {
        return priceMultiplier;
    }

    public void setPriceMultiplier(float priceMultiplier) {
        this.priceMultiplier = priceMultiplier;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }

    public Venue(int id, String name, String location, float priceMultiplier) {
        Id = id;
        this.name = name;
        this.location = location;
        this.priceMultiplier = priceMultiplier;
    }
}
