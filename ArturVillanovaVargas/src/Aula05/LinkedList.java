package Aula05;

public class LinkedList<T> {
    private Node<T> head;
    private int size;

    public LinkedList() {
        this.size = 0;
    }

    private Node<T> findLast(Node<T> curr) {
        if(curr.getNext() != null)
            return findLast(curr.getNext());

        return curr;
    }

    public void addLast(T data) {
        if(head == null) {
            head = new Node<>(data);
        } else {
            Node<T> lastNode = findLast(head);
            lastNode.setNext(new Node<>(data));
        }

        size++;
    }

    public void addFirst(T data) {
        if(head == null) {
            head = new Node<>(data);
        } else {
            var temp = new Node<>(data);
            temp.setNext(head);
            head = temp;
        }

        size++;
    }

    public void removeFirst() {
        if(head != null && head.getNext() != null) {
            head = head.getNext();
            size--;
        }
    }

    private Node<T> findNextToLast(Node<T> curr) {
        if(curr.getNext().getNext() != null)
            return findNextToLast(curr.getNext());

        return curr;
    }

    public void removeLast() {
        if(head != null && head.getNext() != null) {
            Node<T> nextToLast = findNextToLast(head);
            nextToLast.setNext(null);

            size--;
        }
    }

    private Node<T> removeByIndex(Node<T> curr, int index, int currIndex) {
        if(index == 1)
            removeFirst();

        if(index == this.size)
            removeLast();

        if((currIndex + 1) == index) {;
            curr.setNext(curr.getNext().getNext());
            size--;
            return curr;
        }

        return removeByIndex(curr.getNext(), index, currIndex + 1);
    }

    /**
     * Remove o Nó do indice passado por parametro.
     * @param index Index do valor que deve ser deletado, começando de 1 até this.size
     * @return Void
     */
    public void removeByIndex(int index) {
        removeByIndex(head, index, 1);
    }

    private Node<T> print(Node<T> curr) {
        if(curr.getNext() != null) {
            System.out.print(curr.getData() + (curr.getNext() != null ? "," : ""));
            return print(curr.getNext());
        }

        System.out.println(curr.getData());
        return curr;
    }

    public void print() {
        if(head != null)
            print(head);
    }

    public int size() {
        return size;
    }
}
