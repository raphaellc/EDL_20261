package ListaEncadeada;

public class Main {
    public static void main(String[] args) {

        ListaPessoas lista = new ListaPessoas();

        lista.inserir(new Pessoa("Renato", 21));
        lista.inserir(new Pessoa("Letícia", 28));
        lista.inserir(new Pessoa("Maicon", 36));
    
        System.out.println("-- LISTA PRESENÇA --");
        lista.percorrer();

        lista.remover("Maicon");
        lista.inserir(new Pessoa("Gabriela", 19));
        lista.inserir(new Pessoa("Dario", 67));
        System.out.println("-- LISTA ATUALIZADA --");
        lista.percorrer();

        System.out.println("-- PROCURANDO POR ... --");
        System.out.println(lista.buscar("Gabriela"));
    
    
    }
    
}
