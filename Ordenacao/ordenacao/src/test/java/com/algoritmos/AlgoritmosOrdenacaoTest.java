package com.algoritmos;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.algoritmos.model.Metricas;
import com.algoritmos.model.OrdenacaoListener;
import com.algoritmos.model.PassoTabela;
import com.algoritmos.model.VetorParser;
import com.algoritmos.model.algoritmos.AlgoritmoOrdenacao;
import com.algoritmos.model.algoritmos.FabricaAlgoritmos;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Testa o comportamento da camada de Model (algoritmos, parser e métricas),
 * sem qualquer dependência da interface gráfica.
 */
public class AlgoritmosOrdenacaoTest {

    /** Coletor de eventos que ignora a animação (apenas registra). */
    private static final class ColetorEventos implements OrdenacaoListener {
        final List<PassoTabela> passos = new ArrayList<>();
        Metricas ultimaMetrica;

        @Override
        public void aoDestacar(int[] estado, int i, int j) {
            // sem efeito no teste
        }

        @Override
        public void aoAtualizarMetricas(Metricas metricas) {
            this.ultimaMetrica = metricas;
        }

        @Override
        public void aoRegistrarPasso(PassoTabela passo) {
            passos.add(passo);
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"Selection Sort", "Insertion Sort", "Bubble Sort"})
    public void deveOrdenarVetorDesordenado(String nome) {
        AlgoritmoOrdenacao algoritmo = FabricaAlgoritmos.obter(nome);
        int[] entrada = {10, 8, 7, 5, 4, 2, 1};
        int[] esperado = {1, 2, 4, 5, 7, 8, 10};

        ColetorEventos coletor = new ColetorEventos();
        algoritmo.ordenar(entrada, 123L, coletor);

        assertArrayEquals(esperado, entrada);
        assertEquals(123L, coletor.ultimaMetrica.tempoNanos());
        assertEquals(3 * coletor.ultimaMetrica.trocas(), coletor.ultimaMetrica.copias());
        assertTrue(coletor.passos.size() >= 2, "deve registrar início e ao menos um passo");
    }

    @ParameterizedTest
    @ValueSource(strings = {"Selection Sort", "Insertion Sort", "Bubble Sort"})
    public void deveManterVetorJaOrdenado(String nome) {
        AlgoritmoOrdenacao algoritmo = FabricaAlgoritmos.obter(nome);
        int[] entrada = {1, 2, 3, 4, 5};

        algoritmo.ordenar(entrada, 0L, new ColetorEventos());

        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, entrada);
    }

    @Test
    public void medirTempoNaoAlteraEntrada() {
        AlgoritmoOrdenacao algoritmo = FabricaAlgoritmos.obter("Bubble Sort");
        int[] entrada = {3, 1, 2};

        long tempo = algoritmo.medirTempo(entrada);

        assertArrayEquals(new int[]{3, 1, 2}, entrada, "medirTempo opera sobre cópia");
        assertTrue(tempo >= 0);
    }

    @Test
    public void parserConverteTextoComEspacos() {
        assertArrayEquals(new int[]{10, 8, 7}, VetorParser.parse("10, 8 , 7"));
    }

    @Test
    public void fabricaListaAlgoritmosNaOrdemDeRegistro() {
        assertEquals(List.of("Selection Sort", "Insertion Sort", "Bubble Sort"),
                FabricaAlgoritmos.nomes());
    }
}
