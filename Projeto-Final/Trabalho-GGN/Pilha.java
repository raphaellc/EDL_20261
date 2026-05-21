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
* O nó "início" é o nó mais em baixo da pilha. O nó "fim" é o nó mais no topo da pilha.
* Novos nós são inseridos sempre ao fim da pilha. Ao remover um nó, o nó "fim" é removido.
*/
public class Pilha<T> {

    private No<T> inicio;
    private No<T> fim;
    private int tamanho;

	/** Construtor para Pilha vazia
 	*/
    public Pilha() {
        inicio = null;
        fim = null;
        tamanho = 0;
    }

    /** Construtor para Pilha com 1 nó informado
     * @param dado_informado objeto a ser contido no nó
    */
   public Pilha(No<T> inicio_informado) {
        inicio = inicio_informado;
        fim = inicio_informado;
        tamanho = 1;
    }

    /** Insere um nó com um dado na Pilha.
    * @param dado
    */
    public void inserirPilha(T dado){

        // caso tamanho == 0
        if (pilhaVazia() == true) {
            inicio = new No<T>(dado);
            fim = inicio;
            tamanho++;
            return;
        }
        
        // caso tamanho > 0
        No<T> novoNo = new No<T>(dado, fim, null);
        fim.setProximo(novoNo);
        fim = novoNo;
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
            valorAretornar = fim.getDado();
            inicio = null;
            fim = null;
            tamanho--;
            return valorAretornar;
        }

        // caso Pilha com tamanho > 1
        valorAretornar = fim.getDado();
        fim = fim.getAnterior();
        fim.getProximo().setAnterior(null);
            /* A linha acima remove o ponteiro C <- D (o último nó apontando para o penúltimo nó).
            Embora em Java isto não seja obrigatório, reflete uma prática "manual" de desreferen-
            ciamento, que se aplicaria a linguagens como C/C++. Já, a linha a seguir remove o ponteiro
            C -> D, e tecnicamente isto é suficiente para o coletor de lixo do Java eleger o nó D
            para remoção na memória. Porém, eliminando-se os dois ponteiros C <-> D, o nó D fica
            completamente isolado, o que é didaticamente aceitável para este exercício.
            */
        fim.setProximo(null);
        tamanho--;
        return valorAretornar;
    }

    public T fimPilha() {
        if (pilhaVazia() == true) return null;
        return fim.getDado();
    }

    public T inicioPilha() {
        if (pilhaVazia() == true) return null;
        return inicio.getDado();
    }

    public int tamanhoPilha() {
        return tamanho;
    }

    public boolean pilhaVazia() {
        return (tamanho <= 0);
    }

    public void mostraPilha() {
        No<T> noAuxiliar = inicio;
        while (noAuxiliar.getProximo() != null) {
            System.out.println(noAuxiliar);
            noAuxiliar = noAuxiliar.getProximo();
        }
        System.out.println(noAuxiliar); // mostra o dado do último nó
    }

}