package com.algoritmos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Arrays;

public class VisualizadorAlgoritmos extends JPanel {
    private int[] array;
    private int indiceAtual = -1;
    private int indiceAlvo = -1;

    // Componentes de UI
    private static DefaultTableModel tableModel;
    private static JButton btnIniciar;
    private static JTextField txtVetor;
    private static JComboBox<String> cbAlgoritmo;
    
    // Indicadores de Desempenho
    private static JLabel lblTrocas;
    private static JLabel lblCopias;
    private static JLabel lblTempo;

    public VisualizadorAlgoritmos(int[] array) {
        this.array = array;
        setPreferredSize(new Dimension(500, 400));
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (array == null || array.length == 0) return;

        int larguraBarra = getWidth() / array.length;
        int maxValor = Arrays.stream(array).max().orElse(1);
        double fatorEscala = (double) (getHeight() - 40) / maxValor;

        for (int i = 0; i < array.length; i++) {
            int alturaBarra = (int) (array[i] * fatorEscala);

            if (i == indiceAtual || i == indiceAlvo) {
                g.setColor(new Color(220, 53, 69)); // Vermelho
            } else {
                g.setColor(new Color(13, 110, 253)); // Azul
            }

            g.fillRect(i * larguraBarra + 5, getHeight() - alturaBarra, larguraBarra - 10, alturaBarra);
            
            g.setColor(Color.BLACK);
            g.setFont(new Font("Monospaced", Font.BOLD, 14));
            g.drawString(String.valueOf(array[i]), i * larguraBarra + (larguraBarra / 2) - 5, getHeight() - alturaBarra - 5);
        }
    }

