package dev.proyect.inside_out.controller;
import java.util.List;
import java.util.ArrayList;
import dev.proyect.inside_out.models.Moment;
import dev.proyect.inside_out.models.Emotion;
import java.time.LocalDate;  

public class MomentController {
    
    // private List<Moment> moments = new ArrayList<Moment>();

    public void addMoment(String title, int emotionIndex, String description, LocalDate momentDate) {
        
        String emotion = Emotion.getEmotionByIndex(emotionIndex);
        
        Moment newMoment = new Moment(title, emotion, description, momentDate);
        
        System.out.println("Nuevo momento agregado: " + newMoment.getTitle());
    }

    // public List<Moment> deleteMoment(Moment moment){
    // released in class Moment: deleteMoment(int id)
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
    public List<Moment> getFilterByDate(LocalDate date){
        List<Moment> momentsByDate = new ArrayList<Moment>();
        
        for (Moment moment : Moment.getMoments()) {
            if (moment.getMomentDate().getMonth() ==  date.getMonth() && moment.getMomentDate().getYear() ==  date.getYear()){
                momentsByDate.add(moment);
            }
        }
        return momentsByDate;
    }

    // updateMomentDate( Date) void {
    // }

}