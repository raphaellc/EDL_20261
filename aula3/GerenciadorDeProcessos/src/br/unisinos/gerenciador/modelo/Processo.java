package br.unisinos.gerenciador.modelo;

public class Processo {
    private String nome;
    private int tempoExecucao;
    private int prioridade; // Adicionado para lógica de negócio

    public Processo(String nome, int tempo, int prioridade) {
        this.nome = nome;
        this.tempoExecucao = tempo;
        this.prioridade = prioridade;
    }
    // Getters e Setters aqui...

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTempoExecucao() {
        return tempoExecucao;
    }

    public void setTempoExecucao(int tempoExecucao) {
        this.tempoExecucao = tempoExecucao;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }
}