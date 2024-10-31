/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dev.proyect.inside_out.models;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author olegpoberezhets
 */
public class Emotion {

    private static final List<String> emotions = Arrays.asList(
        "Alegría",
        "Tristeza",
        "Ira",
        "Asco",
        "Miedo",
        "Ansiedad",
        "Envidia",
        "Vergüenza",
        "Aburrimiento",
        "Nostalgia"
    );

    public static String getEmotionByIndex(int index) {
        return emotions.get(index);
    }

    public static List<String> getEmotions() {
        return emotions;
    }    


}
