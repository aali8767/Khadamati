package dev.final_group.khadamati.models;

public class RatingModel {
    private String id;
    private float rating;
    private String userName;
    private int userImage;
    private String comment;
    private String serviceId;
    private String providerId;

    public RatingModel(String id, float rating, String userName, int userImage, String comment, String serviceId, String providerId) {
        this.id = id;
        this.rating = rating;
        this.userName = userName;
        this.userImage = userImage;
        this.comment = comment;
        this.serviceId = serviceId;
        this.providerId = providerId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserImage() {
        return userImage;
    }

    public void setUserImage(int userImage) {
        this.userImage = userImage;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }
}
