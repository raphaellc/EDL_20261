import java.util.Random;
import java.util.ArrayList;
import java.util.LinkedList;

void main() {
    System.out.println("[=[ - [=[  Isso é um sinal que está tudo funcionando  ]=] - ]=]\n");

    Fila<String> Fila_Do_Super = new Fila<String>();
    Pilha<String> Pilha_de_Manga = new Pilha<String>();

    System.out.println("\n[{}] Fila:\n");

    System.out.println("Tentando remover uma fila vazia:");
   if (Fila_Do_Super.removerFila() == null) {
       System.out.println("Mais vazia q minha alma\n");
   };

    Fila_Do_Super.InserirFila("Obama");
    Fila_Do_Super.InserirFila("Bob Esponja");
    Fila_Do_Super.InserirFila("Mãe do Musculoso");
    Fila_Do_Super.InserirFila("Cebolinha");
    Fila_Do_Super.InserirFila("Goku");
    Fila_Do_Super.InserirFila("Minos Prime");
    Fila_Do_Super.InserirFila("Judas");

    System.out.println("Pessoa na frente da fila: " + Fila_Do_Super.frenteFila() + " || Tamanho da Fila: " + Fila_Do_Super.tamanhoFila());

    Fila_Do_Super.listaFila();

    System.out.println("Removendo um senhor da fila:");
    Fila_Do_Super.removerFila();

    System.out.println("Pessoa na frente da fila: " + Fila_Do_Super.frenteFila() + " || Tamanho da Fila: " + Fila_Do_Super.tamanhoFila());

    System.out.println("Pessoas na fila:");
    Fila_Do_Super.listaFila();

    System.out.println("Atendendo alguns clientes:");
    Fila_Do_Super.atender();
    Fila_Do_Super.atender();
    Fila_Do_Super.atender();

    System.out.println("\nClientes atendidos:"); Fila_Do_Super.listaAtendidos();
    System.out.println("\nClientes restantes:");  Fila_Do_Super.listaFila();


/// ____________________________________________________________________________________________________________________

    System.out.println("\n[{}] Pilha:\n");

    System.out.println("Tentando remover uma Pilha vazia:");
    if (Pilha_de_Manga.desempilhar() == null) {
        System.out.println("Mais vazia q sua alma\n");
    }

    Pilha_de_Manga.empilhar("Demon Slayer");
    Pilha_de_Manga.empilhar("Jujutsu Kaisen");
    Pilha_de_Manga.empilhar("Kasamoto Days");


    System.out.println("Tamanho da Pilha: " + Pilha_de_Manga.getTamanho());
    System.out.println("Manga no topo da Pilha: " + Pilha_de_Manga.getTopo());
    System.out.println("Coisas na Pilha:");
    Pilha_de_Manga.listaPilha();

    Pilha_de_Manga.desempilhar();

    System.out.println("Novo Tamanho da Pilha: " + Pilha_de_Manga.getTamanho());
    System.out.println("Novo Manga no topo da Pilha: " + Pilha_de_Manga.getTopo());
    System.out.println("Novas Coisas na Pilha:");
    Pilha_de_Manga.listaPilha();

}

public class No<T> {
    private T dado;
    private No<T> proximo;
    private No<T> anterior;
    boolean privilegiado;
    private int senha;

    public No(T dado) {
        this.dado = dado;
        this.proximo = null;
        this.anterior = null;
        this.privilegiado = false;
        this.senha = 0;
    }

    public T getDado()               { return dado; }
    public void setDado(T dado)      { this.dado = dado; }
    public No<T> getProximo()        { return proximo; }
    public void setProximo(No<T> p)  { this.proximo = p; }
    public No<T> getAnterior()       { return anterior; }
    public void setAnterior(No<T> a) { this.anterior = a; }
    public boolean isPrivilegiado()  { return privilegiado; }
    public void setPrivilegiado(boolean privilegiado) { this.privilegiado = privilegiado; }
    public int getSenha()            { return senha; }
    public void setSenha(int senha)  { this.senha = senha; }
}


