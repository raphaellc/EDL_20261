package exerciciosentrega4;

public class Node<T> {
    private T data;
    private Node<T> next;

    // cosntrutores para caso informamaos apenas o dado e para caso informamaos o dado e o proximo node
    public Node(T data){
        this.data = data;
        this.next = null;
    }

    public Node(T data, Node<T> next){
        this.data = data;
        this.next = next;
    }

    //getters e setters 
    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
