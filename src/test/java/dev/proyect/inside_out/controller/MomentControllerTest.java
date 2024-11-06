package dev.proyect.inside_out.controller;

import dev.proyect.inside_out.models.Moment;
import dev.proyect.inside_out.models.Emotion;
import dev.proyect.inside_out.view.View;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.time.LocalDate;
import java.util.List;

public class MomentControllerTest {

    @BeforeEach
    public void setUp() {
        // Очистить список моментов перед каждым тестом
        Moment.getMoments().clear();
    }

    @Test
    public void testAddMoment() {
        // Данные для тестирования
        String title = "Mi Momento Especial";
        String emotion = "Alegría"; // Индекс эмоции "Alegría"
        String description = "Un día inolvidable";
        LocalDate momentDate = LocalDate.of(2023, 5, 10);

        // Добавляем момент
        MomentController.addMomentMenu(title, emotion, description, momentDate);

        // Проверяем, что момент добавлен в список
        List<Moment> moments = Moment.getMoments();
        assertThat("Debe haber un momento en la lista", moments.size(), is(1));
        Moment addedMoment = moments.get(0);
        assertThat("El título debe coincidir", addedMoment.getTitle(), is(title));
        assertThat("La emoción debe coincidir", addedMoment.getEmotion(), is("Alegría"));
        assertThat("La descripción debe coincidir", addedMoment.getDescription(), is(description));
        assertThat("La fecha debe coincidir", addedMoment.getMomentDate(), is(momentDate));
    }

    @Test
    public void testDeleteMoment() {
        // Добавляем момент для удаления
        Moment momentToDelete = new Moment("Eliminar Momento", "Tristeza", "Momento para borrar", LocalDate.now());
        int initialSize = Moment.getMoments().size();

        // Удаляем момент
        MomentController.deleteMomentMenu(momentToDelete.getId());

        // Проверяем, что момент удален
        assertThat("El tamaño de la lista debe haberse reducido en 1", Moment.getMoments().size(), is(initialSize - 1));
        assertThat("El momento eliminado no debe estar en la lista", Moment.getMoments(), not(hasItem(momentToDelete)));
    }

    @Test
    public void testFilterByEmotion() {
        // Добавляем несколько моментов с разными эмоциями
        new Moment("Momento Feliz", "Alegría", "Un gran día", LocalDate.now());
        new Moment("Momento Triste", "Tristeza", "Un día triste", LocalDate.now());

        // Фильтруем по эмоции "Alegría"
        List<Moment> filteredMoments = MomentController.getFilterByEmotion(1);
        
        assertThat("Debe haber 1 momento con emoción 'Alegría'", filteredMoments.size(), is(1));
        assertThat("La emoción del momento filtrado debe ser 'Alegría'", filteredMoments.get(0).getEmotion(), is("Alegría"));
    }

    @Test
    public void testFilterByDate() {
        // Добавляем моменты с разными датами
        new Moment("Momento de Mayo", "Alegría", "Momento en mayo", LocalDate.of(2023, 5, 10));
        new Moment("Momento de Junio", "Tristeza", "Momento en junio", LocalDate.of(2023, 6, 15));

        // Фильтруем по дате в мае
        LocalDate filterDate = LocalDate.of(2023, 5, 10);
        List<Moment> filteredMoments = MomentController.getFilterByDate(filterDate);

        assertThat("Debe haber 1 momento en la fecha de mayo", filteredMoments.size(), is(1));
        assertThat("La fecha del momento filtrado debe coincidir con la fecha de mayo", filteredMoments.get(0).getMomentDate(), is(filterDate));
    }
}

