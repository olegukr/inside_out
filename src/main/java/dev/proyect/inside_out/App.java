package dev.proyect.inside_out;

import dev.proyect.inside_out.models.Emotion;

public final class App {
    private App() {
    }

    public static void main(String[] args) {
        // Emotion emotionsList = new Emotion();
        System.out.println("Hi");
        System.out.println(Emotion.getEmotions().toString());
        System.out.println(Emotion.getEmotionByIndex( 1));
    }
}
