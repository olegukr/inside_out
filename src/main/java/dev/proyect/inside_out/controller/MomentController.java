package dev.proyect.inside_out.controller;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import dev.proyect.inside_out.models.Moment;
import dev.proyect.inside_out.models.Emotion;
import java.time.LocalDate;  
import java.time.format.DateTimeFormatter;  

public class MomentController {
    
    // private List<Moment> moments = new ArrayList<Moment>();

    public void addMoment(String title, int emotionIndex, String description, LocalDate momentDate) {
        if (emotionIndex < 0 || emotionIndex >= Emotion.getEmotions().size()) {
            throw new IllegalArgumentException("Emoción no encontrada para el índice proporcionado.");
        }
        
        String emotion = Emotion.getEmotionByIndex(emotionIndex);
        
        Moment newMoment = new Moment(title, emotion, description, momentDate);
        
        System.out.println("Nuevo momento agregado: " + newMoment.getTitle());
    }

    // public List<Moment> deleteMoment(Moment moment){
    // }
    public List<Moment> getFilterByEmotion(int index) {
        int indexEmotion = index - 1;
        String emotion = Emotion.getEmotionByIndex(indexEmotion);
        List<Moment> momentsByEmotion = new ArrayList<Moment>();

        for (Moment moment : Moment.getMoments()) {
            if (moment.getEmotion() ==  emotion){
                momentsByEmotion.add(moment);
            }
        }
        return momentsByEmotion;
    }
    public List<Moment> getFilterByDate(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");        
        LocalDate inputDate = LocalDate.parse(date, formatter);
        List<Moment> momentsByDate = new ArrayList<Moment>();
        
        for (Moment moment : Moment.getMoments()) {
            if (moment.getMomentDate().getMonth() ==  inputDate.getMonth() && moment.getMomentDate().getYear() ==  inputDate.getYear()){
                momentsByDate.add(moment);
            }
        }
        return momentsByDate;
    }

    // updateMomentDate( Date) void {
    // }
}