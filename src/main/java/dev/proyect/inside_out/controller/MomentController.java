package dev.proyect.inside_out.controller;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import dev.proyect.inside_out.models.Moment;
import dev.proyect.inside_out.models.Emotion;
import java.time.LocalDate;  
import java.time.format.DateTimeFormatter;  

public class MomentController {
    
    private List<Moment> moments = new ArrayList<Moment>();

    // public void addMoment(Moment moment){
        
    // }
    // public List<Moment> getMoments(){

    // }
    // public List<Moment> deleteMoment(Moment moment){

    // }
    public List<Moment> getFilterByEmotion(int index) {
        int indexEmotion = index - 1;
        Date momentDate = new Date();
        Moment moment1 = new Moment(1, "Mi Título", "Felicidad", "Esta es una descripción", momentDate);
        Moment moment2 = new Moment(1, "Mi Título", "Tristeza", "Esta es una descripción", momentDate);
        Moment moment3 = new Moment(1, "Mi Título", "Ansiedad", "Esta es una descripción", momentDate);
        Moment moment4 = new Moment(1, "Mi Título", "Ansiedad", "Esta es una descripción", momentDate);
        Moment moment5 = new Moment(1, "Mi Título", "Ansiedad", "Esta es una descripción", momentDate);
        Moment moment6 = new Moment(1, "Mi Título", "Aburrimiento", "Esta es una descripción", momentDate);
        moments.add(moment1);
        moments.add(moment2);
        moments.add(moment3);
        moments.add(moment4);
        moments.add(moment5);
        moments.add(moment6);

        String emotion = Emotion.getEmotionByIndex(indexEmotion);
        List<Moment> momentsByEmotion = new ArrayList<Moment>();

        for (Moment moment : moments) {
            if (moment.getEmotion() ==  emotion){
                momentsByEmotion.add(moment);
            }
        }
        return momentsByEmotion;
    }
    public List<Moment> getFilterByDate(String date){
        
        return moments;
    }

    // updateMomentDate( Date) void {

    // }
}
