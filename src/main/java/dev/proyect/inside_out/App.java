package dev.proyect.inside_out;
import java.util.Scanner;
import dev.proyect.inside_out.controller.MomentController;
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
                MomentController.showMomentsMenu();
            }
            else if(menuSelection == 3){
                MomentController.deleteMomentMenu();
            }
            else if(menuSelection == 4){
                MomentController.filterByMenu();
            }
            else if(menuSelection == 5){
                break;
            }
        }
    }
}