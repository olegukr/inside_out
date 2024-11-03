package dev.proyect.inside_out.models;

import java.time.LocalDate;

public class Moment {
    private int id = 0;
    private String title;
    private String emotion;
    private String description;
    private LocalDate momentDate;
    private final LocalDate creationDate;
    private LocalDate modificationDate;
    
    public Moment(
        int id, 
        String title, 
        String emotion, 
        String description, 
        LocalDate momentDate, 
        LocalDate creationDate, 
        LocalDate modificationDate) {
            
            this.id = id++;
            this.title = title;
            this.emotion = emotion;
            this.description = description;
            this.momentDate = momentDate;
            this.creationDate = creationDate;
            this.modificationDate = modificationDate;
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

    public LocalDate getMomentDate() {
        return momentDate;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public LocalDate getModificationDate() {
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

    public void setMomentDate(LocalDate newMomentDate) {
        this.momentDate = newMomentDate;
        updateModificationDate();
    }

    private void updateModificationDate() {
        this.modificationDate = LocalDate.now();
    }
}
