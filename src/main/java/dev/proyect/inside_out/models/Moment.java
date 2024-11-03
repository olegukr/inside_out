package dev.proyect.inside_out.models;

import java.time.LocalDate;
import java.util.Date;

public class Moment {
    private int id;
    private String title;
    private String emotion;
    private String description;

    private LocalDate momentDate;
    private LocalDate creationDate;
    private LocalDate modificationDate;


    // private Date momentDate;
    // private Date creationDate;
    // private Date modificationDate;

    /***
    
Starting with Java 8, the Date class is considered outdated for most new projects. It has several drawbacks, such as complexity of use, limited functionality, and lack of thread safety. Instead, it is recommended to use the new date and time API introduced in the java.time package, particularly the following classes:

LocalDate, LocalTime, and LocalDateTime: for representing a date, time, and date with time, respectively, without reference to time zones.
ZonedDateTime: for representing date and time with a time zone.
Instant: for working with timestamps (number of seconds or milliseconds since January 1, 1970).
Duration and Period: for measuring time intervals between two moments.
     ***/

    public Moment(int id, String title, String emotion, String description, LocalDate momentDate) {
        this.id = id++;
        this.title = title;
        this.emotion = emotion;
        this.description = description;
        this.momentDate = momentDate;
        this.creationDate = LocalDate.now();         
        this.modificationDate = null;


        // this.momentDate = momentDate;
        // this.creationDate = new Date();         
        // this.modificationDate = new Date();
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
    }
}
