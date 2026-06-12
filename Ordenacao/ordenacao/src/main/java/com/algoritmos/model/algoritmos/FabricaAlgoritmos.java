package com.algoritmos.model.algoritmos;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Fábrica/registro dos algoritmos de ordenação disponíveis.
 *
 * <p>Centraliza a criação das estratégias para que View e Controller não
 * precisem conhecer as classes concretas. Para adicionar um novo algoritmo
 * basta registrá-lo aqui.</p>
 */
public final class FabricaAlgoritmos {

    private static final Map<String, AlgoritmoOrdenacao> ALGORITMOS = new LinkedHashMap<>();

    static {
        registrar(new SelectionSort());
        registrar(new InsertionSort());
        registrar(new BubbleSort());
    }

    private FabricaAlgoritmos() {
    }

    private static void registrar(AlgoritmoOrdenacao algoritmo) {
        ALGORITMOS.put(algoritmo.getNome(), algoritmo);
    }

    /** Nomes dos algoritmos disponíveis, na ordem de registro. */
    public static List<String> nomes() {
        return List.copyOf(ALGORITMOS.keySet());
    }

    /**
     * Obtém o algoritmo pelo nome.
     *
     * @throws IllegalArgumentException se o nome não estiver registrado
     */
    public static AlgoritmoOrdenacao obter(String nome) {
        AlgoritmoOrdenacao algoritmo = ALGORITMOS.get(nome);
        if (algoritmo == null) {
            throw new IllegalArgumentException("Algoritmo desconhecido: " + nome);
        }
        return algoritmo;
    }
}
