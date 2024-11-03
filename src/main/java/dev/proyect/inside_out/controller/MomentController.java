package dev.proyect.inside_out.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dev.proyect.inside_out.models.Emotion;
import dev.proyect.inside_out.models.Moment;

public class MomentController {
    
    private static List<Moment> moments = new ArrayList<>();
    private int currentId = 1;

    // public MomentController(List<Moment> moments) {
    //     this.moments = moments;
    // }
    
    public void addMoment(
        String title, 
        int emotionIndex, 
        String description, 
        LocalDate momentDate,  
        LocalDate creationDate, 
        LocalDate modificationDate) {
            
        if (emotionIndex < 0 || emotionIndex >= Emotion.getEmotions().size()) {
            throw new IllegalArgumentException("Emoción no encontrada para el índice proporcionado.");
        }
        
        String emotion = Emotion.getEmotionByIndex(emotionIndex);
        
        Moment newMoment = new Moment(currentId++, title, emotion, description, momentDate, creationDate, 
         modificationDate);
        
        moments.add(newMoment);
        System.out.println("Nuevo momento agregado: " + newMoment.getTitle());
    }

    public static List<Moment> getMoments() {
        return moments;
    }

    public static Moment getMomentById(int id){
        for (Moment moment: MomentController.moments) {
            if (moment.getId() == id) {
                return moment;
            }
        }
            return null;
    }
    

    public static void deleteMoment(int id){
        Moment moment = getMomentById(id);
        MomentController.moments.remove(moment);
    }

    // public List<Moment> getFilterByEmotion() {
        
    // }
    // public List<Moment> getFilterByDate(Date date){

    // }

    // updateMomentDate( Date) void {

    // }
}
