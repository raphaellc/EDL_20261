package com.algoritmos.model;

/**
 * Observador dos eventos emitidos por um algoritmo de ordenação durante
 * sua execução.
 *
 * <p>Permite que a camada de Model (algoritmos) reporte o seu progresso
 * sem conhecer nada sobre Swing ou threads. O Controller implementa esta
 * interface e é responsável por refletir os eventos na View.</p>
 */
public interface OrdenacaoListener {

    /**
     * Indica que dois índices estão sendo destacados (comparados ou recém
     * trocados) sobre o estado atual do array.
     *
     * @param estado estado atual do array
     * @param i      primeiro índice destacado
     * @param j      segundo índice destacado
     */
    void aoDestacar(int[] estado, int i, int j);

    /** Indica que os indicadores de desempenho foram atualizados. */
    void aoAtualizarMetricas(Metricas metricas);

    /** Indica que um passo de rastreio deve ser registrado. */
    void aoRegistrarPasso(PassoTabela passo);
}
