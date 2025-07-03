package dev.final_group.khadamati.models;

import androidx.annotation.Nullable;

import java.io.Serializable;

public class MyService implements Serializable {
    private int id;
    private String title;
    private String details;
    private int price;
    private int image;

    public MyService(int id, String title, String details, int price, int image) {
        this.id = id;
        this.title = title;
        this.details = details;
        this.price = price;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }
}

