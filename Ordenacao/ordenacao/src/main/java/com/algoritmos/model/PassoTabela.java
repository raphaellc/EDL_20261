package com.algoritmos.model;

/**
 * Representa uma linha da tabela de rastreio do algoritmo: um passo
 * significativo da execução com seu estado e a ação tomada.
 *
 * @param fase        identificação da fase/iteração (ex.: "i=2", "Passagem 1")
 * @param foco        elemento em foco (ex.: "min=4", "alvo=7")
 * @param testes      varredura/comparações realizadas no passo
 * @param estadoArray representação textual do array após o passo
 * @param acao        descrição da ação tomada (troca, mantém, etc.)
 */
public record PassoTabela(String fase, String foco, String testes,
                          String estadoArray, String acao) {

    /** Converte o passo em uma linha para a {@code DefaultTableModel} da View. */
    public Object[] toRow() {
        return new Object[]{fase, foco, testes, estadoArray, acao};
    }
}
