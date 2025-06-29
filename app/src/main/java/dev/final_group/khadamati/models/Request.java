package dev.final_group.khadamati.models;

import java.io.Serializable;
import java.util.Date;

public class Request implements Serializable {
    private int id;
    private String serviceTitle;
    private String serviceDetails;
    private int status;
    private Date date;

    public Request(int id, String serviceTitle, String serviceDetails, int status, Date date) {
        this.id = id;
        this.serviceTitle = serviceTitle;
        this.serviceDetails = serviceDetails;
        this.status = status;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getServiceTitle() {
        return serviceTitle;
    }

    public void setServiceTitle(String serviceTitle) {
        this.serviceTitle = serviceTitle;
    }

    public String getServiceDetails() {
        return serviceDetails;
    }

    public void setServiceDetails(String serviceDetails) {
        this.serviceDetails = serviceDetails;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

