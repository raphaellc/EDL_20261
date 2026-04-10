package aula4.exercicios.a;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SomasSucessivasTest {
    @Test
    @DisplayName("Multiplicar 3*5 deve retornar 15")
    void testMultiplicar() {
        assertEquals(15, SomasSucessivas.multiplicar(3, 5));
    }

    @Test
    @DisplayName("Multiplicar 4*-8 deve retornar -32")
    void testMultiplicarNegativo() {
        assertEquals(-32, SomasSucessivas.multiplicar(4, -8));
    }
}