    public void atualizarIndices(int[] novoArray, int i, int j) {
        this.array = novoArray.clone();
        this.indiceAtual = i;
        this.indiceAlvo = j;
        try {
            repaint();
            Thread.sleep(200); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void registrarPassoTabela(String fase, String foco, String testes, String arrayEstado, String acao) {
        SwingUtilities.invokeLater(() -> {
            tableModel.addRow(new Object[]{fase, foco, testes, arrayEstado, acao});
        });
    }

    private void atualizarMetricas(int trocas, int copias, String tempoTexto) {
        SwingUtilities.invokeLater(() -> {
            lblTrocas.setText("Trocas: " + trocas);
            lblCopias.setText("Cópias de Memória: " + copias);
            lblTempo.setText("Tempo (Lógica): " + tempoTexto);
        });
    }

    // Método que realiza a troca e conta as cópias (1 troca = 3 cópias)
    private void exchange(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    // --- ALGORITMOS DE ORDENAÇÃO (COM MÉTRICAS) ---

    private void executarSelectionSort(int[] a, long tempoRealNanos) {
        int trocas = 0;
        int copias = 0;
        atualizarMetricas(trocas, copias, "Animando...");
        registrarPassoTabela("Início", "-", "-", Arrays.toString(a), "Início Selection Sort");
        
        for (int i = 0; i < a.length; i++) {
            int min = i;
            StringBuilder comparacoes = new StringBuilder();

            for (int j = i + 1; j < a.length; j++) {
                comparacoes.append(j).append(" ");
                atualizarIndices(a, j, min);
                if (a[j] < a[min]) {
                    min = j;
                }
            }

            String acao;
            if (min != i) {
                acao = "Troca (" + a[i] + " ↔ " + a[min] + ")";
                exchange(a, min, i);
                trocas++;
                copias += 3;
            } else {
                acao = "Mantém";
            }
            
            atualizarMetricas(trocas, copias, "Animando...");
            atualizarIndices(a, i, min);
            registrarPassoTabela("i=" + i, "min=" + a[min], comparacoes.toString().trim(), Arrays.toString(a), acao);
        }
        atualizarMetricas(trocas, copias, tempoRealNanos + " ns");
    }

    private void executarInsertionSort(int[] a, long tempoRealNanos) {
        int trocas = 0;
        int copias = 0;
        atualizarMetricas(trocas, copias, "Animando...");
        registrarPassoTabela("Início", "-", "-", Arrays.toString(a), "Início Insertion Sort");
        
        for (int i = 1; i < a.length; i++) {
            StringBuilder comparacoes = new StringBuilder();
            boolean trocou = false;
            
            for (int j = i; j > 0; j--) {
                comparacoes.append(a[j-1]).append(">").append(a[j]).append(" ");
                atualizarIndices(a, j - 1, j);
                
                if (a[j - 1] > a[j]) {
                    exchange(a, j - 1, j);
                    trocas++;
                    copias += 3;
                    trocou = true;
                    atualizarMetricas(trocas, copias, "Animando...");
                    atualizarIndices(a, j - 1, j);
                } else {
                    break;
                }
            }
            String acao = trocou ? "Inseriu à esquerda" : "Posição correta";
            registrarPassoTabela("i=" + i, "alvo=" + a[i], comparacoes.toString().trim(), Arrays.toString(a), acao);
        }
        atualizarMetricas(trocas, copias, tempoRealNanos + " ns");
    }

    private void executarBubbleSort(int[] a, long tempoRealNanos) {
        int trocas = 0;
        int copias = 0;
        atualizarMetricas(trocas, copias, "Animando...");
        registrarPassoTabela("Início", "-", "-", Arrays.toString(a), "Início Bubble Sort");
        boolean exchangeStatus;
        int iteracao = 0;
        
        do {
            exchangeStatus = false;
            StringBuilder comparacoes = new StringBuilder();
            boolean houveTrocaNaPassagem = false;

            for (int i = 0; i < a.length - 1; i++) {
                comparacoes.append(i).append("x").append(i+1).append(" ");
                atualizarIndices(a, i, i + 1);

                if (a[i] > a[i + 1]) {
                    exchange(a, i, i + 1);
                    trocas++;
                    copias += 3;
                    exchangeStatus = true;
                    houveTrocaNaPassagem = true;
                    atualizarMetricas(trocas, copias, "Animando...");
                    atualizarIndices(a, i, i + 1);
                }
            }
            
            String acao = houveTrocaNaPassagem ? "Bolha subiu (Trocas ocorridas)" : "Array ordenado (Sem trocas)";
            registrarPassoTabela("Passagem " + (++iteracao), "Flag=" + exchangeStatus, comparacoes.toString().trim(), Arrays.toString(a), acao);
            
        } while (exchangeStatus);
        
        atualizarMetricas(trocas, copias, tempoRealNanos + " ns");
    }

    // --- SIMULAÇÃO PARA CÁLCULO DE TEMPO REAL ---
    private static long medirTempoAlgoritmo(int[] a, String algoritmo) {
        int[] clone = a.clone();
        long inicio = System.nanoTime();
        
        if ("Selection Sort".equals(algoritmo)) {
            for (int i = 0; i < clone.length; i++) {
                int min = i;
                for (int j = i + 1; j < clone.length; j++) {
                    if (clone[j] < clone[min]) min = j;
                }
                int tmp = clone[min]; clone[min] = clone[i]; clone[i] = tmp;
            }
        } else if ("Insertion Sort".equals(algoritmo)) {
            for (int i = 1; i < clone.length; i++) {
                for (int j = i; j > 0 && clone[j - 1] > clone[j]; j--) {
                    int tmp = clone[j]; clone[j] = clone[j-1]; clone[j-1] = tmp;
                }
            }
        } else if ("Bubble Sort".equals(algoritmo)) {
            boolean ex;
            do {
                ex = false;
                for (int i = 0; i < clone.length - 1; i++) {
                    if (clone[i] > clone[i + 1]) {
                        int tmp = clone[i]; clone[i] = clone[i+1]; clone[i+1] = tmp;
                        ex = true;
                    }
                }
            } while (ex);
        }
        
        return System.nanoTime() - inicio;
    }

    // --- CONFIGURAÇÃO DA INTERFACE GRÁFICA ---

    public static void main(String[] args) {
        JFrame frame = new JFrame("Visualizador de Algoritmos - Classificação");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Painel Superior: Controles
        JPanel painelControles = new JPanel(new FlowLayout());
        painelControles.add(new JLabel("Vetor:"));
        txtVetor = new JTextField("10, 8, 7, 5, 4, 2, 1", 15);
        painelControles.add(txtVetor);
        cbAlgoritmo = new JComboBox<>(new String[]{"Selection Sort", "Insertion Sort", "Bubble Sort"});
        painelControles.add(cbAlgoritmo);
        btnIniciar = new JButton("Iniciar Ordenação");
        painelControles.add(btnIniciar);

        // Painel Central: Gráfico
        VisualizadorAlgoritmos painelVisual = new VisualizadorAlgoritmos(new int[0]);

        // Painel Direito: Tabela
        String[] colunas = {"Fase / Iteração", "Elemento Foco", "Varredura / Testes", "Estado do Array", "Ação"};
        tableModel = new DefaultTableModel(colunas, 0);
        JTable tabelaRastreio = new JTable(tableModel);
        tabelaRastreio.setFont(new Font("Monospaced", Font.PLAIN, 12));
        tabelaRastreio.setRowHeight(22);
        JScrollPane scrollTabela = new JScrollPane(tabelaRastreio);
        scrollTabela.setPreferredSize(new Dimension(550, 400));

        // NOVO: Painel Inferior: Indicadores
        JPanel painelMetricas = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 10));
        painelMetricas.setBackground(new Color(240, 240, 240));
        painelMetricas.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.LIGHT_GRAY));
        
