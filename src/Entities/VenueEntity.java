package Entities;

public class VenueEntity {
    private int id;
    private String name;
    private String location;
    private float priceMultiplier;

    public VenueEntity(int id, String name, String location, float priceMultiplier) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.priceMultiplier = priceMultiplier;
    }

    public VenueEntity() {
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

    @Override
    public String toString() {
        return "VenueEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", priceMultiplier=" + priceMultiplier +
                '}';
    }
}
