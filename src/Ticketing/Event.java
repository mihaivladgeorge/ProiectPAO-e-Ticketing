package Ticketing;

public class Event {
    private int Id;
    private String name;
    private String genre;
    private int lengthMinutes;
    private float basePrice;

    @Override
    public String toString() {
        return "Event{" +
                "id='" + this.Id + '\'' +
                ", name='" + this.name + '\'' +
                ", genre='" + this.genre + '\'' +
                ", lengthMinutes='" + this.lengthMinutes + '\'' +
                ", basePrice='" + this.basePrice + '\'' +
                '}';
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getLengthMinutes() {
        return lengthMinutes;
    }

    public void setLengthMinutes(int lengthMinutes) {
        this.lengthMinutes = lengthMinutes;
    }

    public float getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(float basePrice) {
        this.basePrice = basePrice;
    }

    public Event(int id, String name, String genre, int lengthMinutes, float basePrice) {
        Id = id;
        this.name = name;
        this.genre = genre;
        this.lengthMinutes = lengthMinutes;
        this.basePrice = basePrice;
    }

    public Event() {
        Id = -1;
        this.name = null;
        this.genre = null;
        this.lengthMinutes = -1;
        this.basePrice = -1;
    }

}
