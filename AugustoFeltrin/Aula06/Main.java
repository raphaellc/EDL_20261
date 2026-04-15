package AugustoFeltrin.Aula06;

public class Main {
    public static void main(String[] args) {

        ListaDupla<Integer> lista = new ListaDupla<>();

        System.out.println("Lista vazia? " + lista.isEmpty());

        lista.addFirst(10);
        lista.addFirst(20);
        lista.addFirst(30);

        System.out.println("Lista - addFirst:");
        System.out.println(lista);

        lista.addLast(40);
        lista.addLast(50);

        System.out.println("Lista - addLast:");
        System.out.println(lista);

        lista.removeFirst();
        System.out.println("Lista - removeFirst:");
        System.out.println(lista);

        lista.removeLast();
        System.out.println("Lista - removeLast:");
        System.out.println(lista);

        System.out.println("Tamanho da lista: " + lista.size());
    }
}