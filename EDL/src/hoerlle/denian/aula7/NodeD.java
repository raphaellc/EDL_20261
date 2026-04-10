public class NodeD<T> {
    private T data;
    private NodeD<T> next, prev;

    NodeD(T data) {
        this.data = data;
    }

    NodeD(T data, NodeD<T> prev) {
        this.data = data;
        this.prev = prev;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public NodeD<T> getNext() {
        return next;
    }

    public void setNext(NodeD<T> next) {
        this.next = next;
    }

    public NodeD<T> getPrevious() { return prev; }

    public void setPrevious(NodeD<T> prev) { this.prev = prev; }
}
