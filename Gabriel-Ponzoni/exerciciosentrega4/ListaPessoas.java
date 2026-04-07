package exerciciosentrega4;

public class ListaPessoas {
    private LinkedList<Pessoa> lista = new LinkedList<>();

    public void inserir(Pessoa p){
        lista.addLast(p);
    }

    public void remover(String nome){
        if (this.lista.getHead() == null) {
            return;
        } else if (this.lista.getHead().getData().getNome().equalsIgnoreCase(nome)) {
            Node<Pessoa> temp = this.lista.getHead().getNext();
            this.lista.setHead(temp); 
            this.lista.setSize(this.lista.getSize() - 1);
        } else {
            Node<Pessoa> temp = this.lista.getHead();
            Node<Pessoa> anterior = null;
            while (temp != null && !temp.getData().getNome().equalsIgnoreCase(nome)) {
                anterior = temp;
                temp = temp.getNext();                
            }
            if (temp != null) {
                anterior.setNext(temp.getNext());
                temp.setNext(null);
                this.lista.setSize(this.lista.getSize() - 1);             
            } else {
                IO.println("Dados n encontrados na lista!");
            }
        }
    }

    public Pessoa buscar(String nome){
        Node<Pessoa> temp = lista.getHead();
        while (temp != null) {
            if (temp.getData().getNome().equalsIgnoreCase(nome)) {
                return temp.getData();
            }
            temp = temp.getNext();
        }
        return null;
    }

    public void percorrer(){
        lista.showAll();
    }
}
