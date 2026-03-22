package aula4.exercicios;

import static aula4.exercicios.EscritorInteirosEmOrdem.Ordem.CRESCENTE;
import static aula4.exercicios.EscritorInteirosEmOrdem.Ordem.DECRESCENTE;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EscritorInteirosEmOrdemTest {
    private ByteArrayOutputStream customOut;
    private static final PrintStream originalOut = System.out;

    @BeforeEach
    void setUpStreams() {
        customOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(customOut));
    }

    @AfterAll
    static void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("Escrever numeros de 1 a 10 em ordem crescente")
    void escritaTesteCrescente() {
        EscritorInteirosEmOrdem.escrever(1, 10, CRESCENTE);

        String resultado = customOut.toString().trim();
        assertEquals("1 2 3 4 5 6 7 8 9 10", resultado);
    }

    @Test
    @DisplayName("Escrever numeros de 20 a 10 em ordem decrescente")
    void escritaTesteDecrescente() {
        EscritorInteirosEmOrdem.escrever(20, 10, DECRESCENTE);
    }
}