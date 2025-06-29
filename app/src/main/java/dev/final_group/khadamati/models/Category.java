package dev.final_group.khadamati.models;

public class Category {
    private int id;
    private String title;
    private int iconResId;
    private String jobTitle;

    public Category(int id, String title, int iconResId, String jobTitle) {
        this.id = id;
        this.title = title;
        this.iconResId = iconResId;
        this.jobTitle = jobTitle;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
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

    public int getIconResId() {
        return iconResId;
    }

    public void setIconResId(int iconResId) {
        this.iconResId = iconResId;
    }
}
