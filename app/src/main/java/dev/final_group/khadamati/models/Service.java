package dev.final_group.khadamati.models;

import androidx.annotation.Nullable;

import java.io.Serializable;

public class Service implements Serializable {
    private int id;
    private int category_id;
    private int provider_id;
    private String title;
    private String details;
    private int price;
    private double rate;
    private int image;

    public Service(int id, int category_id, int provider_id, String title, String details, int price, double rate, int image) {
        this.id = id;
        this.category_id = category_id;
        this.provider_id = provider_id;
        this.title = title;
        this.details = details;
        this.price = price;
        this.rate = rate;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getProvider_id() {
        return provider_id;
    }

    public void setProvider_id(int provider_id) {
        this.provider_id = provider_id;
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

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
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

