package exerciciosentrega4;

public class LinkedList<T> {
    private Node<T> head;
    private int size;

    // Construtores 
    public LinkedList(){
        this.head = null;
        this.size = 0;
    }

    public LinkedList(Node<T> head, int size){
        this.head = head;
        this.size = size;
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }
    
    public void setSize(int size) {
        this.size = size;
    }

    public void addFirst(T data){
        Node<T> novo = new Node<T>(data);
        novo.setNext(this.head);
        this.head = novo;

        this.size++; // N ESQUECER DE AUMENTAR O TAMANHO DA LISTA
    }
    
    public void addLast(T data){
        Node<T> novo = new Node<T>(data);
        if (this.head == null) {
            this.head = novo;
        } else {
            Node<T> temp = this.head;

            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(novo);
        }
        this.size++;
    }

    public void addBeforeNode(T data, Node<T> givenNode){
        Node<T> novo = new Node<T>(data);
        if (this.head == givenNode){
            novo.setNext(givenNode); // boa pratica é definir o proximo do novo no antes do anterior
            this.head = novo;

        } else {
            Node<T> temp = this.head;
            while (temp != null && temp.getNext() != givenNode) {
                temp = temp.getNext();
            }
            if (temp != null) {
                novo.setNext(givenNode); // boa pratica é definir o proximo antes do anterior 
                temp.setNext(novo);
            } else {
                IO.println("Nó não encontrado!");
                return;
            }
        }
        this.size++;
    }

    public void addAfterNode(T data, Node<T> givenNode){
        Node<T> novo = new Node<T>(data);
        novo.setNext(givenNode.getNext());
        givenNode.setNext(novo);

        this.size++;
    } 

    public void addAtPosition(T data, int position){
        if (position < 0 || position > this.size) {
            IO.println("Posição inválida!");
            return;
        } else if (position == 0){
            addFirst(data);
        } else {
            Node<T> novo = new Node<T>(data);
            Node<T> temp = this.head;
            int contador = 0;

            while (contador != position - 1) {
                temp = temp.getNext();
                contador++;
            }
            novo.setNext(temp.getNext());
            temp.setNext(novo);
            this.size++;
        }
    }

    public void removeFirst(){
        if (this.head == null){
            IO.println("Lista vazia!");
            return;
        }
        this.head = this.head.getNext();
        this.size--;
    }

    public void removeLast(){
        if (this.head == null){
            IO.println("Lista vazia!");
            return;
        } else if (this.head.getNext() == null){
            this.head = null;
        } else {
            Node<T> temp = this.head;
            Node<T> anterior = null;
            while (temp.getNext() != null) {
                anterior = temp;
                temp = temp.getNext();
            }
            anterior.setNext(null);
        }
        this.size--;
    }

    public void removeAtPosition(int position){
        if (position < 0 || position >= this.size) {
            IO.println("Posição inválida!");
            return;
        } else if (position == 0){
            removeFirst();
        } else {
            Node<T> temp = this.head;
            Node<T> anterior = null;
            int contador = 0;

            while (contador != position - 1) {
                anterior = temp;
                temp = temp.getNext();
                contador++;
            }
            anterior.setNext(temp.getNext());
            this.size--;
        }
    }

    public void showAll(){
        if (this.head == null){
            IO.println("Lista vazia!");
            return;
        }
        Node<T> temp = this.head;
        int contador = 0;
        while (temp != null) {
            IO.println(temp.getData());
            if (contador == this.size - 1) {
                IO.print(" -> null");
            } else {
                IO.print(" -> ");
            }
            temp = temp.getNext();
            contador++;
        }
        IO.println(" Fim da Lista");
    }

    public void update(T data, int position){
        if (position < 0 || position >= this.size) {
            IO.println("Posição inválida!");
            return;
        } else {
            Node<T> temp = this.head;
            int contador = 0;

            while (contador != position) {
                temp = temp.getNext();
                contador++;
            }
            temp.setData(data);
        }
    }

    public Node<T> searchNode(T data){
        Node<T> temp = this.head;
        while (temp != null) {
            if (temp.getData().equals(data)) {
                return temp;
            }
            temp = temp.getNext();
        }
        return null; 
    }

    public Node<T> searchNodeByPosition(int position){
        if (position < 0 || position >= this.size) {
            IO.println("Posição inválida!");
            return null;
        } else {
            Node<T> temp = this.head;
            int contador = 0;

            while (contador != position) {
                temp = temp.getNext();
                contador++;
            }
            return temp;
        }
    }
}
