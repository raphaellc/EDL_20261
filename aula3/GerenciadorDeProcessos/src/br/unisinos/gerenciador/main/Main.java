package br.unisinos.gerenciador.main;

import br.unisinos.gerenciador.modelo.Processo;
import br.unisinos.gerenciador.servico.EscalonadorProcesso;

public class Main {
    public static void main(String[] args) {
        // 1. Instanciação do serviço (o "motor" do projeto)
        EscalonadorProcesso escalonador = new EscalonadorProcesso();

        System.out.println("=== Sistema de Escalonamento de Processos UNISINOS ===\n");

        // 2. Criação de processos (Objetos da camada de modelo)
        // Lógica: Processo(Nome, Tempo em ms, Prioridade)
        // Quanto menor o número de prioridade, mais urgente ele é.
        Processo p1 = new Processo("Interface Gráfica", 1500, 3);
        Processo p2 = new Processo("Kernel Sync", 500, 1);
        Processo p3 = new Processo("Driver de Áudio", 1000, 2);
        Processo p4 = new Processo("Download Background", 5000, 5);

        // 3. Admissão dos processos na estrutura de dados (ArrayList)
        System.out.println("Admitindo processos no sistema...");
        escalonador.admitirProcesso(p1);
        escalonador.admitirProcesso(p2);
        escalonador.admitirProcesso(p3);
        escalonador.admitirProcesso(p4);

        // 4. Execução da lógica de negócio
        // Aqui dentro o ArrayList será percorrido e os processos "executados"
        escalonador.processarTudo();

        System.out.println("\n=== Todos os processos foram finalizados ===");
    }
}