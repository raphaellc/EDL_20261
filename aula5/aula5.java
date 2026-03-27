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
    }
}
