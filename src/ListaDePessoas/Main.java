package ListaDePessoas;

public class Main {
    public static void main(String[] args) {
        ListaPessoas lista = new ListaPessoas();

        // Inserindo pessoas
        lista.inserir(new Pessoa("Alice", 30));
        lista.inserir(new Pessoa("Bob", 25));
        lista.inserir(new Pessoa("Carlos", 40));

        // Exibindo cadastradas
        lista.percorrer();

        lista.remover("Bob");

        // Exibindo novamente
        lista.percorrer();

        // Buscando uma pessoa
        System.out.println("\nResultado da busca:");
        Pessoa encontrada = lista.buscar("Alice");
        if (encontrada != null) {
            System.out.println(encontrada);
        } else {
            System.out.println("Pessoa não encontrada.");
        }
    }
}