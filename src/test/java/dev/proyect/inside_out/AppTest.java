package dev.proyect.inside_out;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import dev.proyect.inside_out.models.Moment;

public class AppTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    // @Test
    // public void testAppMainFlow() {
    //     App.main(null);
    //     String input = "5\n";
    //     System.setIn(new ByteArrayInputStream(input.getBytes()));
    //     String output = outputStreamCaptor.toString();
    //     assertThat(output, containsString("My diario:"));
    //     assertThat(output, containsString("1. Añadir momento"));
    //     assertThat(output, containsString("2. Ver todos los momentos disponibles"));
    //     assertThat(output, containsString("3. Eliminar un momento"));
    //     assertThat(output, containsString("4. Filtrar los momentos"));
    //     assertThat(output, containsString("5. Salir"));
    //     assertThat(output, containsString("Seleccione una opción:"));
    // }    
}

