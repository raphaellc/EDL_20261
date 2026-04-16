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

        System.out.println("Buscar 20: " + lista.buscar(20));
        System.out.println("Buscar 99: " + lista.buscar(99));

        lista.removeFirst();
        System.out.println("Lista - removeFirst:");
        System.out.println(lista);

        lista.removeLast();
        System.out.println("Lista - removeLast:");
        System.out.println(lista);
    }
}