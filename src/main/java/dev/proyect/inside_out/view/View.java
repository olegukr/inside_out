package dev.proyect.inside_out.view;
import java.util.List;

import dev.proyect.inside_out.models.Emotion;
import dev.proyect.inside_out.models.Moment;

public class View {

    public static void showMainMenu() {
        System.out.println("\nMy diario:");
        System.out.println("1. Añadir momento");
        System.out.println("2. Ver todos los momentos disponibles");
        System.out.println("3. Eliminar un momento");
        System.out.println("4. Filtrar los momentos");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public static void showAllEmotions() {
        List<String> emotions = Emotion.getEmotions();

        System.out.println();
        for (int i = 0; i < emotions.size(); i++) {
            System.out.println(i+1 + ". " + emotions.get(i));
        }
        if( emotions.size() == 0){
            System.out.println("No hay momentos...");   
        }       
    }

    public static void showMoments(List<Moment> moments) {

        for (Moment moment : moments) {
            showMoment(moment);
        }
        if( moments.size() == 0){
            System.out.println("\nNo hay momentos...");   
        }
    }

    public static void showFilterMenu(){
        System.out.println("\nFiltrar por ...:");
        System.out.println("1. Emoción");
        System.out.println("2. Fecha");
        System.out.print("Ingrese una opción: "); 
    }


    public static void showMoment(Moment moment) {
        System.out.println("\nID: " + moment.getId());
        System.out.println("Título: " + moment.getTitle());
        System.out.println("Emoción: " + moment.getEmotion());
        System.out.println("Descripción: " + moment.getDescription());
        System.out.println("Fecha del momento: " + moment.getMomentDate());
        System.out.println("Fecha del CreationDate: " + moment.getCreationDate());
        System.out.println("Fecha del ModificationDate: " + moment.getModificationDate());
        
    }

}


