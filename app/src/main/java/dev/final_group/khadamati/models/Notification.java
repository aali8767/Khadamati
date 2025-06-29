package dev.final_group.khadamati.models;

import java.util.Date;

public class Notification {
    private int id;
    private int providerId;
    private String title;
    private String message;
    private Date date;
    private Float rating;

    public Notification(int id, int providerId, String title, String message, Date date) {
        this.id = id;
        this.providerId = providerId;
        this.title = title;
        this.message = message;
        this.date = date;
    }

    public Notification(int id, int providerId, String title, String message, Date date, Float rating) {
        this.id = id;
        this.providerId = providerId;
        this.title = title;
        this.message = message;
        this.date = date;
        this.rating = rating;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

