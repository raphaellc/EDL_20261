package raphaellc.ExemplosEstruturasDeDadosLineares;

import java.util.*;

public class ExemploColecoes {
    public static void main(String[] args) {
        
        // 1. LIST & ARRAYLIST: Acesso rápido por índice
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Java");
        arrayList.add("Python");
        arrayList.add("C++");
        // Acesso aleatório rápido (O(1))
        System.out.println("ArrayList (índice 1): " + arrayList.get(1)); 

        // 2. LINKEDLIST: Rápida inserção/remoção nas extremidades
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Elemento B");
        linkedList.addFirst("Elemento A"); // Método de Deque
        linkedList.addLast("Elemento C");
        // [Elemento A, Elemento B, Elemento C]
        System.out.println("LinkedList: " + linkedList);

        // 3. VECTOR: Thread-safe (Sincronizada)
        Vector<Integer> vector = new Vector<>();
        vector.add(10);
        vector.add(20);
        System.out.println("Vector: " + vector);

        // 4. STACK: LIFO (Last-In, First-Out)
        Stack<String> stack = new Stack<>();
        stack.push("Prato 1"); // Empilha
        stack.push("Prato 2");
        stack.push("Prato 3");
        
        System.out.println("Topo da Pilha: " + stack.peek()); // Olha o topo
        System.out.println("Removendo: " + stack.pop());    // Remove o topo (Prato 3)

        // 5. ITERAÇÃO (Graças à interface Iterable/Collection)
        System.out.println("\n--- Percorrendo o ArrayList ---");
        for (String linguagem : arrayList) {
            System.out.println("Linguagem: " + linguagem);
        }
    }
}
