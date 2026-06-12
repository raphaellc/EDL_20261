package com.algoritmos.controller;

import com.algoritmos.model.Metricas;
import com.algoritmos.model.OrdenacaoListener;
import com.algoritmos.model.PassoTabela;
import com.algoritmos.model.VetorParser;
import com.algoritmos.model.algoritmos.AlgoritmoOrdenacao;
import com.algoritmos.model.algoritmos.FabricaAlgoritmos;
import com.algoritmos.view.JanelaPrincipal;

import javax.swing.SwingUtilities;

/**
 * Orquestra a interação entre View e Model.
 *
 * <p>Responsabilidades:</p>
 * <ul>
 *   <li>reagir ao clique de "Iniciar Ordenação";</li>
 *   <li>validar/converter a entrada e selecionar a estratégia;</li>
 *   <li>medir o tempo computacional e executar o algoritmo em uma thread
 *       separada (mantendo a UI responsiva);</li>
 *   <li>refletir, na Event Dispatch Thread, os eventos emitidos pelo
 *       algoritmo (implementando {@link OrdenacaoListener}).</li>
 * </ul>
 */
public class OrdenacaoController implements OrdenacaoListener {

    /** Atraso de animação entre cada destaque, em milissegundos. */
    private static final int DELAY_ANIMACAO_MS = 200;

    private final JanelaPrincipal janela;

    public OrdenacaoController(JanelaPrincipal janela) {
        this.janela = janela;
        this.janela.addIniciarListener(e -> iniciar());
    }

    private void iniciar() {
        final int[] vetor;
        try {
            vetor = VetorParser.parse(janela.getVetorTexto());
        } catch (NumberFormatException ex) {
            janela.mostrarErro(
                    "Por favor, insira apenas números inteiros separados por vírgula.");
            return;
        }

        AlgoritmoOrdenacao algoritmo =
                FabricaAlgoritmos.obter(janela.getAlgoritmoSelecionado());

        janela.limparTabela();
        janela.getPainelVisualizacao().setArray(vetor);
        janela.setBotaoHabilitado(false);

        // Mede o tempo computacional puro (sem a animação visual).
        long tempoReal = algoritmo.medirTempo(vetor);

        // Executa a versão instrumentada fora da EDT.
        final int[] paraOrdenar = vetor.clone();
        new Thread(() -> {
            try {
                algoritmo.ordenar(paraOrdenar, tempoReal, this);
            } finally {
                SwingUtilities.invokeLater(() -> {
                    janela.getPainelVisualizacao().setEstado(paraOrdenar, -1, -1);
                    janela.setBotaoHabilitado(true);
                });
            }
        }, "ordenacao-worker").start();
    }

    // --- OrdenacaoListener (invocado na thread de trabalho) ---

    @Override
    public void aoDestacar(int[] estado, int i, int j) {
        int[] snapshot = estado.clone();
        SwingUtilities.invokeLater(
                () -> janela.getPainelVisualizacao().setEstado(snapshot, i, j));
        dormir();
    }

    @Override
    public void aoAtualizarMetricas(Metricas metricas) {
        SwingUtilities.invokeLater(() -> janela.atualizarMetricas(metricas));
    }

    @Override
    public void aoRegistrarPasso(PassoTabela passo) {
        SwingUtilities.invokeLater(() -> janela.adicionarPasso(passo));
    }

    private void dormir() {
        try {
            Thread.sleep(DELAY_ANIMACAO_MS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
