package aula4.exercicios;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SomadorDigitosTest {
    @Test
    void testSomar() {
        assertEquals(15, SomadorDigitos.somar(12345));
    }

    @Test
    void testSomarDois() {
        assertEquals(15, SomadorDigitos.somar(54321));
    }

    @Test
    void testSomarSub10() {
        assertEquals(45, SomadorDigitos.somar(123456789));
    }

    @Test
    void testSomarZero() {
        assertEquals(0, SomadorDigitos.somar(0));
    }
}