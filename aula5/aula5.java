import Lista.ListaEncadeada;

public class aula5 {
    public static void main(String[] args) {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        // --- adicionar ao final ---
        lista.adicionar(10);
        lista.adicionar(20);
        lista.adicionar(30);
        lista.adicionar(40);
        lista.adicionar(50);
        System.out.println("Lista inicial:       " + lista);

        // --- adicionar por posição ---
        lista.adicionar(0, 5);
        System.out.println("Inserir 5 na pos 0:  " + lista);
        lista.adicionar(3, 25);
        System.out.println("Inserir 25 na pos 3: " + lista);
        lista.adicionar(lista.getTamanho(), 99);
        System.out.println("Inserir 99 no fim:   " + lista);

        // --- obter por posição (Optional) ---
        lista.obter(0).ifPresent(v -> System.out.println("obter(0): " + v));
        lista.obter(3).ifPresent(v -> System.out.println("obter(3): " + v));
        System.out.println("obter(99) presente? " + lista.obter(99).isPresent());

        // --- contemNaLista ---
        System.out.println("Contém 25? " + lista.contemNaLista(25));
        System.out.println("Contém 77? " + lista.contemNaLista(77));

        // --- remover por posição ---
        System.out.println("remover(0): " + lista.remover(0) + " → " + lista);
        System.out.println("remover(2): " + lista.remover(2) + " → " + lista);
        System.out.println("remover(99): " + lista.remover(99));

        // --- remover por valor ---
        System.out.println("remover(50): " + lista.remover(Integer.valueOf(50)) + " → " + lista);
        System.out.println("remover(77): " + lista.remover(Integer.valueOf(77)));

        // --- tamanho / vazia ---
        System.out.println("Tamanho: " + lista.getTamanho());
        System.out.println("Está vazia? " + lista.estaVazia());

        // --- limpar ---
        lista.limpar();
        System.out.println("Após limpar: " + lista);
        System.out.println("Está vazia? " + lista.estaVazia());
    }
}
