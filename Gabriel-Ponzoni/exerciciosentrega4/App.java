package exerciciosentrega4;

public class App {
    public static void main(String[] args){
        // Node<Integer> no = new Node<Integer>(10);
        // Node<Integer> no2 = new Node<Integer>(15);
        // Node<Integer> no3 = new Node<Integer>(20);
        // Node<Integer> no4 = new Node<Integer>(25);

        // no.setNext(no2);
        // no2.setNext(no3);
        // no3.setNext(no4);

        // Node<Integer> algumNo = no.getNext().getNext().getNext();
        // IO.println(algumNo.getData());

        ListaPessoas lista = new ListaPessoas();
        
        lista.inserir(new Pessoa("Alice", 30));
        lista.inserir(new Pessoa("Bob", 25));
        lista.inserir(new Pessoa("Carlos", 40));  

        IO.println("--- Lista Completa ---");
        lista.percorrer();

        IO.println("\n>>> Removendo Bob...");
        lista.remover("Bob");  

        IO.println("--- Lista Após Remoção ---");
        lista.percorrer();

        IO.println("\n>>> Buscando Alice:");
        IO.println(lista.buscar("Alice"));  

        IO.println("/////////////////////////");
        IO.println("//     ArrayList       //");
        IO.println("/////////////////////////");

        ListaPessoasArray listaArray = new ListaPessoasArray();

        listaArray.inserir(new Pessoa("Alice", 30));
        listaArray.inserir(new Pessoa("Bob", 25));
        listaArray.inserir(new Pessoa("Carlos", 40));  

        IO.println("--- Lista Completa ---");
        listaArray.percorrer();

        IO.println("\n>>> Removendo Bob...");
        listaArray.remover("Bob");  

        IO.println("--- Lista Após Remoção ---");
        listaArray.percorrer();

        IO.println("\n>>> Buscando Alice:");
        IO.println(listaArray.buscar("Alice"));  
    }
}
