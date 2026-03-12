package br.unisinos.gerenciador.servico;

import java.util.ArrayList;
import java.util.List;

import br.unisinos.gerenciador.modelo.Processo;

public class EscalonadorProcesso {
    private List<Processo> fila = new ArrayList<>();

    public void admitirProcesso(Processo p) {
        fila.add(p);
    }

    public void processarTudo() {
        // Aqui você chamaria seu TimSort antes de processar
        System.out.println("Ordenando processos por prioridade...");
        // Exemplo: Collections.sort(fila, ...);
        
        for (Processo p : fila) {
            System.out.println("Executando: " + p.getNome());
        }
    }
}