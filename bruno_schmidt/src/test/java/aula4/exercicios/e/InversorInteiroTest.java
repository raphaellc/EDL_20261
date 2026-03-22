package aula4.exercicios.e;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InversorInteiroTest {
    @Test
    @DisplayName("Inverter 123 deve retornar 321")
    void inversorTest1() {
        assertEquals(321, InversorInteiro.inverter(123));
    }

    @Test
    @DisplayName("Inverter 12345 deve retornar 54321")
    void inversorTest2() {
        assertEquals(54321, InversorInteiro.inverter(12345));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0})
    @DisplayName("Inverter menores que 10 retornar o próprio numero")
    void inversorTest3(int numero) {
        assertEquals(numero, InversorInteiro.inverter(numero));
    }
}