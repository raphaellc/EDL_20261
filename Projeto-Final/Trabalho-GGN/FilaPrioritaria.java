/*
GABRIEL PONZONI, GASPAR CAON, NOAH VARGAS

Última compilação do programa feita nas versões:

	javac 21.0.10

e executado na versão:

	openjdk version "21.0.10" 2026-01-20
	OpenJDK Runtime Environment (build 21.0.10+7-Ubuntu-124.04)
	OpenJDK 64-Bit Server VM (build 21.0.10+7-Ubuntu-124.04, mixed mode, sharing)
*/

/** A fila prioritária possui alguns métodos diferenciados em relação à classe básica Fila.java.
 * O tipo de dado utilizado é um objeto da classe "Cliente". Um cliente possui:
 * <li> uma senha (normal ou prioritária)
 * <li> um tempo de atendimento (em turnos)
 * <li> uma probabilidade de desistência
 * Consulte a documentação de Fila.java e Cliente.java.
*/
public class FilaPrioritaria<T> {

    //public Fila<Cliente> filaPrioritaria = new Fila<Cliente>();
	private Fila<Cliente> fila = new Fila<Cliente>(); // sugestão da IA

	// GETTER
	public Fila<Cliente> getFila() {return fila;}

	/** Este método não é um "override" do método de mesmo nome da classe Fila.java
	 * pois FilaPrioritaria.java não é uma subclasse de Fila.java, mas sim uma especialização
	 * dela. Aqui, o método mostraFila() mostra na tela os dados de um
	 * modo mais compreensivo para o usuário do que na classe Fila.java.
	*/
	public void mostraFilaPrioritaria() {
		No<Cliente> noAuxiliar = fila.getInicio(); // precisa de getter
        System.out.println("");
        while (noAuxiliar.getProximo() != null) {
			System.out.print(mostraClienteCompleto(noAuxiliar.getDado()));
            noAuxiliar = noAuxiliar.getProximo();
        }
		System.out.print(mostraClienteCompleto(noAuxiliar.getDado())); // mostra o dado do último nó
	}

	/** Remove um nó da fila através do número de sua senha. Este método é baseado no método removerFila()
	 * da classe básica Fila.java, mas difere no ponto de que permite remover um nó do meio da fila.
	 */
	public Cliente removerFilaPrioritaria(int numeroSenha) {
		// caso tamanho == 0
        if (fila.filaVazia() == true) {
            System.out.println("Fila já está vazia. Retornando 'null'.");
            return null;
        }

		Cliente clienteAretornar;

		// caso tamanho == 1
		if (fila.getTamanho() == 1) {
			clienteAretornar = ;
			fila.setInicio(null);
			fila.setFim(null);
			fila.setTamanho(fila.getTamanho()-1);					
		}
		
        // caso tamanho > 0
		No<Cliente> noAuxiliar = fila.getInicio();

		while (noAuxiliar != null) {

			Cliente clienteAtual = noAuxiliar.getDado();	// apontando para o primeiro cliente da fila

			// compara o número da senha informado com o número da senha dos clientes na fila
			if (numeroSenha == clienteAtual.getSenha().getNumero()) {

			

				// caso primeiro da fila
				else if (noAuxiliar == fila.getInicio()) {
					fila.setInicio(noAuxiliar.getProximo())

				}
				


				// atualiza ponteiros fazendo a remoção manual de todos os ponteiros envolvidos na operação...
				// ...mas verifica antes se o cliente não é o último da fila; se for, o tratamento é diferente.

				// caso último da fila
				if (noAuxiliar.getProximo().getProximo() == null) {
					// noAuxiliar = C. Remover o nó D:
					// ... <-> C <-> D -> null
					noAuxiliar.getProximo().setAnterior(null);  // remove C <- D
					noAuxiliar.setProximo(null);                // remove C -> D
				} else {
					// caso nó qualquer no meio da fila
					// noAuxiliar = A. Remover o nó B de
					// ... <-> A <-> B <-> C <-> ...
					noAuxiliar.setProximo(noAuxiliar.getProximo().getProximo()); //   cria A -> C
					noAuxiliar.getProximo().getAnterior().setProximo(null);      // remove B -> C					
					noAuxiliar.getProximo().getAnterior().setAnterior(null);     // remove A <- B
					noAuxiliar.getProximo().setAnterior(noAuxiliar);             //   cria A <- C
				}
				fila.setTamanho(fila.getTamanho()-1);
				return clienteAretornar;
			}
			noAuxiliar = noAuxiliar.getProximo();
		}
		// não localizou a senha
		System.out.println("ATENÇÃO: senha nº" + numeroSenha + " não localizada. Retornando nulo.");
		return null;
	}

	public String mostraClienteCompleto(Cliente clienteInformado) {
		return "\n" + clienteInformado
		            + ", "
					+ clienteInformado.getSenha();
	}

}