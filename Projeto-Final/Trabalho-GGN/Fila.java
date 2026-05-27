/*
GABRIEL PONZONI, GASPAR CAON, NOAH VARGAS

Última compilação do programa feita nas versões:

	javac 21.0.10

e executado na versão:

	openjdk version "21.0.10" 2026-01-20
	OpenJDK Runtime Environment (build 21.0.10+7-Ubuntu-124.04)
	OpenJDK 64-Bit Server VM (build 21.0.10+7-Ubuntu-124.04, mixed mode, sharing)
*/

/** Fila de nós encadeados por ponteiros nas duas direções.
* Cada nó da fila possui dois ponteiros: um para o nó próximo, um para o nó anterior.
* O nó "início" é o nó da frente da fila. O próximo é o segundo da fila etc.
* Novos nós são inseridos no fim da fila. Ao remover um nó, o nó "inicio" é removido.
*/
public class Fila<T> {

    private No<T> inicio;
    private No<T> fim;
    private int tamanho;

	/** Construtor para fila vazia
 	*/
    public Fila() {
        inicio = null;
        fim = null;
        tamanho = 0;
    }

    /** Construtor para fila com 1 nó informado
     * @param dado_informado objeto a ser contido no nó
    */
   public Fila(No<T> inicio_informado) {
        inicio = inicio_informado;
        fim = inicio_informado;
        tamanho = 1;
    }

    // GETTER-SETTER
    public No<T> getInicio() {return inicio;}
    public void setInicio(No<T> inicioInformado) {inicio = inicioInformado;}
    public No<T> getFim() {return fim;}
    public void setFim(No<T> fimInformado) {fim = fimInformado;}
    public int getTamanho() {return tamanho;}
    public void setTamanho(int tamanhoInformado) {tamanho = tamanhoInformado;}

    /** Insere um nó com um dado na fila.
    * @param dado
    */
    public void inserirFila(T dado){

        // caso tamanho == 0
        if (filaVazia() == true) {
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

    public T removerFila() {

        // caso tamanho == 0
        if (filaVazia() == true) {
            System.out.println("Fila já está vazia. Retornando 'null'.");
            return null;
        }

        T valorAretornar;    // guarda dado a retornar antes de eliminar o nó

        // caso tamanho == 1
        if (tamanho == 1) {
            valorAretornar = inicio.getDado();
            inicio = null;
            fim = null;
            tamanho--;
            return valorAretornar;
        }

        // caso tamanho > 1
        valorAretornar = inicio.getDado();
        inicio = inicio.getProximo();
        inicio.getAnterior().setProximo(null);
            /* A linha acima remove o ponteiro A -> B (o primeiro nó apontando para o segundo nó).
            Embora em Java isto não seja obrigatório, reflete uma prática "manual" de desreferen-
            ciamento, que se aplicaria a linguagens como C/C++. Já, a linha a seguir remove o ponteiro
            A <- B, e tecnicamente isto é suficiente para o coletor de lixo do Java eleger o nó A
            para remoção na memória. Porém, eliminando-se os dois ponteiros A <-> B, o nó A fica
            completamente isolado, o que é didaticamente aceitável para este exercício.
            */
        inicio.setAnterior(null);
        tamanho--;
        return valorAretornar;
    }

    public T frenteFila() {
        if (filaVazia() == true) return null;
        return inicio.getDado();
    }

    public T fimFila() {
        if (filaVazia() == true) return null;
        return fim.getDado();
    }

    public boolean filaVazia() {
        return (tamanho <= 0);
    }

    public void mostraFila() {
        if (filaVazia() == true) {
            System.out.println("Fila está vazia. Nada para mostrar.");
            return;
        }
        
        No<T> noAuxiliar = inicio;
        System.out.println("");
        while (noAuxiliar.getProximo() != null) {
            System.out.print(noAuxiliar + " < ");
            noAuxiliar = noAuxiliar.getProximo();
        }
        System.out.println(noAuxiliar); // mostra o dado do último nó
    }
}