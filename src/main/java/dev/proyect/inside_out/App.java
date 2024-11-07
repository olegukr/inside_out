package dev.proyect.inside_out;
import java.util.Scanner;

import dev.proyect.inside_out.controller.MomentController;
import dev.proyect.inside_out.view.View;

public final class App {
    
    public static void main(String[] args) {

        while(true){
            View.showMainMenu();
            int menuSelection;
            Scanner scanner = new Scanner(System.in);
            
            menuSelection = scanner.nextInt();
            scanner.nextLine();

            if(menuSelection == 1){
                MomentController.addMomentMenu( scanner);
            }
            else if(menuSelection == 2){
                MomentController.showMomentsMenu();
            }
            else if(menuSelection == 3){
                MomentController.deleteMomentMenu(scanner);
            }
            else if(menuSelection == 4){
                MomentController.filterByMenu(scanner);
            }
            else if(menuSelection == 5){
                scanner.close();
                break;
            }
        }
    }
}