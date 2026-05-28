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
		if (fila.filaVazia() == true) {
	        System.out.println("Fila está vazia. Nada para mostrar.");
            return;
        }

		No<Cliente> noAuxiliar = fila.getInicio();
        System.out.println("");
        while (noAuxiliar.getProximo() != null) {
			System.out.print(mostraClienteCompleto(noAuxiliar.getDado()));
			//System.out.println("\tCliente proximo = " + noAuxiliar.getProximo());
            noAuxiliar = noAuxiliar.getProximo();
        }
		System.out.print(mostraClienteCompleto(noAuxiliar.getDado())); // mostra o dado do último nó
		//System.out.println("\tCliente anterior ao ultimo = " + noAuxiliar.getAnterior());
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
		
        // caso tamanho > 0; percorrer fila
		No<Cliente> noAuxiliar = fila.getInicio();
		
		while (noAuxiliar != null) {

			//System.out.println("tamanho da fila=" + fila.getTamanho());

			// compara o número da senha informado com o número da senha dos clientes na fila
			if (numeroSenha == noAuxiliar.getDado().getSenha().getNumero()) {

				// caso tamanho == 1
				// noAuxiliar = A. Remover o nó A:
				// null <- A -> null 
				if (fila.getTamanho() == 1) {
					clienteAretornar = noAuxiliar.getDado();
					fila.setInicio(null);
					fila.setFim(null);
					fila.setTamanho(fila.getTamanho()-1);
				} 		

				// caso primeiro da fila
				// noAuxiliar = A. Remover o nó A:
				// A <-> B <-> ...
				else if (noAuxiliar.equals(fila.getInicio())) {   // TALVEZ PRECISE USAR .EQUALS()
					clienteAretornar = noAuxiliar.getDado();
					fila.setInicio(noAuxiliar.getProximo());		 // inicio agora é o segundo nó
					fila.getInicio().getAnterior().setProximo(null); // remove A -> B
					fila.getInicio().setAnterior(null);              // remove A <- B
				}

				// caso último da fila
				// noAuxiliar = D. Remover o nó D:
				// ... <-> C <-> D -> null
				else if (noAuxiliar.getProximo() == null) {
					clienteAretornar = noAuxiliar.getDado();
					fila.setFim(noAuxiliar.getAnterior());      // fim = C
					fila.getFim().setProximo(null);	            // remove C -> D
					//noAuxiliar.getAnterior().setProximo(null);  // remove C -> D
					noAuxiliar.setAnterior(null);               // remove C <- D
					
				// caso nó qualquer no meio da fila
				// noAuxiliar = B. Remover o nó B de
				// ... <-> A <-> B <-> C <-> ...
				} else {
					clienteAretornar = noAuxiliar.getDado();
					noAuxiliar.getAnterior().setProximo(noAuxiliar.getProximo());                 // cria   A -> C (removeu A -> B)
					noAuxiliar.setProximo(null);                                                  // remove B -> C
					noAuxiliar.getAnterior().getProximo().setAnterior(noAuxiliar.getAnterior());  // cria   A <- C (removeu B <- C)
					noAuxiliar.setAnterior(null);                                                 // remove A <- B

					/*
					noAuxiliar.setProximo(noAuxiliar.getProximo().getProximo()); //   cria A -> C
					noAuxiliar.getProximo().getAnterior().setProximo(null);      // remove B -> C					
					noAuxiliar.getProximo().getAnterior().setAnterior(null);     // remove A <- B
					noAuxiliar.getProximo().setAnterior(noAuxiliar);             //   cria A <- C
					 */
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