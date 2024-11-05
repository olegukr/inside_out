package dev.proyect.inside_out;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

import dev.proyect.inside_out.controller.MomentController;
import dev.proyect.inside_out.models.Emotion;
import dev.proyect.inside_out.models.Moment;

public final class App {
    
    private static void pressEnterToContinue(Scanner scanner)
    {   System.out.println("");    
        System.out.println("Press Enter key continue...");
        try {
            int read = System.in.read(new byte[2]);
        } catch (IOException e) {
            e.printStackTrace();
        }
         
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        MomentController controller = new MomentController();
        while(flag){
            int menuSelection;
            System.err.println("");
            System.err.println("My diario:");
            System.err.println("1. Añadir momento");
            System.err.println("2. Ver todos los momentos disponibles");
            System.err.println("3. Eliminar un momento");
            System.err.println("4. Filtrar los momentos");
            System.err.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            menuSelection = scanner.nextInt();
            if(menuSelection == 1){
                // MomentController controller = new MomentController();
                
                System.out.println("Seleccione una emoción:");
                List<String> emotions = Emotion.getEmotions();
                for (int i = 0; i < emotions.size(); i++) {
                    System.out.println(i + ". " + emotions.get(i));
                }
                System.out.print("Ingrese el índice de la emoción: ");
                int emotionIndex = scanner.nextInt();
                scanner.nextLine(); 

                System.out.print("Ingrese el título: ");
                String title = scanner.nextLine();

                System.out.print("Ingrese la descripción: ");
                String description = scanner.nextLine();

                LocalDate momentDate = null;
                while (momentDate == null) {
                    System.out.print("Ingrese la fecha del momento (dd/MM/yyyy): ");
                    String dateString = scanner.nextLine();
                    try {
                        momentDate = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    } catch (DateTimeParseException e) {
                        System.out.println("Formato de fecha inválido. Intente de nuevo.");
                    }
                }
                controller.addMoment(title, emotionIndex, description, momentDate);
                pressEnterToContinue(scanner);
            }
            else if(menuSelection == 2){
                System.out.println("menu 2");
                List<Moment> moments = Moment.getMoments();
                for (Moment moment : moments) {
                    System.out.println("ID: " + moment.getId());
                    System.out.println("Título: " + moment.getTitle());
                    System.out.println("Emoción: " + moment.getEmotion());
                    System.out.println("Descripción: " + moment.getDescription());
                    System.out.println("Fecha del momento: " + moment.getMomentDate());
                    System.out.println("Fecha del CreationDate: " + moment.getCreationDate());
                    System.out.println("Fecha del ModificationDate: " + moment.getModificationDate());
                }
                pressEnterToContinue(scanner);
            }
            else if(menuSelection == 3){
                System.out.println("menu 3");
                System.out.print("Ingresa el identificador del momento: ");
                int id = scanner.nextInt();
                scanner.nextLine(); // clear scanner buffer
                Moment.deleteMoment(id);
                pressEnterToContinue(scanner);
            }
            else if(menuSelection == 4){
                int filterSelection;
                
                do{
                    System.out.println("");
                    System.out.println("Filtrar por ...:");
                    System.out.println("1. Emoción");
                    System.out.println("2. Fecha");
                    System.out.print("Ingrese una opción: "); 
                    filterSelection = scanner.nextInt();
                    if(filterSelection == 1){
                        
                        int emotionSelection;
                        do{
                            System.out.println("");
                            List<String> emotions = Emotion.getEmotions();
                            for (int i = 0; i < emotions.size(); i++) {
                                System.out.println(i+1 + ". " + emotions.get(i));
                            }
                            System.out.print("Ingrese una opción: "); 
                            emotionSelection = scanner.nextInt();

                            if(emotionSelection >= 1  && emotionSelection <= 10){
                                List<Moment> filteredByEmotion = controller.getFilterByEmotion(emotionSelection);
                                for (Moment moment : filteredByEmotion) {
                                    System.out.println();
                                    System.out.println(moment.getMomentDate());
                                    System.out.println(moment.getTitle());
                                    System.out.println(moment.getDescription());
                                    System.out.println(moment.getEmotion());
                                }
                                if( filteredByEmotion.size() == 0){
                                    System.out.println("");
                                    System.out.println("No hay momentos...");   
                                }
                            }
                        }while(emotionSelection < 1  || emotionSelection > 10);
                    }
                    else if(filterSelection == 2){
                       
                        LocalDate momentDate = null;
                        while (momentDate == null) {
                                String date = new String();
                                System.out.print("Ingrese una fecha (dd/mm/year) para filtar por mes y año: ");
                                date = scanner.next();
                            try {
                                momentDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                            } catch (DateTimeParseException e) {
                                System.out.println("Formato de fecha inválido. Intente de nuevo.");
                            }
                        }
                        
                        List<Moment> filteredByDate = controller.getFilterByDate(momentDate);
                        for (Moment moment : filteredByDate) {
                            System.out.println("");
                            System.out.println("ID: " + moment.getId());
                            System.out.println("Título: " + moment.getTitle());
                            System.out.println("Emoción: " + moment.getEmotion());
                            System.out.println("Descripción: " + moment.getDescription());
                            System.out.println("Fecha del momento: " + moment.getMomentDate());
                            System.out.println("Fecha del CreationDate: " + moment.getCreationDate());
                            System.out.println("Fecha del ModificationDate: " + moment.getModificationDate());
                        }
                        if( filteredByDate.size() == 0){
                            System.out.println("");
                            System.out.println("No hay momentos...");   
                        }
                    }
                }while(filterSelection < 1  || filterSelection > 2);                    
                
                pressEnterToContinue(scanner);
            }
            else if(menuSelection == 5){
                flag = false;
                System.out.println("");
                System.out.println("See you later...");
            }
        }
    }
}