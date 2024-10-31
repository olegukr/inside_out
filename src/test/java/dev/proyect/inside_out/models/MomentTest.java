package dev.proyect.inside_out.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Date;

public class MomentTest {

    private Moment moment;
    private Date momentDate;

    @BeforeEach
    public void setUp() {
        momentDate = new Date();
        moment = new Moment(1, "Mi Título", "Felicidad", "Esta es una descripción", momentDate);
    }

    @Test
    public void testGetters() {
        assertThat("El ID debe ser 1", moment.getId(), is(1));
        assertThat("El título debe ser 'Mi Título'", moment.getTitle(), is("Mi Título"));
        assertThat("La emoción debe ser 'Felicidad'", moment.getEmotion(), is("Felicidad"));
        assertThat("La descripción debe ser 'Esta es una descripción'", moment.getDescription(), is("Esta es una descripción"));
        assertThat("La fecha del momento debe coincidir", moment.getMomentDate(), is(momentDate));

        assertThat("La fecha de creación no debe ser nula", moment.getCreationDate(), is(notNullValue()));
        assertThat("La fecha de modificación no debe ser nula", moment.getModificationDate(), is(notNullValue()));

        assertThat("La fecha de creación debe ser una instancia de Date", moment.getCreationDate(), instanceOf(Date.class));
        assertThat("La fecha de modificación debe ser una instancia de Date", moment.getModificationDate(), instanceOf(Date.class));
    }

    @Test
    public void testSetTitle() {
        Date initialModificationDate = moment.getModificationDate();
        moment.setTitle("Nuevo Título");
        
        assertThat("El título debe ser 'Nuevo Título'", moment.getTitle(), is("Nuevo Título"));
    }

    @Test
    public void testSetEmotion() {
        Date initialModificationDate = moment.getModificationDate();
        moment.setEmotion("Tristeza");

        assertThat("La emoción debe ser 'Tristeza'", moment.getEmotion(), is("Tristeza"));
    }

    @Test
    public void testSetDescription() {
        Date initialModificationDate = moment.getModificationDate();
        moment.setDescription("Nueva Descripción");

        assertThat("La descripción debe ser 'Nueva Descripción'", moment.getDescription(), is("Nueva Descripción"));
    }

    @Test
    public void testSetMomentDate() {
        Date initialModificationDate = moment.getModificationDate();
        Date newMomentDate = new Date();
        moment.setMomentDate(newMomentDate);

        assertThat("La fecha del momento debe coincidir con la nueva fecha", moment.getMomentDate(), is(newMomentDate));
    }

    @Test
    public void testModificationDateUpdates() {
        Date initialModificationDate = moment.getModificationDate();
        
        moment.setTitle("Título Actualizado");
        
        Date updatedModificationDate = moment.getModificationDate();
        
        moment.setDescription("Descripción Actualizada");
    }
}

