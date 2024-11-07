package dev.proyect.inside_out.controller;

import dev.proyect.inside_out.models.Moment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class MomentControllerTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private MomentController momentController;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        momentController = new MomentController();
        Moment.getMoments().clear();
        
    }

    @Test
    public void testAddMomentMenu() {
        
        String simulatedInput = "1\nMi Momento Especial\nUn día inolvidable\n10/05/2023\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        Scanner scanner = new Scanner(System.in);

        MomentController.addMomentMenu(scanner);

        List<Moment> moments = Moment.getMoments();
        assertThat("Debe haber un momento en la lista", moments.size(), is(1));
        Moment addedMoment = moments.get(0);
        assertThat("El título debe coincidir", addedMoment.getTitle(), is("Mi Momento Especial"));
        assertThat("La emoción debe coincidir", addedMoment.getEmotion(), is("Alegría"));
        assertThat("La descripción debe coincidir", addedMoment.getDescription(), is("Un día inolvidable"));
        assertThat("La fecha debe coincidir", addedMoment.getMomentDate(), is(LocalDate.of(2023, 5, 10)));

        assertThat(outputStreamCaptor.toString().trim(), containsString("Nuevo momento agregado: Mi Momento Especial"));
        }

    @Test
    public void testDeleteMomentMenu() {
        Moment momentToDelete = new Moment("Eliminar Momento", "Tristeza", "Momento para borrar", LocalDate.now());
        Moment.getMoments().add(momentToDelete);

        assertThat("Debe haber un momento en la lista antes de la eliminación", Moment.getMoments().size(), is(2));

        String simulatedInput = momentToDelete.getId() + "\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        Scanner scanner = new Scanner(System.in);

        MomentController.deleteMomentMenu(scanner);
        assertThat("La lista de momentos debe estar vacía después de la eliminación", Moment.getMoments().size(), is(1));

    }

    @Test
    public void testFilterByEmotion() {
        new Moment("Momento Feliz", "Alegría", "Un gran día", LocalDate.now());
        new Moment("Momento Triste", "Tristeza", "Un día triste", LocalDate.now());

        String simulatedInput = "1\n1\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        Scanner scanner = new Scanner(System.in);

        MomentController.filterByMenu(scanner);
        
        String output = outputStreamCaptor.toString().trim();
        assertThat("Debe mostrar el título del momento con emoción 'Alegría'", output, containsString("Título: Momento Feliz"));
        assertThat("No debe mostrar el momento con emoción 'Tristeza'", output, not(containsString("Título: Momento Triste")));
    }

    @Test
    public void testFilterByDate() {
        new Moment("Momento de Mayo", "Alegría", "Momento en mayo", LocalDate.of(2023, 5, 10));
        new Moment("Momento de Junio", "Tristeza", "Momento en junio", LocalDate.of(2023, 6, 15));

        String simulatedInput = "2\n05/2023\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        Scanner scanner = new Scanner(System.in);

        MomentController.filterByMenu(scanner);

        String output = outputStreamCaptor.toString().trim();
        assertThat("Debe mostrar el título del momento en mayo", output, containsString("Título: Momento de Mayo"));
        assertThat("No debe mostrar el momento en junio", output, not(containsString("Título: Momento de Junio")));
    }
    
    @Test
    public void testShowMomentsMenu() {
        new Moment("Moment 1", "Alegría", "Descripción 1", LocalDate.of(2023, 1, 10));
        new Moment("Moment 2", "Tristeza", "Descripción 2", LocalDate.of(2023, 2, 15));
        String simulatedInput = "\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        MomentController.showMomentsMenu();
    
        String output = outputStreamCaptor.toString().trim();
        assertThat(output, containsString("Título: Moment 1"));
        assertThat(output, containsString("Emoción: Alegría"));
        assertThat(output, containsString("Descripción: Descripción 1"));
        assertThat(output, containsString("Fecha del momento: 2023-01-10"));
    
        assertThat(output, containsString("Título: Moment 2"));
        assertThat(output, containsString("Emoción: Tristeza"));
        assertThat(output, containsString("Descripción: Descripción 2"));
        assertThat(output, containsString("Fecha del momento: 2023-02-15"));
    }
}

