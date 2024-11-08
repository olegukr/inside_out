package dev.proyect.inside_out.controller;
import java.util.List;
import java.util.Scanner;
import dev.proyect.inside_out.models.Moment;
import dev.proyect.inside_out.view.View;
import dev.proyect.inside_out.helpers.Helpers;
import java.time.LocalDate;

public class MomentController{
    
    public static void start(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            View.showMainMenu();
            int menuSelection = scanner.nextInt();
            scanner.nextLine();

            if(menuSelection == 1){
                addMomentMenu( scanner);
            }
            else if(menuSelection == 2){
                showMomentsMenu();
            }
            else if(menuSelection == 3){
                deleteMomentMenu(scanner);
            }
            else if(menuSelection == 4){
                filterByMenu(scanner);
            }
            else if(menuSelection == 5){
                scanner.close();
                break;
            }
        }
    }

    public static void addMomentMenu(Scanner scanner){
        int emotionIndex = View.inputEmotionSelection(scanner);
        System.out.print("Ingrese el título: ");
        String title = scanner.nextLine();

        System.out.print("Ingrese la descripción: ");
        String description = scanner.nextLine();

        LocalDate momentDate = Helpers.inputDate(scanner, "Ingrese la fecha del momento (dd/mm/yyyy): ");
        Helpers.addMoment(title, emotionIndex, description, momentDate);
        Helpers.pressEnterToContinue();
    }

    public static void showMomentsMenu(){
        View.showMoments(Moment.getMoments());
        Helpers.pressEnterToContinue();
    }

    public static void deleteMomentMenu(Scanner scanner){
        List<Moment> moments = Moment.getMoments();
        if(moments.size() > 0){
            for (Moment moment : moments) {
                System.out.println("\nID: " + moment.getId());
                System.out.println("Título: " + moment.getTitle());
            }
            System.out.println("\nIngresa el identificador(ID) del momento a eliminar: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            Moment.deleteMoment(id);

        }else{
            System.out.println();
            System.out.println("\nNo hay momentos...");   
        }
        Helpers.pressEnterToContinue();
    }

    public static void filterByMenu(Scanner scanner){
        int filterSelection;
        do{
            View.showFilterMenu();
            filterSelection = scanner.nextInt();
            scanner.nextLine();
            if(filterSelection == 1){
                View.showMoments(Helpers.getFilterByEmotion(View.inputEmotionSelection(scanner)));
            }
            else if(filterSelection == 2){
                View.showMoments(Helpers.getFilterByDate(Helpers.inputDate(scanner, "Ingrese mes y año para filtrar los momentos  (mm/yyyy): ")));
            }
        }while(filterSelection < 1  || filterSelection > 2);                    
        Helpers.pressEnterToContinue();
    }
}