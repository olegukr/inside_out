package dev.proyect.inside_out.view;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.proyect.inside_out.models.Moment;

public class ViewTest {
  

    private Moment moment;
    private LocalDate momentDate;

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
        outputStream.reset(); // Clear output stream for next test
    }
    //     momentDate = LocalDate.of(2024, 10, 20);
    //     moment = new Moment("Mi Título", "Felicidad", "Esta es una descripción", momentDate);
   

    @Test
    void testShowMainMenu() {

        String expectedOutput = "\nMy diario:\n" +
                "1. Añadir momento\n" +
                "2. Ver todos los momentos disponibles\n" +
                "3. Eliminar un momento\n" +
                "4. Filtrar los momentos\n" +
                "5. Salir\n" +
                "Seleccione una opción: ";

        View.showMainMenu();
        
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    void testShowFilterMenu() {

        String expectedOutput = "\nFiltrar por ...:\n" +
                "1. Emoción\n" +
                "2. Fecha\n" +
                "Ingrese una opción: ";

        View.showFilterMenu();

        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    void testShowAllEmotions() {

        View.showAllEmotions();

        String expectedOutput = "\n1. Alegría\n" +
            "2. Tristeza\n" +
            "3. Ira\n" +
            "4. Asco\n" +
            "5. Miedo\n" +
            "6. Ansiedad\n" +
            "7. Envidia\n" +
            "8. Vergüenza\n" +
            "9. Aburrimiento\n" +
            "10. Nostalgia\n";

        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    void testShowMoment() {

        momentDate = LocalDate.now();
        moment = new Moment("Sample Title", "Ira", "This is a sample description.", momentDate);
        
        int id = moment.getId();
        String expectedOutput = "\nID: " + (id) +"\n" +
                "Título: Sample Title\n" +
                "Emoción: Ira\n" +
                "Descripción: This is a sample description.\n" +
                "Fecha del momento: " + momentDate + "\n" +
                "Fecha del CreationDate: "+ momentDate + "\n" +
                "Fecha del ModificationDate: "+ momentDate + "\n";

        View.showMoment(moment);

        assertEquals(expectedOutput, outputStream.toString());
    }

    // @Test
    // void testShowMoments() {

    // }
}
