package dev.proyect.inside_out.models;

import java.util.Date;

public class Moment {
    private int id;
    private String title;
    private String emotion;
    private String description;
    private Date momentDate;
    private Date creationDate;
    private Date modificationDate;

    public Moment(int id, String title, String emotion, String description, Date momentDate) {
        this.id = id;
        this.title = title;
        this.emotion = emotion;
        this.description = description;
        this.momentDate = momentDate;
        this.creationDate = new Date();
        this.modificationDate = new Date();
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getEmotion() {
        return emotion;
    }

    public String getDescription() {
        return description;
    }

    public Date getMomentDate() {
        return momentDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setTitle(String title) {
        this.title = title;
        updateModificationDate();
    }

    public void setEmotion(String emotion) {
        this.emotion = emotion;
        updateModificationDate();
    }

    public void setDescription(String description) {
        this.description = description;
        updateModificationDate();
    }

    public void setMomentDate(Date momentDate) {
        this.momentDate = momentDate;
        updateModificationDate();
    }

    private void updateModificationDate() {
        this.modificationDate = new Date();
    }}
