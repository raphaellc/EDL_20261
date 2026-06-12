package com.algoritmos.model.algoritmos;

import com.algoritmos.model.Metricas;
import com.algoritmos.model.OrdenacaoListener;
import com.algoritmos.model.PassoTabela;

import java.util.Arrays;

/** Ordenação por flutuação (Bubble Sort) com parada antecipada. */
public class BubbleSort extends AlgoritmoOrdenacao {

    @Override
    public String getNome() {
        return "Bubble Sort";
    }

    @Override
    public void ordenar(int[] a, long tempoNanos, OrdenacaoListener listener) {
        int trocas = 0;
        int copias = 0;
        listener.aoAtualizarMetricas(new Metricas(trocas, copias, -1));
        listener.aoRegistrarPasso(new PassoTabela("Início", "-", "-",
                Arrays.toString(a), "Início Bubble Sort"));

        boolean houveTroca;
        int iteracao = 0;

        do {
            houveTroca = false;
            StringBuilder comparacoes = new StringBuilder();

            for (int i = 0; i < a.length - 1; i++) {
                comparacoes.append(i).append("x").append(i + 1).append(" ");
                listener.aoDestacar(a, i, i + 1);

                if (a[i] > a[i + 1]) {
                    trocar(a, i, i + 1);
                    trocas++;
                    copias += 3;
                    houveTroca = true;
                    listener.aoAtualizarMetricas(new Metricas(trocas, copias, -1));
                    listener.aoDestacar(a, i, i + 1);
                }
            }

            String acao = houveTroca
                    ? "Bolha subiu (Trocas ocorridas)"
                    : "Array ordenado (Sem trocas)";
            listener.aoRegistrarPasso(new PassoTabela("Passagem " + (++iteracao),
                    "Flag=" + houveTroca, comparacoes.toString().trim(),
                    Arrays.toString(a), acao));

        } while (houveTroca);

        listener.aoAtualizarMetricas(new Metricas(trocas, copias, tempoNanos));
    }

    @Override
    protected void ordenarPuro(int[] a) {
        boolean houveTroca;
        do {
            houveTroca = false;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i + 1]) {
                    trocar(a, i, i + 1);
                    houveTroca = true;
                }
            }
        } while (houveTroca);
    }
}
