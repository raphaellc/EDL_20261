package Aula06;

public class DoublyLinkedList<T> {
    private Node<T> head;
    private int size;

    public DoublyLinkedList() {
        this.size = 0;
    }

    public void addFirst(T data) {
        if(head == null) {
            head = new Node<>(data);
        } else {
            Node<T> temp = new Node<>(data);
            temp.setNext(head);
            head.setPrev(temp);
            head = temp;
        }

        size++;
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
            Node<T> last = findLast(head);
            last.setNext(new Node<>(data));
            last.getNext().setPrev(last);
        }

        size++;
    }

    public void removeFirst() {
        if(head != null) {
            head = head.getNext();
            head.setPrev(null);
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
