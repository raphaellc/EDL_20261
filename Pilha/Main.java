import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        try {
            Pilha<String> pilha_livros = new Pilha<>();
            pilha_livros.empilhar("O Hobbit");
            System.out.println("Testando desempilhar não vazio");
            if("O Hobbit".equals(pilha_livros.desempilhar())){
                System.out.println("Testando desempilhar - Passou");
            }else{
                System.out.println("Testando desempilhar - Falhou");
            }
            
            System.out.println("Testando desempilhar vazio");
            if(pilha_livros.desempilhar() == null){
                System.out.println("Testando desempilhar vazia - Passou");
            }else{
                System.out.println("Testando desempilhar vazia- Falhou");
            }

            IO.println("Testando tamanho zerado");

            IO.println("pegando tamanho: " + pilha_livros.getTamanho());

            IO.println("Adicionando A Odisseia");

            pilha_livros.empilhar("A Odisseia");

            

            IO.println("pegando topo: " + pilha_livros.getTopo());

            IO.println("Testando tamanho 1");

            IO.println("pegando tamanho: " + pilha_livros.getTamanho());

            IO.println("Adicionando A Mosca");

            pilha_livros.empilhar("A Mosca");

            IO.println("pegando topo: " + pilha_livros.getTopo());

            IO.println("Testando tamanho 2");

            IO.println("pegando tamanho: " + pilha_livros.getTamanho());

            IO.println("Removendo Topo A Mosca");

            pilha_livros.listaPilha();


            pilha_livros.desempilhar();

            IO.println("Testando novo topo e novo tamanho apos remover");

            IO.println("pegando topo: " + pilha_livros.getTopo());

            IO.println("pegando tamanho: " + pilha_livros.getTamanho());
            
        } catch(RuntimeException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Continua após exceção");
        }
    }
}
