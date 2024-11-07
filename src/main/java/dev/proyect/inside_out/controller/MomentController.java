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
    
    public static void addMomentMenu(Scanner scanner){
        System.out.println("\nSeleccione una emoción:");
        View.showAllEmotions();
        int emotionIndex;
        do{
            System.out.print("Ingrese una opción: "); 
            emotionIndex = scanner.nextInt()-1;
            scanner.nextLine();
        }while(emotionIndex < 0  || emotionIndex > 9);

        System.out.print("Ingrese el título: ");
        String title = scanner.nextLine();

        System.out.print("Ingrese la descripción: ");
        String description = scanner.nextLine();

        String message = "Ingrese la fecha del momento (dd/mm/yyyy): ";
        LocalDate momentDate = inputDate(scanner, message);

        addMoment(title, emotionIndex, description, momentDate);
        pressEnterToContinue();
    }

    public static void showMomentsMenu(){
        View.showMoments(Moment.getMoments());
        MomentController.pressEnterToContinue();
    }

    public static void deleteMomentMenu(Scanner scanner){
        List<Moment> moments = Moment.getMoments();
        if(moments.size() > 0){
            for (Moment moment : moments) {
                System.out.println("\nID: " + moment.getId());
                System.out.println("Título: " + moment.getTitle());
            }
            System.out.println("\nIngresa el identificador del momento a eliminar: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            Moment.deleteMoment(id);

        }else{
            System.out.println();
            System.out.println("\nNo hay momentos...");   
        }
          
        
        pressEnterToContinue();
    }

    public static void filterByMenu(Scanner scanner){
        int filterSelection;
                
        do{
            View.showFilterMenu();
            filterSelection = scanner.nextInt();
            scanner.nextLine();
            if(filterSelection == 1){
                
                int emotionSelection;
                do{
                    View.showAllEmotions();
                    System.out.print("Ingrese una opción: "); 
                    emotionSelection = scanner.nextInt();
                    scanner.nextLine();
                    if(emotionSelection >= 1  && emotionSelection <= 10){
                        View.showMoments(getFilterByEmotion(emotionSelection));
                    }
                }while(emotionSelection < 1  || emotionSelection > 10);
            }
            else if(filterSelection == 2){
                String message = "Ingrese mes y año para filtrar los momentos  (mm/yyyy): ";
                LocalDate momentDate = inputDate(scanner, message);
                View.showMoments(getFilterByDate(momentDate));

            }
        }while(filterSelection < 1  || filterSelection > 2);                    
        
        pressEnterToContinue();
    }

    private static void addMoment(String title, int emotionIndex, String description, LocalDate momentDate) {
        String emotion = Emotion.getEmotionByIndex(emotionIndex);
        Moment newMoment = new Moment(title, emotion, description, momentDate);
        System.out.println("Nuevo momento agregado: " + newMoment.getTitle());
    }

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

    private static LocalDate inputDate(Scanner scanner, String message) {
      
        LocalDate momentDate = null;

        while (momentDate == null) {
            System.out.println(message);
            String dateString = scanner.nextLine();
            if (dateString.length() == 7){
                dateString = "01/"+dateString;
            }
            try {
                momentDate = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha inválido. Intente de nuevo.");
            }
        }
        return momentDate;
    }

    private static void pressEnterToContinue(){   
        System.out.println("\nPress Enter key continue...");
        try {
            System.in.read(new byte[2]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}