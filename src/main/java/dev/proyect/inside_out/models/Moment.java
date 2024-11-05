package dev.proyect.inside_out.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Moment {
    private int id;
    private String title;
    private String emotion;
    private String description;
    private LocalDate momentDate;
    private LocalDate creationDate;
    private LocalDate modificationDate;
    private static List<Moment> moments = new ArrayList<>();
    private static int maxId;

    public Moment(String title, String emotion, String description, LocalDate momentDate) {
        this.id = maxId++;
        this.title = title;
        this.emotion = emotion;
        this.description = description;
        this.momentDate = momentDate;
        this.creationDate = LocalDate.now();
        this.modificationDate = LocalDate.now();
        moments.add(this);
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
    public static List<Moment> getMoments() {
        return moments;
    }

    public static Moment getMomentById(int index) {
        return moments.get(index);
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

    public void setMomentDate(LocalDate momentDate) {
        this.momentDate = momentDate;
        updateModificationDate();
    }
    private void updateModificationDate() {
        this.modificationDate = LocalDate.now();
    }

    public static void deleteMoment(int id){
        var moment = Moment.getMomentById(id);
        var moments = Moment.getMoments();
        moments.remove(moment);
    }
}









