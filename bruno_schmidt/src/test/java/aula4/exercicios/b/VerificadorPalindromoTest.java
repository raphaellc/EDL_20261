package aula4.exercicios.b;

import static aula4.exercicios.b.VerificadorPalindromo.isPalindromo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class VerificadorPalindromoTest {

    @Test
    @DisplayName("isPalindromo deve retornar true quando a palavra for arara")
    void isPalindromoTrueQuandoArara() {
        assertTrue(isPalindromo("arara"));
    }

    @Test
    @DisplayName("isPalindromo deve retornar false quando a palavra for Bruno")
    void isPalindromoFalseQuandoBruno() {
        assertFalse(isPalindromo("bruno"));
    }

    @ParameterizedTest
    @CsvSource({
        "arara, true",
        "radar, true",
        "ana, true",
        "reviver, true",
        "algoritmo, false",
        "Bruno, false"
    })
    @DisplayName("Teste de varios palindromos")
    void massTest(String palavra, boolean esperado) {
        assertEquals(esperado, isPalindromo(palavra));
    }
}
