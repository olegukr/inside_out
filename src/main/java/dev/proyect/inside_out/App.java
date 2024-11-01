package dev.proyect.inside_out;
import java.util.Scanner;

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
                System.out.println("menu 1");
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
