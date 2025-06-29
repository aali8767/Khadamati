package dev.final_group.khadamati.models;

public class Profile {
    private int image;
    private int id;
    private String number_phone;
    private String name;

    public Profile(int image, int id, String number_phone, String name) {
        this.image = image;
        this.id = id;
        this.number_phone = number_phone;
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber_phone() {
        return number_phone;
    }

    public void setNumber_phone(String number_phone) {
        this.number_phone = number_phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

