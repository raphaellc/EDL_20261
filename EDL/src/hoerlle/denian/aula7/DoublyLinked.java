public class DoublyLinked<T> {
    private NodeD<T> head, last;
    private int size;

    // CONSTRUCTORS

    DoublyLinked() {
        this.size = 0;
    }

    DoublyLinked(T data) {
        this.head = new NodeD<T>(data);
        this.size = 1;
    }

    // PRIVATE METHODS

    private void addLast(NodeD<T> currentNode, T dado) {
        if (currentNode.getNext() == null) {
            currentNode.setNext(new NodeD<T>(dado, currentNode));
            size++;
        }
        else this.addLast(currentNode.getNext(), dado);
    }

    private void removeLast(NodeD<T> currentNode) {
        if (currentNode.getNext() == null) {
            currentNode.getPrevious().setNext(null);
            size--;
        }
        else this.removeLast(currentNode.getNext());
    }

    private void removeIndex(int targetIndex, int currentIndex, NodeD<T> currentNode) {
        if (targetIndex == currentIndex) {
            NodeD<T> currNext = currentNode.getNext();
            NodeD<T> currPrev = currentNode.getPrevious();

            if (currNext != null) currNext.setPrevious(currPrev);
            if (currPrev != null) currPrev.setNext(currNext);
        } else removeIndex(targetIndex, ++currentIndex, currentNode.getNext());
    }

    private void addInIndex(NodeD<T> newNode, int index, int currentIndex, NodeD<T>currentNode) {
        if (index == currentIndex) {

            NodeD<T> currPrev = currentNode.getPrevious();

            newNode.setNext(currentNode);
            currentNode.setPrevious(currentNode);

            if (currPrev != null) currPrev.setNext(newNode);
        } else addInIndex(newNode, index, ++currentIndex, currentNode.getNext());
    }

    // PUBLIC

    public void addLast(T dado) {
        if (head == null) {
            head = new NodeD<T>(dado);
            size++;
        }
        else this.addLast(head, dado);
    }

    public void removeLast() {
        if (head != null) this.removeLast(head.getNext());
    }

    public void addFirst(T dado) {
        NodeD<T> newNodeD = new NodeD<T>(dado);
        head.setPrevious(newNodeD);
        newNodeD.setNext(head);


        head = newNodeD;
        size++;
    }

    public void removeFirst() {
        if (head.getNext() != null) {
            head.getNext().setPrevious(null);
            head = head.getNext();
            size--;
        }
    }

    public void removeIndex(int index) {
        if (index == 0) removeFirst();

        else if (index < size) {
            removeIndex(index, 0, head);
            size--;
        }
    }

    public void addInIndex(T newData, int index) {
        if (index == 0) addFirst(newData);

        else if (index == size) addLast(newData);

        else if (index < size) {
            addInIndex(new NodeD<T>(newData), index, 0, head);
            size++;
        }
    }

    // TEST

    private void printAllNodes(NodeD<T> currentNode) {
        System.out.print(currentNode.getData());
        if (currentNode.getNext() != null) {
            System.out.print(", ");
            printAllNodes(currentNode.getNext());
        } else System.out.println();
    }

    public void test() {
        printAllNodes(head);
        System.out.println("Tamanho: " + size);
    }
}
