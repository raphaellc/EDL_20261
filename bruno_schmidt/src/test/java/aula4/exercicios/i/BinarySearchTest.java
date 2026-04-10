package aula4.exercicios.i;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BinarySearchTest {
    @Test
    @DisplayName("Encontrar valor no meio do vetor")
    void encontraValorNoMeio() {
        int[] vetor = {1, 3, 5, 7, 9};

        int indice = BinarySearch.buscar(vetor, 5);

        assertEquals(2, indice);
    }

    @Test
    @DisplayName("Encontrar valor na segunda posicao")
    void encontraValorNoInicio() {
        int[] vetor = {2, 4, 6, 8, 10};

        int indice = BinarySearch.buscar(vetor, 4);

        assertEquals(1, indice);
    }

    @Test
    @DisplayName("Encontrar valor na ultima posicao")
    void encontraValorNoFim() {
        int[] vetor = {2, 4, 6, 8, 10};

        int indice = BinarySearch.buscar(vetor, 10);

        assertEquals(4, indice);
    }

    @Test
    @DisplayName("Retornar -1 quando valor nao existir entre elementos")
    void naoEncontraValorEntreElementos() {
        int[] vetor = {1, 3, 5, 7, 9};

        int indice = BinarySearch.buscar(vetor, 6);

        assertEquals(-1, indice);
    }

    @Test
    @DisplayName("Retornar -1 quando valor for menor que o minimo")
    void naoEncontraValorMenorQueMinimo() {
        int[] vetor = {1, 3, 5, 7, 9};

        int indice = BinarySearch.buscar(vetor, -10);

        assertEquals(-1, indice);
    }

    @Test
    @DisplayName("Retornar -1 quando valor for maior que o maximo")
    void naoEncontraValorMaiorQueMaximo() {
        int[] vetor = {1, 3, 5, 7, 9};

        int indice = BinarySearch.buscar(vetor, 99);

        assertEquals(-1, indice);
    }

    @Test
    @DisplayName("Encontrar valor em vetor com um unico elemento")
    void encontraEmVetorComUmElemento() {
        int[] vetor = {42};

        int indice = BinarySearch.buscar(vetor, 42);

        assertEquals(0, indice);
    }

    @Test
    @DisplayName("Retornar -1 em vetor vazio")
    void retornaMenosUmEmVetorVazio() {
        int[] vetor = {};

        int indice = BinarySearch.buscar(vetor, 42);

        assertEquals(-1, indice);
    }
}

