package dev.proyect.inside_out.view;

import java.util.List;

import dev.proyect.inside_out.controller.MomentController;
import dev.proyect.inside_out.models.Emotion;
import dev.proyect.inside_out.models.Moment;

public class View {


    public static void showMainMenu() {
        
        System.err.println("\n My diario:\n");
        System.err.println("1. Añadir momento");
        System.err.println("2. Ver todos los momentos disponibles");
        System.err.println("3. Eliminar un momento");
        System.err.println("4. Filtrar los momentos");
        System.err.println("5. Salir");
        System.out.print("\nSeleccione una opción: "); 
    }

    // Show List All Emotions with Number. Numbers start from 0
    
    public static void showAllEmotions() {
        System.out.println("Ingrese el índice de la emoción: \n");
        List emotions = Emotion.getEmotions();

        for (int i = 0; i < emotions.size(); i++) {
            System.out.println(i + ". " + emotions.get(i));
        }       
    }

    // Show  All Moments

    public static void showAllMoments() {

        System.out.println("\n Lista actualizada de momentos: \n");
        List<Moment> moments = MomentController.getMoments();
        for (Moment moment : moments) {
            showMoment(moment);
        }
    }

    // Show Moment by ID

    public static void showMomentById(int id) {

        System.out.println("\n Actualizada de momento por id: " + id);
        Moment moment = MomentController.getMomentById(id);
        showMoment(moment);
        }

        // Show Moment

    public static void showMoment(Moment moment) {
        System.out.println("ID: " + moment.getId());
        System.out.println("Título: " + moment.getTitle());
        System.out.println("Emoción: " + moment.getEmotion());
        System.out.println("Descripción: " + moment.getDescription());
        System.out.println("Fecha del momento: " + moment.getMomentDate());
        System.out.println("Fecha del CreationDate: " + moment.getCreationDate());
        System.out.println("Fecha del ModificationDate: " + moment.getModificationDate());
        System.out.println();
        
    }


    }


