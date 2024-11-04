package dev.proyect.inside_out;
import java.io.IOException;
import java.util.Scanner;

import dev.proyect.inside_out.controller.MomentController;
import dev.proyect.inside_out.models.Moment;

public final class App {
    
    private static void pressEnterToContinue(Scanner scanner)
    {       
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
        MomentController momentController = new MomentController();
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
                System.out.println("menu 1");
                pressEnterToContinue(scanner);
            }
            else if(menuSelection == 2){
                System.out.println("menu 2");
                pressEnterToContinue(scanner);
            }
            else if(menuSelection == 3){
                System.out.println("menu 3");
                pressEnterToContinue(scanner);
            }
            else if(menuSelection == 4){
                int filterSelection;
                
                do{
                    System.err.println("");
                    System.err.println("Filtrar por ...:");
                    System.err.println("1. Emoción");
                    System.err.println("2. Fecha");
                    System.out.print("Ingrese una opción: "); 
                    filterSelection = scanner.nextInt();
                    if(filterSelection == 1){
                        
                        int emotionSelection;
                        do{
                            System.err.println("");
                            System.err.println("Selecciona una emoción:");
                            System.err.println("1. Emoción");
                            System.err.println("2. Tristeza");
                            System.err.println("3. Ira");
                            System.err.println("4. Asco");
                            System.err.println("5. Miedo");
                            System.err.println("6. Ansiedad");
                            System.err.println("7. Envidia");
                            System.err.println("8. Vergüenza");
                            System.err.println("9. Aburrimiento");
                            System.err.println("10. Nostalgia");
                            System.out.print("Ingrese una opción: "); 
                            emotionSelection = scanner.nextInt();

                            if(emotionSelection >= 1  && emotionSelection <= 10){
                                
                                for (Moment moment : momentController.getFilterByEmotion(emotionSelection)) {
                                    System.out.println();
                                    System.out.println(moment.getMomentDate());
                                    System.out.println(moment.getTitle());
                                    System.out.println(moment.getDescription());
                                    System.out.println(moment.getEmotion());
                                }
                            }
                        }while(emotionSelection < 1  || emotionSelection > 10);
                    }
                    else if(filterSelection == 2){
                        System.out.println("Filtrando por fecha");
                    }
                }while(filterSelection < 1  || filterSelection > 2);                    
                
                pressEnterToContinue(scanner);
            }
            else if(menuSelection == 5){
                flag = false;
                System.out.println("See you later...");
                break;
            }
        }
    }
}