package dev.proyect.inside_out.controller;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import dev.proyect.inside_out.models.Moment;
import dev.proyect.inside_out.view.View;
import dev.proyect.inside_out.models.Emotion;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;  

public class MomentController{
    
    public static void addMomentMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione una emoción:");
        View.showAllEmotions();
        System.out.print("Ingrese el índice de la emoción: ");
        int emotionIndex = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Ingrese el título: ");
        String title = scanner.nextLine();

        System.out.print("Ingrese la descripción: ");
        String description = scanner.nextLine();

        LocalDate momentDate = inputDate();
        addMoment(title, emotionIndex, description, momentDate);
        pressEnterToContinue();
    }

    public static void filterByMenu(){
        Scanner scanner = new Scanner(System.in);
        int filterSelection;
                
        do{
            View.showFilterMenu();
            filterSelection = scanner.nextInt();
            if(filterSelection == 1){
                
                int emotionSelection;
                do{
                    View.showAllEmotions();
                    System.out.print("Ingrese una opción: "); 
                    emotionSelection = scanner.nextInt();
                    if(emotionSelection >= 1  && emotionSelection <= 10){
                        View.showMoments(getFilterByEmotion(emotionSelection));
                    }
                }while(emotionSelection < 1  || emotionSelection > 10);
            }
            else if(filterSelection == 2){
                LocalDate momentDate = inputDate();
                View.showMoments(getFilterByDate(momentDate));
            }
        }while(filterSelection < 1  || filterSelection > 2);                    
        
        pressEnterToContinue();
    }

    private static void addMoment(String title, int emotionIndex, String description, LocalDate momentDate) {
        if (emotionIndex < 0 || emotionIndex >= Emotion.getEmotions().size()) {
            throw new IllegalArgumentException("Emoción no encontrada para el índice proporcionado.");
        }
        
        String emotion = Emotion.getEmotionByIndex(emotionIndex);
        Moment newMoment = new Moment(title, emotion, description, momentDate);
        System.out.println("Nuevo momento agregado: " + newMoment.getTitle());
    }

    // public List<Moment> deleteMoment(Moment moment){
    // released in class Moment: deleteMoment(int id)
    // }
    private static List<Moment> getFilterByEmotion(int index) {
        String emotion = Emotion.getEmotionByIndex(index - 1);
        List<Moment> momentsByEmotion = new ArrayList<Moment>();

        for (Moment moment : Moment.getMoments()) {
            if (moment.getEmotion() ==  emotion){
                momentsByEmotion.add(moment);
            }
        }
        return momentsByEmotion;
    }

    private static List<Moment> getFilterByDate(LocalDate date){
        List<Moment> momentsByDate = new ArrayList<Moment>();
        
        for (Moment moment : Moment.getMoments()) {
            if (moment.getMomentDate().getMonth() ==  date.getMonth() && moment.getMomentDate().getYear() ==  date.getYear()){
                momentsByDate.add(moment);
            }
        }
        return momentsByDate;
    }

    private static LocalDate inputDate(){
        LocalDate momentDate = null;
        while (momentDate == null) {
            System.out.print("Ingrese la fecha del momento (dd/mm/yyyy): ");
            String dateString = new Scanner(System.in).nextLine();
            try {
                momentDate = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha inválido. Intente de nuevo.");
            }
        }
        return momentDate;
    }

    public static void pressEnterToContinue(){   
        System.out.println("");    
        System.out.println("Press Enter key continue...");
        try {
            int read = System.in.read(new byte[2]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}