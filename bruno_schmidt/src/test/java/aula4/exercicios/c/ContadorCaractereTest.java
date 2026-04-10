package aula4.exercicios.c;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ContadorCaractereTest {
    @Test
    @DisplayName( "Contar 'a' em 'abracadabra' deve retornar 5")
    void contar() {
        assertEquals(5, ContadorCaractere.contar('a', "abracadabra"));
    }

    @Test
    @DisplayName( "Contar 'z' em 'abracadabra' deve retornar 0")
    void contarZ() {
        assertEquals(0, ContadorCaractere.contar('z', "abracadabra"));
    }
}