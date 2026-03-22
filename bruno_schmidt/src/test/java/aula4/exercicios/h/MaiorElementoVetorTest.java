package aula4.exercicios.h;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MaiorElementoVetorTest {
    @Test
    @DisplayName("O maior elemento entre o conjunto {1, 3, 2, 5, 9} é 9")
    void maiorPrimeiroVetor() {
        int[] vetor = {1, 3, 2, 5, 9};

        int maior = MaiorElementoVetor.maiorElemento(vetor);

        assertEquals(9, maior);
    }

    @Test
    @DisplayName("Retornar o unico elemento quando vetor tiver apenas 1 elemento")
    void maiorVetorComUmElemento() {
        int[] vetor = {99};

        int maior = MaiorElementoVetor.maiorElemento(vetor);

        assertEquals(99, maior);
    }
}