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

    public void addMoment(String title, int emotionIndex, String description, LocalDate momentDate) {
        if (emotionIndex < 0 || emotionIndex >= Emotion.getEmotions().size()) {
            throw new IllegalArgumentException("Emoción no encontrada para el índice proporcionado.");
        }
        
        String emotion = Emotion.getEmotionByIndex(emotionIndex);
        
        Moment newMoment = new Moment(1,title, emotion, description, momentDate);
        
        System.out.println("Nuevo momento agregado: " + newMoment.getTitle());
    }
    // public List<Moment> getMoments(){

    // }
    // public List<Moment> deleteMoment(Moment moment){

    // }
    public List<Moment> getFilterByEmotion(int index) {
        int indexEmotion = index - 1;
        LocalDate fechaActual = LocalDate.now();
        Moment moment1 = new Moment(1, "Mi Título", "Felicidad", "Esta es una descripción", fechaActual);
        Moment moment2 = new Moment(1, "Mi Título", "Tristeza", "Esta es una descripción", fechaActual);
        Moment moment3 = new Moment(1, "Mi Título", "Ansiedad", "Esta es una descripción", fechaActual);
        Moment moment4 = new Moment(1, "Mi Título", "Ansiedad", "Esta es una descripción", fechaActual);
        Moment moment5 = new Moment(1, "Mi Título", "Ansiedad", "Esta es una descripción", fechaActual);
        Moment moment6 = new Moment(1, "Mi Título", "Aburrimiento", "Esta es una descripción", fechaActual);
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");        
        LocalDate inputDate = LocalDate.of(2023, 05,30);
        Moment moment1 = new Moment(1, "Mi Título", "Felicidad", "Esta es una descripción", inputDate);
        Moment moment2 = new Moment(1, "Mi Título", "Tristeza", "Esta es una descripción", inputDate);
        Moment moment3 = new Moment(1, "Mi Título", "Ansiedad", "Esta es una descripción", inputDate);
        Moment moment4 = new Moment(1, "Mi Título", "Ansiedad", "Esta es una descripción", inputDate);
        inputDate = LocalDate.of(2023, 04,30);
        Moment moment5 = new Moment(1, "Mi Título", "Ansiedad", "Esta es una descripción", inputDate);
        Moment moment6 = new Moment(1, "Mi Título", "Aburrimiento", "Esta es una descripción", inputDate);
        moments.add(moment1);
        moments.add(moment2);
        moments.add(moment3);
        moments.add(moment4);
        moments.add(moment5);
        moments.add(moment6);



        List<Moment> momentsByDate = new ArrayList<Moment>();
        inputDate = LocalDate.parse(date, formatter);
        
        for (Moment moment : moments) {
            if (moment.getMomentDate().getMonth() ==  inputDate.getMonth() && moment.getMomentDate().getYear() ==  inputDate.getYear()){
                momentsByDate.add(moment);
            }
        }
        return momentsByDate;
    }

    // updateMomentDate( Date) void {

    // }
}
