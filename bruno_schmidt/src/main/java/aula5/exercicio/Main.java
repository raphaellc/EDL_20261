package aula5.exercicio;

public class Main {
    static void main() {
        var lista = new ListaPessoas();

        lista.inserir(new Pessoa("Alice", 30));
        lista.inserir(new Pessoa("Bob", 25));
        lista.inserir(new Pessoa("Carlos", 40));

        lista.percorrer();
        IO.println();

        lista.remover("Bob");
        IO.println();

        lista.percorrer();
        IO.println();

        IO.println(lista.buscar("Alice"));
    }
}
