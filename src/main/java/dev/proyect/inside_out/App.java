package dev.proyect.inside_out;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import dev.proyect.inside_out.controller.MomentController;
import dev.proyect.inside_out.view.View;

public final class App {
    
    private static void pressEnterToContinue(Scanner scanner)
    {       
            System.out.println("Press Enter key continue...");
            scanner.nextLine();
         
    }
    public static void main(String[] args) {
        MomentController controller = new MomentController();
        Scanner scanner = new Scanner(System.in);
        // int menuSelection = -1;
        boolean exit = false;

        while (!exit) {

            View.showMainMenu();
            int menuSelection = scanner.nextInt();
            scanner.nextLine(); // clear scanner buffer             
            
            switch (menuSelection) {
                case 1:
                    {
                        System.out.println("\n Añadir un nuevo momento: ");

                        // Solicitar título

                        System.out.print("\n Ingrese el título: ");
                        String title = scanner.nextLine();
                        System.out.println();

                        // Solicitar emoción

                        View.showAllEmotions();
                        System.out.print("\n Seleccione una emoción: ");
                        int emotionIndex = scanner.nextInt();
                        scanner.nextLine(); // Limpiar el buffer

                        // Solicitar descripción

                        System.out.print("\n Ingrese la descripción: ");
                        String description = scanner.nextLine();

                        // Solicitar fecha del momento
                        
                        LocalDate momentDate = null;
                        
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        while (momentDate == null) {
                            System.out.print("\n Ingrese la fecha del momento (dd/MM/yyyy): ");
                            String dateString = scanner.nextLine();
                            
                            try {
                                momentDate = LocalDate.parse(dateString, formatter);
                                System.out.println("\n fecha del momento: " + momentDate.format(formatter)); // for test - should be deleted
                            } catch (DateTimeParseException e) {
                                System.out.println("\n Formato de fecha inválido. Se utilizará la fecha actual.");
                            }
                        }       
                        
                        LocalDate creationDate = LocalDate.now();
                        LocalDate modificationDate = null;

                        // Agregar momento al controlador

                        controller.addMoment(title, emotionIndex, description, momentDate, creationDate, modificationDate);
                        // Mostrar todos los momentos después de agregar el nuevo
     
                        View.showAllMoments();
                        // pressEnterToContinue(scanner);
                        break;
                    }

                case 2:
                    {
                        System.out.println("\n menu 2");
                        // Mostrar todos los momentos
                        View.showAllMoments();     
                        // pressEnterToContinue(scanner);
                        break;
                    }

                case 3:
                    System.out.println("\n menu 3");
                    System.out.print("Ingresa el identificador del momento: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // clear scanner buffer  
                    MomentController.deleteMoment(id);
                    // pressEnterToContinue(scanner);
                    break;

                case 4:
                    System.out.println("menu 4");
                    pressEnterToContinue(scanner);
                    break;

                case 5:
                    System.out.println("See you later");
                    scanner.close();
                    exit = true;
                    break;

                case -1:
                    break;

                default:
                    System.out.println("\n Wrong choice. Try again.");
                    break;
            }
        }

    }
}
