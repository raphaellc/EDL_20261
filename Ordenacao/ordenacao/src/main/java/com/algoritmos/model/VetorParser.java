package com.algoritmos.model;

/**
 * Utilitário de conversão do texto de entrada em um vetor de inteiros.
 */
public final class VetorParser {

    private VetorParser() {
    }

    /**
     * Converte uma string de inteiros separados por vírgula em {@code int[]}.
     *
     * @param texto entrada do usuário (ex.: "10, 8, 7, 5")
     * @return vetor de inteiros correspondente
     * @throws NumberFormatException se algum elemento não for inteiro válido
     */
    public static int[] parse(String texto) {
        String[] partes = texto.split(",");
        int[] vetor = new int[partes.length];
        for (int i = 0; i < partes.length; i++) {
            vetor[i] = Integer.parseInt(partes[i].trim());
        }
        return vetor;
    }
}
