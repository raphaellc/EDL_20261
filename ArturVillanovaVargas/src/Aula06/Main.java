package Aula06;

public class Main {
    static void main() {
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();

        dll.addFirst(1);
        dll.addFirst(3);
        dll.addFirst(4);

        dll.removeFirst();

        dll.print();
    }
}
