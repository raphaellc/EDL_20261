package com.algoritmos.model.algoritmos;

import com.algoritmos.model.Metricas;
import com.algoritmos.model.OrdenacaoListener;
import com.algoritmos.model.PassoTabela;

import java.util.Arrays;

/** Ordenação por seleção (Selection Sort). */
public class SelectionSort extends AlgoritmoOrdenacao {

    @Override
    public String getNome() {
        return "Selection Sort";
    }

    @Override
    public void ordenar(int[] a, long tempoNanos, OrdenacaoListener listener) {
        int trocas = 0;
        int copias = 0;
        listener.aoAtualizarMetricas(new Metricas(trocas, copias, -1));
        listener.aoRegistrarPasso(new PassoTabela("Início", "-", "-",
                Arrays.toString(a), "Início Selection Sort"));

        for (int i = 0; i < a.length; i++) {
            int min = i;
            StringBuilder comparacoes = new StringBuilder();

            for (int j = i + 1; j < a.length; j++) {
                comparacoes.append(j).append(" ");
                listener.aoDestacar(a, j, min);
                if (a[j] < a[min]) {
                    min = j;
                }
            }

            String acao;
            if (min != i) {
                acao = "Troca (" + a[i] + " ↔ " + a[min] + ")";
                trocar(a, min, i);
                trocas++;
                copias += 3;
            } else {
                acao = "Mantém";
            }

            listener.aoAtualizarMetricas(new Metricas(trocas, copias, -1));
            listener.aoDestacar(a, i, min);
            listener.aoRegistrarPasso(new PassoTabela("i=" + i, "min=" + a[min],
                    comparacoes.toString().trim(), Arrays.toString(a), acao));
        }
        listener.aoAtualizarMetricas(new Metricas(trocas, copias, tempoNanos));
    }

    @Override
    protected void ordenarPuro(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            trocar(a, min, i);
        }
    }
}
