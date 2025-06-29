package dev.final_group.khadamati.models;

import androidx.annotation.DrawableRes;

import java.io.Serializable;

public class RequestProvider implements Serializable {
    public enum Status {RECEIVED, IN_PROGRESS, COMPLETED}

    @DrawableRes
    private int image;
    private String clientName;
    private boolean isApproved;
    private String requestTitle;
    private String description;
    private String address;
    private String phone;
    private String time;
    private Status status;
    private float rating;

    public RequestProvider(@DrawableRes int image, String clientName, boolean isApproved, String requestTitle, String description, String address, String phone, String time, Status status, float rating) {
        this.image = image;
        this.clientName = clientName;
        this.isApproved = isApproved;
        this.requestTitle = requestTitle;
        this.description = description;
        this.address = address;
        this.phone = phone;
        this.time = time;
        this.status = status;
        this.rating = rating;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public String getRequestTitle() {
        return requestTitle;
    }

    public void setRequestTitle(String requestTitle) {
        this.requestTitle = requestTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}

