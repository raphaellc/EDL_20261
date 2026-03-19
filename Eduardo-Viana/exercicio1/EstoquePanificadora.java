import java.util.ArrayList;

public class EstoquePanificadora {
    public static void main(String[] args) {

        ArrayList<String> produtos = new ArrayList<>();

        produtos.add("Pão Francês");
        produtos.add("Bolo de Cenoura");
        produtos.add("Pão de Queijo");
        produtos.add("Sonho");
        produtos.add("Bolo de Cenoura");

        produtos.add("Croissant");
        produtos.add(0, "Pão Doce");

        produtos.remove(produtos.lastIndexOf("Sonho"));

        System.out.println(produtos);
    }
}