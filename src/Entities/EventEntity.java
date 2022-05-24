package Entities;

public class EventEntity {
    private int id;
    private String name;
    private String genre;
    private int lengthMinutes;
    private float basePrice;

    public EventEntity(int id, String name, String genre, int lengthMinutes, float basePrice) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.lengthMinutes = lengthMinutes;
        this.basePrice = basePrice;
    }

    public EventEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "EventEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", lengthMinutes=" + lengthMinutes +
                ", basePrice=" + basePrice +
                '}';
    }
}
