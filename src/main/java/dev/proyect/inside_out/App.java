package dev.proyect.inside_out;
import java.util.Scanner;

import dev.proyect.inside_out.controller.MomentController;
import dev.proyect.inside_out.controller.MomentController.*;
import dev.proyect.inside_out.models.Emotion;
import dev.proyect.inside_out.models.Moment;

import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public final class App {
    
    private static void pressEnterToContinue()
    {       
            Scanner scanner = new Scanner(System.in);

            System.out.println("Press Enter key continue...");
            try
            {
                System.in.read();
                scanner.nextLine();
            }  
            catch(Exception e)
            {}  
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int menuSelection = -1;

        while(menuSelection >= 1  || menuSelection <= 5){
            System.err.println("My diario:");
            System.err.println("1. Añadir momento");
            System.err.println("2. Ver todos los momentos disponibles");
            System.err.println("3. Eliminar un momento");
            System.err.println("4. Filtrar los momentos");
            System.err.println("5. Salir");
            System.out.print("Seleccione una opción: "); 
            menuSelection = scanner.nextInt();


            if(menuSelection == 1){
                MomentController controller = new MomentController();
                //Scanner scanner = new Scanner(System.in);
        
                System.out.println("Añadir un nuevo momento:");
        
                // Solicitar título
                System.out.print("Ingrese el título: ");
                String title = scanner.nextLine();
        
                // Solicitar emoción
                System.out.println("Seleccione una emoción:");
                List<String> emotions = Emotion.getEmotions();
                for (int i = 0; i < emotions.size(); i++) {
                    System.out.println(i + ". " + emotions.get(i));
                }
                System.out.print("Ingrese el índice de la emoción: ");
                int emotionIndex = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer
        
                // Solicitar descripción
                System.out.print("Ingrese la descripción: ");
                String description = scanner.nextLine();
        
                // Solicitar fecha del momento
                System.out.print("Ingrese la fecha del momento (dd/MM/yyyy): ");
                String dateString = scanner.nextLine();
                Date momentDate;
                try {
                    momentDate = new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
                } catch (ParseException e) {
                    System.out.println("Formato de fecha inválido. Se utilizará la fecha actual.");
                    momentDate = new Date();
                }
        
                // Agregar momento al controlador
                controller.addMoment(title, emotionIndex, description, momentDate);
        
                // Mostrar todos los momentos después de agregar el nuevo
                System.out.println("\nLista actualizada de momentos:");
                List<Moment> moments = controller.getMoments();
                for (Moment moment : moments) {
                    System.out.println("ID: " + moment.getId());
                    System.out.println("Título: " + moment.getTitle());
                    System.out.println("Emoción: " + moment.getEmotion());
                    System.out.println("Descripción: " + moment.getDescription());
                    System.out.println("Fecha del momento: " + moment.getMomentDate());
                    System.out.println();
                }
        
                scanner.close();
                pressEnterToContinue();
            }
            else if(menuSelection == 2){
                System.out.println("menu 2");
                pressEnterToContinue();
            }
            else if(menuSelection == 3){
                System.out.println("menu 3");
                pressEnterToContinue();
            }
            else if(menuSelection == 4){
                System.out.println("menu 4");
                pressEnterToContinue();
            }
            else if(menuSelection == 5){
                System.out.println("See you later");
                break;
            }

        }

    }
}
