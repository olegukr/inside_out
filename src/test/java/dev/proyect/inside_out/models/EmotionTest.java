package dev.proyect.inside_out.models;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class EmotionTest {
    @Test
    void testGetEmotionByIndex() {
        String test = Emotion.getEmotionByIndex(1);
        assertEquals(test, "Tristeza");
    }

    @Test
    void testGetEmotions() {

        final List<String> emotions = Arrays.asList(
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
        assertEquals(Emotion.getEmotions().toString(),emotions.toString() );

    }
}

