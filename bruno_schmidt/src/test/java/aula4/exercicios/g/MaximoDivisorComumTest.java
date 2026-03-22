package aula4.exercicios.g;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MaximoDivisorComumTest {
    @Test
    void testEncontrarMdc() {
        assertEquals(6, MaximoDivisorComum.encontrarMdc(18, 60));
    }

    @Test
    void testOrdemInvertida() {
        assertEquals(6, MaximoDivisorComum.encontrarMdc(60, 18));
    }

    @Test
    void testNumerosIguais() {
        assertEquals(10, MaximoDivisorComum.encontrarMdc(10, 10));
    }

    @Test
    void testNumerosPrimos() {
        assertEquals(1, MaximoDivisorComum.encontrarMdc(17, 29));
    }

    @Test
    void testUmZero() {
        assertEquals(25, MaximoDivisorComum.encontrarMdc(25, 0));
    }

    @Test
    void testOutroZero() {
        assertEquals(40, MaximoDivisorComum.encontrarMdc(0, 40));
    }

    @Test
    void testNumerosMaiores() {
        assertEquals(14, MaximoDivisorComum.encontrarMdc(42, 56));
    }

    @Test
    void testCoprimosGrandes() {
        assertEquals(1, MaximoDivisorComum.encontrarMdc(101, 103));
    }

    @Test
    void testZeroZero() {
        assertEquals(0, MaximoDivisorComum.encontrarMdc(0, 0));
    }
}