package dev.proyect.inside_out.helpers;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import dev.proyect.inside_out.models.Emotion;
import dev.proyect.inside_out.models.Moment;

public class Helpers {

    public static void addMoment(String title, int emotionIndex, String description, LocalDate momentDate) {
        String emotion = Emotion.getEmotionByIndex(emotionIndex);
        Moment newMoment = new Moment(title, emotion, description, momentDate);
        System.out.println("Nuevo momento agregado: " + newMoment.getTitle());
    }

    public static List<Moment> getFilterByEmotion(int index) {
        String emotion = Emotion.getEmotionByIndex(index);
        List<Moment> momentsByEmotion = new ArrayList<Moment>();
        for (Moment moment : Moment.getMoments()) {
            if (moment.getEmotion() ==  emotion){
                momentsByEmotion.add(moment);
            }
        }
        return momentsByEmotion;
    }

    public static List<Moment> getFilterByDate(LocalDate date){
        List<Moment> momentsByDate = new ArrayList<Moment>();
        for (Moment moment : Moment.getMoments()) {
            if (moment.getMomentDate().getMonth() ==  date.getMonth() && moment.getMomentDate().getYear() ==  date.getYear()){
                momentsByDate.add(moment);
            }
        }
        return momentsByDate;
    }


    public static LocalDate inputDate(Scanner scanner, String message) {
        LocalDate momentDate = null;
        while (momentDate == null) {
            System.out.println(message);
            String dateString = scanner.nextLine();
            if (dateString.length() == 7){
                dateString = "01/"+dateString;
            }
            try {
                momentDate = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                return momentDate;
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha inválido. Intente de nuevo.");
            }
        }
        return null;
    }

    public static void pressEnterToContinue(){   
        System.out.println("\nPresiona Enter para continuar...");
        try {
            System.in.read(new byte[2]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
