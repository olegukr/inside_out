package dev.proyect.inside_out.controller;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import dev.proyect.inside_out.models.Emotion;
import dev.proyect.inside_out.models.Moment;

public class MomentController {
    
    List<Moment> moments = new ArrayList<Moment>();

    private List<Moment> moments = new ArrayList<>();
    private int currentId = 1;

    public void addMoment(String title, int emotionIndex, String description, Date momentDate) {
        if (emotionIndex < 0 || emotionIndex >= Emotion.getEmotions().size()) {
            throw new IllegalArgumentException("Emoción no encontrada para el índice proporcionado.");
        }
        
        String emotion = Emotion.getEmotionByIndex(emotionIndex);
        
        Moment newMoment = new Moment(currentId++, title, emotion, description, momentDate);
        
        moments.add(newMoment);
        System.out.println("Nuevo momento agregado: " + newMoment.getTitle());
    }

    public List<Moment> getMoments() {
        return moments;
    }

    // public List<Moment> getMoments(){

    // }
    // public List<Moment> deleteMoment(Moment moment){

    // }
    // public List<Moment> getFilterByEmotion() {
        
    // }
    // public List<Moment> getFilterByDate(Date date){

    // }

    // updateMomentDate( Date) void {

    // }
}
