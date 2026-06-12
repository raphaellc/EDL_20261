package com.algoritmos.model.algoritmos;

import com.algoritmos.model.Metricas;
import com.algoritmos.model.OrdenacaoListener;
import com.algoritmos.model.PassoTabela;

import java.util.Arrays;

/** Ordenação por inserção (Insertion Sort). */
public class InsertionSort extends AlgoritmoOrdenacao {

    @Override
    public String getNome() {
        return "Insertion Sort";
    }

    @Override
    public void ordenar(int[] a, long tempoNanos, OrdenacaoListener listener) {
        int trocas = 0;
        int copias = 0;
        listener.aoAtualizarMetricas(new Metricas(trocas, copias, -1));
        listener.aoRegistrarPasso(new PassoTabela("Início", "-", "-",
                Arrays.toString(a), "Início Insertion Sort"));

        for (int i = 1; i < a.length; i++) {
            StringBuilder comparacoes = new StringBuilder();
            boolean trocou = false;

            for (int j = i; j > 0; j--) {
                comparacoes.append(a[j - 1]).append(">").append(a[j]).append(" ");
                listener.aoDestacar(a, j - 1, j);

                if (a[j - 1] > a[j]) {
                    trocar(a, j - 1, j);
                    trocas++;
                    copias += 3;
                    trocou = true;
                    listener.aoAtualizarMetricas(new Metricas(trocas, copias, -1));
                    listener.aoDestacar(a, j - 1, j);
                } else {
                    break;
                }
            }
            String acao = trocou ? "Inseriu à esquerda" : "Posição correta";
            listener.aoRegistrarPasso(new PassoTabela("i=" + i, "alvo=" + a[i],
                    comparacoes.toString().trim(), Arrays.toString(a), acao));
        }
        listener.aoAtualizarMetricas(new Metricas(trocas, copias, tempoNanos));
    }

    @Override
    protected void ordenarPuro(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0 && a[j - 1] > a[j]; j--) {
                trocar(a, j - 1, j);
            }
        }
    }
}
