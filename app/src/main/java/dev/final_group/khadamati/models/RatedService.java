package dev.final_group.khadamati.models;

public class RatedService {
    private String id;
    private String name;
    private int image;
    private double rating;

    public RatedService(String id, String name, int image, double rating) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}


