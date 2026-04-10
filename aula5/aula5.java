import No.No;
import Lista.ListaEncadeada;

public class aula5 {
    public static void main(String[] args) {
        No<Integer> no = new No<Integer>(10);
        No<Integer> no2 = new No<Integer>(30);
        No<Integer> no3 = new No<Integer>(50);
        
        no.setProximo(no2);
        no2.setProximo(no3);
        
        No<Integer> no4 = new No<>(40,no);

        No<Integer> novoNo = no4.getProximo().getProximo().getProximo().getProximo(); 
        IO.println(novoNo != null ? novoNo.getDado() : "null");        
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        if(lista.remover(0)){
            System.out.println("Elemento removido com sucesso!");}
        else{
            System.out.println("Elemento não encontrado!");
        }
        lista.adicionar(10);
        lista.adicionar(20);
        lista.adicionar(30);
        lista.adicionar(40);
        lista.adicionar(50);
        lista.mostrarTodosElementos();
        lista.remover(3);
        lista.mostrarTodosElementos();
        lista.remover(0);
        lista.mostrarTodosElementos();
        if(lista.remover(6)){
            System.out.println("Elemento removido com sucesso!");}
        else{
            System.out.println("Elemento não encontrado!");
        }
        lista.mostrarTodosElementos();
    }
}
