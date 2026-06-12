package com.algoritmos.view;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Arrays;

/**
 * Painel que desenha o vetor como um gráfico de barras, destacando os
 * dois índices em foco.
 *
 * <p>Componente puramente visual: não contém lógica de ordenação nem
 * controla threads/animação — apenas reflete o estado que recebe via
 * {@link #setEstado}.</p>
 */
public class PainelVisualizacao extends JPanel {

    private static final Color COR_DESTAQUE = new Color(220, 53, 69); // Vermelho
    private static final Color COR_BARRA = new Color(13, 110, 253);   // Azul

    private int[] array;
    private int indiceAtual = -1;
    private int indiceAlvo = -1;

    public PainelVisualizacao() {
        this.array = new int[0];
        setPreferredSize(new Dimension(500, 400));
        setBackground(Color.WHITE);
    }

    /** Define o array exibido, limpando os destaques. */
    public void setArray(int[] array) {
        setEstado(array, -1, -1);
    }

    /**
     * Atualiza o estado exibido. Deve ser chamado na Event Dispatch Thread
     * (o Controller cuida disso via {@code invokeLater}).
     *
     * @param array estado do array a desenhar
     * @param i     primeiro índice destacado (ou -1)
     * @param j     segundo índice destacado (ou -1)
     */
    public void setEstado(int[] array, int i, int j) {
        this.array = array.clone();
        this.indiceAtual = i;
        this.indiceAlvo = j;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (array == null || array.length == 0) {
            return;
        }

        int larguraBarra = getWidth() / array.length;
        int maxValor = Arrays.stream(array).max().orElse(1);
        double fatorEscala = (double) (getHeight() - 40) / maxValor;

        for (int i = 0; i < array.length; i++) {
            int alturaBarra = (int) (array[i] * fatorEscala);

            if (i == indiceAtual || i == indiceAlvo) {
                g.setColor(COR_DESTAQUE);
            } else {
                g.setColor(COR_BARRA);
            }

            g.fillRect(i * larguraBarra + 5, getHeight() - alturaBarra,
                    larguraBarra - 10, alturaBarra);

            g.setColor(Color.BLACK);
            g.setFont(new Font("Monospaced", Font.BOLD, 14));
            g.drawString(String.valueOf(array[i]),
                    i * larguraBarra + (larguraBarra / 2) - 5,
                    getHeight() - alturaBarra - 5);
        }
    }
}
