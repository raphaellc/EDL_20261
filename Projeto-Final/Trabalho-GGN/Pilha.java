/*
GABRIEL PONZONI, GASPAR CAON, NOAH VARGAS

Última compilação do programa feita nas versões:

	javac 21.0.10

e executado na versão:

	openjdk version "21.0.10" 2026-01-20
	OpenJDK Runtime Environment (build 21.0.10+7-Ubuntu-124.04)
	OpenJDK 64-Bit Server VM (build 21.0.10+7-Ubuntu-124.04, mixed mode, sharing)
*/

/** Pilha de nós encadeados por ponteiros nas duas direções.
* Cada nó da pilha possui dois ponteiros: um para o nó próximo, um para o nó anterior.
* O nó "topo" é o nó no topo da pilha.
* Novos nós são inseridos sempre no topo da pilha. Ao remover um nó, o nó do topo é removido.
*/
public class Pilha<T> {

    private No<T> topo;
    private int tamanho;

	/** Construtor para Pilha vazia
 	*/
    public Pilha() {
        topo = null;
        tamanho = 0;
    }

    /** Construtor para Pilha com 1 nó informado
     * @param dado_informado objeto a ser contido no nó
    */
   public Pilha(No<T> topo_informado) {
        topo = topo_informado;
        tamanho = 1;
    }

    // GETTER-SETTER

    public No<T> getTopo() {
        if (pilhaVazia() == true) return null;
        return topo;
    }

    public int getTamanho() {
        return tamanho;
    }

    /** Insere um nó com um dado na Pilha.
    * @param dado
    */
    public void inserirPilha(T dado){

        // caso tamanho == 0
        if (pilhaVazia() == true) {
            topo = new No<T>(dado);
            tamanho++;
            return;
        }
        
        // caso tamanho > 0
        No<T> novoNo = new No<T>(dado, topo, null);
        topo.setProximo(novoNo);
        topo = novoNo;
        tamanho++;
        return;
    }

    public T removerPilha() {

        // caso tamanho == 0
        if (pilhaVazia() == true) {
            System.out.println("Pilha já está vazia. Retornando 'null'.");
            return null;
        }

        T valorAretornar;    // guarda dado a retornar antes de eliminar o nó

        // caso tamanho == 1
        if (tamanho == 1) {
            valorAretornar = topo.getDado();
            topo = null;
            tamanho--;
            return valorAretornar;
        }

        // caso Pilha com tamanho > 1
        valorAretornar = topo.getDado();
        topo = topo.getAnterior();
        topo.getProximo().setAnterior(null);
            /* A linha acima remove o ponteiro C <- D (o último nó apontando para o penúltimo nó).
            Embora em Java isto não seja obrigatório, reflete uma prática "manual" de desreferen-
            ciamento, que se aplicaria a linguagens como C/C++. Já, a linha a seguir remove o ponteiro
            C -> D, e tecnicamente isto é suficiente para o coletor de lixo do Java eleger o nó D
            para remoção na memória. Porém, eliminando-se os dois ponteiros C <-> D, o nó D fica
            completamente isolado, o que é didaticamente aceitável para este exercício.
            */
        topo.setProximo(null);
        tamanho--;
        return valorAretornar;
    }



    public boolean pilhaVazia() {
        return (tamanho <= 0);
    }

    public void mostraPilha() {
        if (pilhaVazia() == true) {
            System.out.println("Pilha está vazia. Nada para mostrar.");
            return;
        }

        No<T> noAuxiliar = topo;
        while (noAuxiliar.getAnterior() != null) {
            System.out.print(noAuxiliar + " ");
            noAuxiliar = noAuxiliar.getAnterior();
        }
        System.out.println(noAuxiliar); // mostra o dado da base da pilha
    }

}