package com.algoritmos;

import com.algoritmos.controller.OrdenacaoController;
import com.algoritmos.model.algoritmos.FabricaAlgoritmos;
import com.algoritmos.view.JanelaPrincipal;

import javax.swing.SwingUtilities;

/**
 * Ponto de entrada da aplicação. Monta o MVC e exibe a janela na
 * Event Dispatch Thread.
 */
public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JanelaPrincipal janela = new JanelaPrincipal(FabricaAlgoritmos.nomes());
            new OrdenacaoController(janela);
            janela.setVisible(true);
        });
    }
}
