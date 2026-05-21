/*
GABRIEL PONZONI, GASPAR CAON, NOAH VARGAS

Última compilação do programa feita nas versões:

	javac 21.0.10

e executado na versão:

	openjdk version "21.0.10" 2026-01-20
	OpenJDK Runtime Environment (build 21.0.10+7-Ubuntu-124.04)
	OpenJDK 64-Bit Server VM (build 21.0.10+7-Ubuntu-124.04, mixed mode, sharing)
*/

/** A única diferença entre a fila comum e a fila prioritária é que a fila prioritária
 * é o tipo de dado utilizado: o dado "Cliente", que é um nó especial. Um cliente possui
 * uma senha e um tempo de atendimento. Consulte a documentação de Fila e Cliente.
 * TALVEZ ESTA CLASSE SERÁ REMOVIDA POR NÃO SER NECESSÁRIA.
*/
public class FilaPrioritaria<T> {

    //public Fila<Cliente> filaPrioritaria = new Fila<Cliente>();
	private Fila<Cliente> filaPrioritaria = new Fila<Cliente>(); // sugestão da IA

	/** Este método não é um "override" do método de mesmo nome da classe Fila.java
	 * pois FilaPrioritaria.java não é uma subclasse de Fila.java, mas sim uma espe-
	 * cialização dela. Aqui, o método mostraFila() mostra na tela os dados de um
	 * modo mais compreensivo para o usuário do que na classe Fila.java.
	*/
	public void mostraFila() {
		No<Cliente> noAuxiliar = filaPrioritaria.getInicio(); // precisa de getter
        System.out.println("");
        while (noAuxiliar.getProximo() != null) {
            System.out.print(noAuxiliar + ", senha tipo " + noAuxiliar.senhaCliente);
            noAuxiliar = noAuxiliar.getProximo();
        }
        System.out.println(noAuxiliar); // mostra o dado do último nó
	}

}