package Aula05;

import java.util.List;

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
        if(head != null) {
            head = head.getNext();
        }

        size--;
    }

    private Node<T> print(Node<T> curr) {
        if(curr.getNext() != null) {
            System.out.println(curr.getData());
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
