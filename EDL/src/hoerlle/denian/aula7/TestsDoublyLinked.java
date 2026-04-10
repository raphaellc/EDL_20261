public class TestsDoublyLinked {
    static void main() {
        DoublyLinked<Integer> myList = new DoublyLinked<Integer>();

        System.out.println("====/ ADICIONA ULTIMO \\====");
        myList.addLast(1);
        myList.addLast(2);
        myList.addLast(3);
        myList.addLast(4);
        myList.test();

        System.out.println("====/ REMOVE ULTIMO \\====");
        myList.removeLast();
        myList.test();

        System.out.println("====/ ADICIONA PRIMEIRO \\====");
        myList.addFirst(20);
        myList.test();

        System.out.println("====/ REMOVER PRIMEIRO \\====");
        myList.removeFirst();
        myList.test();

        System.out.println("====/ REMOVER INDEX \\====");
        myList.removeIndex(2);
        myList.test();

        System.out.println("====/ ADICIONA INDEX \\====");
        myList.addInIndex(100, 0);
        myList.test();

    }
}
