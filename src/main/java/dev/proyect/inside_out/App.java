package dev.proyect.inside_out;
import java.io.IOException;
import java.util.Scanner;
import dev.proyect.inside_out.models.Moment;
import dev.proyect.inside_out.controller.MomentController;

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
            System.out.println("");
            System.out.println("My diario:");
            System.out.println("1. Añadir momento");
            System.out.println("2. Ver todos los momentos disponibles");
            System.out.println("3. Eliminar un momento");
            System.out.println("4. Filtrar los momentos");
            System.out.println("5. Salir");
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
                            System.out.println("Selecciona una emoción:");
                            System.out.println("1. Emoción");
                            System.out.println("2. Tristeza");
                            System.out.println("3. Ira");
                            System.out.println("4. Asco");
                            System.out.println("5. Miedo");
                            System.out.println("6. Ansiedad");
                            System.out.println("7. Envidia");
                            System.out.println("8. Vergüenza");
                            System.out.println("9. Aburrimiento");
                            System.out.println("10. Nostalgia");
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
                        String date = new String();
                        System.out.print("Ingrese una fecha (dd/mm/year): ");
                        date = scanner.next();
                        momentController.getFilterByDate(date);
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