        lblTrocas = new JLabel("Trocas: 0");
        lblCopias = new JLabel("Cópias de Memória: 0");
        lblTempo = new JLabel("Tempo (Lógica): 0 ns");
        
        Font fonteMetricas = new Font("SansSerif", Font.BOLD, 14);
        lblTrocas.setFont(fonteMetricas);
        lblCopias.setFont(fonteMetricas);
        lblTempo.setFont(fonteMetricas);
        
        painelMetricas.add(lblTrocas);
        painelMetricas.add(lblCopias);
        painelMetricas.add(lblTempo);

        // Montagem do Frame
        frame.add(painelControles, BorderLayout.NORTH);
        frame.add(painelVisual, BorderLayout.CENTER);
        frame.add(scrollTabela, BorderLayout.EAST);
        frame.add(painelMetricas, BorderLayout.SOUTH);
        
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Ação do Botão
        btnIniciar.addActionListener(e -> {
            try {
                String[] partes = txtVetor.getText().split(",");
                int[] vetorInicial = new int[partes.length];
                for (int i = 0; i < partes.length; i++) {
                    vetorInicial[i] = Integer.parseInt(partes[i].trim());
                }

                tableModel.setRowCount(0);
                painelVisual.array = vetorInicial.clone();
                painelVisual.repaint();
                btnIniciar.setEnabled(false); 

                String algEscolhido = (String) cbAlgoritmo.getSelectedItem();
                
                // Mede o tempo computacional puro (sem animação visual)
                long tempoReal = medirTempoAlgoritmo(vetorInicial, algEscolhido);

                new Thread(() -> {
                    try {
                        if ("Selection Sort".equals(algEscolhido)) {
                            painelVisual.executarSelectionSort(vetorInicial, tempoReal);
                        } else if ("Insertion Sort".equals(algEscolhido)) {
                            painelVisual.executarInsertionSort(vetorInicial, tempoReal);
                        } else if ("Bubble Sort".equals(algEscolhido)) {
                            painelVisual.executarBubbleSort(vetorInicial, tempoReal);
                        }
                    } finally {
                        painelVisual.atualizarIndices(vetorInicial, -1, -1);
                        SwingUtilities.invokeLater(() -> btnIniciar.setEnabled(true));
                    }
                }).start();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Por favor, insira apenas números inteiros separados por vírgula.", "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}