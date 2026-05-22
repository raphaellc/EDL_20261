import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

void main() {
    System.out.println("[=[ - [=[  Isso é um sinal que está tudo funcionando  ]=] - ]=]\n");

    Fila<String> Fila_Do_Super = new Fila<String>();
    Pilha<String> Pilha_de_Manga = new Pilha<String>();

    boolean menu = true;
    Scanner cin = new Scanner(System.in);
    int choice;

    while (menu == true) {

        System.out.println("\n\n - Escolha um:\n -- Sair (0)\n -- Fila(1)\n -- Pilha(2)");
        IO.print(" [Type Here ->] ");    choice = cin.nextInt();

        while (choice < -1 || choice > 2) {
            System.out.println("0 , 1 OU 2 PORRA.");
            IO.print(" [Type Here ->] ");    choice = cin.nextInt();
        }

        if (choice == 0) {
            menu = false;
            System.out.print("Bye-bye!");
        }

       else if (choice == 1) {

           boolean loop = true;

            System.out.println("\n[{}] Fila:\n");

            Fila_Do_Super.InserirFila("Obama");
            Fila_Do_Super.InserirFila("Bob Esponja");
            Fila_Do_Super.InserirFila("Mãe do Musculoso");
            Fila_Do_Super.InserirFila("Cebolinha");
            Fila_Do_Super.InserirFila("Goku");
            Fila_Do_Super.InserirFila("Gabriel Ultrakill");
            Fila_Do_Super.InserirFila("Judas");
            Fila_Do_Super.InserirFila("Mike Tyson");
            Fila_Do_Super.InserirFila("Leon Kennedy");
            Fila_Do_Super.InserirFila("Dante Sparda");
            Fila_Do_Super.InserirFila("Sans Undertale");


            while (loop == true) {

                System.out.println("Pessoa na frente da fila: " + Fila_Do_Super.frenteFila() + " || Tamanho da Fila: " + Fila_Do_Super.tamanhoFila());

                Fila_Do_Super.listaFila();

                System.out.println("Pessoas na fila:");
                Fila_Do_Super.listaFila();
                Fila_Do_Super.listaSenhas();

                System.out.println("Atendendo um cliente:");
                Fila_Do_Super.atender();

                System.out.println("\nClientes atendidos:");
                Fila_Do_Super.listaAtendidos();
                if (Fila_Do_Super.Empty() == true) {
                    System.out.println("\n Todos os clientes foram atendidos");
                    loop = false;
                }
            }

        }
/// ____________________________________________________________________________________________________________________

    else if (choice == 2) {
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
    }
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
    ArrayList<Integer> Senhas_Lista = new ArrayList<>();
    Random Gerador_Senha = new Random();
    Random Privilegiador = new Random();


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

        novoNo.setProximo(this.fim);
        this.fim.setAnterior(novoNo);
        this.fim = novoNo;

        int coinflip = Privilegiador.nextInt(3) + 1;
        int num_senha = Gerador_Senha.nextInt(1111 , 9999);
        novoNo.setSenha(num_senha);
        Senhas_Lista.add(num_senha);

        if (coinflip == 3) { novoNo.setPrivilegiado(true); }
        else { novoNo.setPrivilegiado(false); }
        tamanho++;
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
        int contador = 1;

        if (dado_atendimento.isPrivilegiado() == false) {

            if (dado_atendimento.isPrivilegiado() == false && contador == 3) {
                while (dado_atendimento.isPrivilegiado() == false && dado_atendimento.getProximo() != null) {
                    dado_atendimento.getProximo();
                }

                if (dado_atendimento.isPrivilegiado() == true && dado_atendimento.getProximo() == null) {
                    System.out.println(dado_atendimento.getDado() + "   Atendido (Prioritario)");
                }

                else { return; }
            }

            System.out.println(dado_atendimento.getDado() + "   Atendido");
            contador++;
        }
        else {
            System.out.println(dado_atendimento.getDado() + "   Atendido (Prioritario)");
            contador = 1;
        }

        Atendidos_Fila.add(dado_atendimento.getDado());
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
                if (dado_lista.isPrivilegiado() == true) { System.out.println(" - " + dado_lista.getDado() + " [Prioritario]"); }
                else { System.out.println(" - " + dado_lista.getDado()); }
                dado_lista = dado_lista.getAnterior();
            }

            System.out.println(" - " + dado_lista.getDado());

        }

    }

    public void listaAtendidos() {
        System.out.println("Nomes: " + Atendidos_Fila);
    }

    public void listaSenhas() {
        System.out.println("Senhas: " + Senhas_Lista);
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
}
