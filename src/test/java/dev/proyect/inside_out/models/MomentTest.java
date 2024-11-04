package dev.proyect.inside_out.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.time.LocalDate;

public class MomentTest {

    private Moment moment;
    private LocalDate momentDate;

    @BeforeEach
    public void setUp() {
        momentDate = LocalDate.of(2024, 10, 20);
        moment = new Moment(1, "Mi Título", "Felicidad", "Esta es una descripción", momentDate);
    }

    @Test
    public void testGetters() {
        assertThat("El ID debe ser 2", moment.getId(), is(2));
        assertThat("El título debe ser 'Mi Título'", moment.getTitle(), is("Mi Título"));
        assertThat("La emoción debe ser 'Felicidad'", moment.getEmotion(), is("Felicidad"));
        assertThat("La descripción debe ser 'Esta es una descripción'", moment.getDescription(), is("Esta es una descripción"));
        assertThat("La fecha del momento debe coincidir", moment.getMomentDate(), is(momentDate));
        assertThat("La fecha de creación no debe ser nula", moment.getCreationDate(), is(notNullValue()));
        assertThat("La fecha de modificación no debe ser nula", moment.getModificationDate(), is(notNullValue()));
    }

    @Test
    public void testSetTitle() {
        moment.setTitle("Nuevo Título");
        assertThat("El título debe actualizarse a 'Nuevo Título'", moment.getTitle(), is("Nuevo Título"));
        assertThat("La fecha de modificación debe actualizarse", moment.getModificationDate(), is(LocalDate.now()));
    }

    @Test
    public void testSetEmotion() {
        moment.setEmotion("Tristeza");
        assertThat("La emoción debe actualizarse a 'Tristeza'", moment.getEmotion(), is("Tristeza"));
        assertThat("La fecha de modificación debe actualizarse", moment.getModificationDate(), is(LocalDate.now()));
    }

    @Test
    public void testSetDescription() {
        moment.setDescription("Nueva descripción");
        assertThat("La descripción debe actualizarse a 'Nueva descripción'", moment.getDescription(), is("Nueva descripción"));
        assertThat("La fecha de modificación debe actualizarse", moment.getModificationDate(), is(LocalDate.now()));
    }

    @Test
    public void testSetMomentDate() {
        LocalDate newDate = LocalDate.of(2025, 5, 15);
        moment.setMomentDate(newDate);
        assertThat("La fecha del momento debe actualizarse a la nueva fecha", moment.getMomentDate(), is(newDate));
        assertThat("La fecha de modificación debe actualizarse", moment.getModificationDate(), is(LocalDate.now()));
    }

    @Test
    public void testAddToMomentsList() {
        assertThat("La lista de momentos debe contener el momento creado", Moment.getMoments(), hasItem(moment));
    }

}