public class Fila<T> {
    No<T> inicio;
    No<T> fim;
    int tamanho;
    ArrayList<T> Atendidos_Fila = new ArrayList<T>();
    ArrayList<Integer> Senhas_Atendidos = new ArrayList<>();
    Random Gerador_Senha = new Random();


    public Fila() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public void InserirFila(T dado){
        No<T> novoNo = new No(dado);
        if (Empty()) {
            this.inicio = novoNo;
            this.fim = this.inicio;
        }

        else {
            novoNo.setProximo(this.fim);
            this.fim.setAnterior(novoNo);
            this.fim = novoNo;
        }

        tamanho++;
        if (tamanho%3 == 0) { novoNo.setPrivilegiado(true); }

    }
    public T removerFila(){

        T dado_return = null;
        if (Empty()) {
            return dado_return;
        }

        else if (tamanho == 1) {
            dado_return = this.inicio.getDado();
            this.inicio = null;
            this.fim = null;
            tamanho--;
            return dado_return;
        }

        else {
            dado_return = this.inicio.getDado();
            this.inicio = this.inicio.getAnterior();
            this.inicio.setProximo(null);
            tamanho--;
            return dado_return;
        }
    }

    public void atender(){
        if (Empty()) {
            return;
        }

        No<T> dado_atendimento = this.inicio;
        int num_senha = Gerador_Senha.nextInt(1111 , 9999);

        dado_atendimento.setSenha(num_senha);

        if (dado_atendimento.isPrivilegiado() == false) {
            System.out.println(dado_atendimento.getDado() + "   Atendido");
        }

        else {
            System.out.println(dado_atendimento.getDado() + "   Atendido (Prioritario)");
        }

        Atendidos_Fila.add(dado_atendimento.getDado());
        Senhas_Atendidos.add(dado_atendimento.getSenha());
        removerFila();
    }

    public T frenteFila(){

        if (Empty()) { return null; }
        else { return this.inicio.getDado(); }

    }
    public int tamanhoFila(){
        return tamanho;
    }
    public boolean Empty(){
        return tamanho == 0;
    }

    public void listaFila() {

        if (Empty()) {
            return;
        }

        else {

            No<T> dado_lista = this.inicio;
            while (dado_lista.getAnterior() != null) {
                if (dado_lista.isPrivilegiado() == true) { System.out.println(" - " + dado_lista.getDado() + " [Privilegiado]"); }
                else { System.out.println(" - " + dado_lista.getDado()); }
                dado_lista = dado_lista.getAnterior();
            }

            System.out.println(" - " + dado_lista.getDado());

        }

    }

    public void listaAtendidos() {
        System.out.println("Nomes: " + Atendidos_Fila);
        System.out.println("Senhas: " + Senhas_Atendidos);
    }

}

public class Pilha<T> {
    private No<T> Topo;
    private int tamanho;

    public Pilha() {
        this.Topo = null;
        this.tamanho = 0;
    }

    public T getTopo() {
        if (empty()) { return null; }
        else { return Topo.getDado(); }
    }

    public void empilhar(T dado){

        if (empty()) {

            Topo = new No<T>(dado);

        }

        else {

            No<T>novo_no = new No<T>(dado);
            novo_no.setProximo(Topo);
            Topo = novo_no;

        }
        tamanho++;
    }

    public T desempilhar() {
        if (empty()) {
            return null;
        }

        tamanho--;
        T dado_remover = Topo.getDado();
        Topo = Topo.getProximo();
        return dado_remover;

    }

    public int getTamanho() { return tamanho; }

    public boolean empty() { return tamanho == 0; }

    public void listaPilha() {

        if (empty()) {
            return;
        }

        No<T> no_lista = this.Topo;

        while(no_lista.getProximo() != null) {
            System.out.println(" - " + no_lista.getDado());
            no_lista = no_lista.getProximo();
        }
        System.out.println(" - " + no_lista.getDado());

    }

    public void listaSenhas() {
        if (empty()) {
            return;
        }

    }
}