package Aula05;

public class Main {
    static void main() {
        LinkedList<Integer> ll = new LinkedList<>();

        ll.addLast(1);
        ll.addLast(3);
        ll.addLast(5);
        ll.addLast(7);
        ll.addLast(6);

        ll.removeByIndex(4);

        ll.print();
    }
}
