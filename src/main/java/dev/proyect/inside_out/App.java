package dev.proyect.inside_out;
import java.util.Scanner;

import dev.proyect.inside_out.controller.MomentController;
import dev.proyect.inside_out.models.Moment;
import dev.proyect.inside_out.view.View;

public final class App {
    
    public static void main(String[] args) {

        while(true){
            View.showMainMenu();
            int menuSelection = new Scanner(System.in).nextInt();
            if(menuSelection == 1){
                MomentController.addMomentMenu();
            }
            else if(menuSelection == 2){
                View.showMoments(Moment.getMoments());
                MomentController.pressEnterToContinue();
            }
            else if(menuSelection == 3){
                System.out.println("menu 3");
                MomentController.pressEnterToContinue();
            }
            else if(menuSelection == 4){
                MomentController.filterByMenu();
            }
            else if(menuSelection == 5){
                System.out.println("");
                System.out.println("See you later...");
                break;
            }
        }
    }
}