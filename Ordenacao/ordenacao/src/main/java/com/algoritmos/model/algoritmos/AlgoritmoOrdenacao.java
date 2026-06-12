package com.algoritmos.model.algoritmos;

import com.algoritmos.model.OrdenacaoListener;

/**
 * Estratégia (Strategy) de ordenação.
 *
 * <p>Cada algoritmo expõe duas execuções:</p>
 * <ul>
 *   <li>{@link #ordenar} — instrumentada, emite eventos de progresso para
 *       um {@link OrdenacaoListener} (usada na visualização animada);</li>
 *   <li>{@link #ordenarPuro} — sem instrumentação, usada apenas para medir
 *       o tempo computacional real via {@link #medirTempo}.</li>
 * </ul>
 *
 * <p>Esta classe não conhece Swing nem threads — pertence integralmente
 * à camada de Model.</p>
 */
public abstract class AlgoritmoOrdenacao {

    /** Nome exibido na interface e usado pela fábrica. */
    public abstract String getNome();

    /**
     * Ordena o array emitindo eventos de progresso.
     *
     * @param array      vetor a ser ordenado (modificado in-place)
     * @param tempoNanos tempo computacional medido previamente, exibido ao final
     * @param listener   observador dos eventos de progresso
     */
    public abstract void ordenar(int[] array, long tempoNanos, OrdenacaoListener listener);

    /** Ordena o array sem qualquer instrumentação (apenas a lógica pura). */
    protected abstract void ordenarPuro(int[] array);

    /**
     * Mede o tempo computacional puro do algoritmo sobre uma cópia do vetor.
     *
     * @param entrada vetor de entrada (não é modificado)
     * @return tempo de execução em nanossegundos
     */
    public final long medirTempo(int[] entrada) {
        int[] clone = entrada.clone();
        long inicio = System.nanoTime();
        ordenarPuro(clone);
        return System.nanoTime() - inicio;
    }

    /** Troca dois elementos do array (apenas o swap; a contagem fica no algoritmo). */
    protected final void trocar(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
