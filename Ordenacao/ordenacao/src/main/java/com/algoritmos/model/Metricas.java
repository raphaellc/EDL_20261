package com.algoritmos.model;

/**
 * Snapshot imutável dos indicadores de desempenho de uma ordenação.
 *
 * <p>Convenção do projeto: 1 troca equivale a 3 cópias de memória.
 * Um {@code tempoNanos} negativo indica que a medição ainda não foi
 * concluída (animação em andamento).</p>
 *
 * @param trocas     quantidade de trocas realizadas
 * @param copias     quantidade de cópias de memória (3 por troca)
 * @param tempoNanos tempo lógico em nanossegundos, ou negativo se ainda animando
 */
public record Metricas(int trocas, int copias, long tempoNanos) {

    /** Métricas zeradas com tempo ainda indefinido. */
    public static Metricas inicial() {
        return new Metricas(0, 0, -1);
    }

    /** Texto amigável do tempo, exibido pela View. */
    public String tempoTexto() {
        return tempoNanos < 0 ? "Animando..." : tempoNanos + " ns";
    }
}
