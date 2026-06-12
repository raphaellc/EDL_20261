package com.algoritmos.view;

import com.algoritmos.model.Metricas;
import com.algoritmos.model.PassoTabela;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Janela principal da aplicação. Monta e expõe a interface gráfica
 * (controles, gráfico, tabela de rastreio e indicadores).
 *
 * <p>Não contém regra de negócio: oferece getters dos dados de entrada,
 * pontos de extensão para o listener do botão e métodos para o Controller
 * atualizar a apresentação.</p>
 */
public class JanelaPrincipal extends JFrame {

    private static final String[] COLUNAS = {
            "Fase / Iteração", "Elemento Foco", "Varredura / Testes",
            "Estado do Array", "Ação"
    };

    private final JTextField txtVetor;
    private final JComboBox<String> cbAlgoritmo;
    private final JButton btnIniciar;
    private final PainelVisualizacao painelVisual;
    private final DefaultTableModel tableModel;
    private final JLabel lblTrocas;
    private final JLabel lblCopias;
    private final JLabel lblTempo;

    public JanelaPrincipal(List<String> algoritmos) {
        super("Visualizador de Algoritmos - Classificação");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel Superior: Controles
        JPanel painelControles = new JPanel(new FlowLayout());
        painelControles.add(new JLabel("Vetor:"));
        txtVetor = new JTextField("10, 8, 7, 5, 4, 2, 1", 15);
        painelControles.add(txtVetor);
        cbAlgoritmo = new JComboBox<>(algoritmos.toArray(new String[0]));
        painelControles.add(cbAlgoritmo);
        btnIniciar = new JButton("Iniciar Ordenação");
        painelControles.add(btnIniciar);

        // Painel Central: Gráfico
        painelVisual = new PainelVisualizacao();

        // Painel Direito: Tabela de rastreio
        tableModel = new DefaultTableModel(COLUNAS, 0);
        JTable tabelaRastreio = new JTable(tableModel);
        tabelaRastreio.setFont(new Font("Monospaced", Font.PLAIN, 12));
        tabelaRastreio.setRowHeight(22);
        JScrollPane scrollTabela = new JScrollPane(tabelaRastreio);
        scrollTabela.setPreferredSize(new Dimension(550, 400));

        // Painel Inferior: Indicadores
        JPanel painelMetricas = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 10));
        painelMetricas.setBackground(new Color(240, 240, 240));
        painelMetricas.setBorder(
                BorderFactory.createMatteBorder(1, 0, 0, 0, Color.LIGHT_GRAY));

        lblTrocas = new JLabel();
        lblCopias = new JLabel();
        lblTempo = new JLabel();
        Font fonteMetricas = new Font("SansSerif", Font.BOLD, 14);
        lblTrocas.setFont(fonteMetricas);
        lblCopias.setFont(fonteMetricas);
        lblTempo.setFont(fonteMetricas);
        painelMetricas.add(lblTrocas);
        painelMetricas.add(lblCopias);
        painelMetricas.add(lblTempo);
        atualizarMetricas(Metricas.inicial());

        // Montagem do Frame
        add(painelControles, BorderLayout.NORTH);
        add(painelVisual, BorderLayout.CENTER);
        add(scrollTabela, BorderLayout.EAST);
        add(painelMetricas, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }

    // --- Entrada do usuário ---

    public String getVetorTexto() {
        return txtVetor.getText();
    }

    public String getAlgoritmoSelecionado() {
        return (String) cbAlgoritmo.getSelectedItem();
    }

    public void addIniciarListener(ActionListener listener) {
        btnIniciar.addActionListener(listener);
    }

    // --- Atualização da apresentação (Controller) ---

    public PainelVisualizacao getPainelVisualizacao() {
        return painelVisual;
    }

    public void setBotaoHabilitado(boolean habilitado) {
        btnIniciar.setEnabled(habilitado);
    }

    public void limparTabela() {
        tableModel.setRowCount(0);
    }

    public void adicionarPasso(PassoTabela passo) {
        tableModel.addRow(passo.toRow());
    }

    public void atualizarMetricas(Metricas metricas) {
        lblTrocas.setText("Trocas: " + metricas.trocas());
        lblCopias.setText("Cópias de Memória: " + metricas.copias());
        lblTempo.setText("Tempo (Lógica): " + metricas.tempoTexto());
    }

    public void mostrarErro(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "Erro de Entrada",
                JOptionPane.ERROR_MESSAGE);
    }
}
