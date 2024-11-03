package dev.proyect.inside_out.controller;

import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import dev.proyect.inside_out.models.Moment;
// comment
public class MomentController {
    
    private static List<Moment> moments = new ArrayList<Moment>();

    public MomentController(List<Moment> moments) {
        this.moments = moments;
    }
    

    // public void addMoment(Moment moment){
        
    // }
    public static List<Moment> getMoments(){

        String dateString = "01/11/2024";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(dateString, formatter);
        moments.add( 1, "title_1",  "Alegría", "description_1", date);
            return moments;
    }
    public static Moment getMomentById(int id){
        for (Moment moment: MomentController.moments) {
            if (moment.getId() == id) {
                return moment;
            }
        }
            return null;
    }
    // public List<Moment> deleteMoment(Moment moment){

    // }
    // public List<Moment> getFilterByEmotion() {
        
    // }
    // public List<Moment> getFilterByDate(Date date){

    // }

    // updateMomentDate( Date) void {

    // }
}
