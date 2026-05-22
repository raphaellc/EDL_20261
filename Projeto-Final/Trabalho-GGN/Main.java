/*
GABRIEL PONZONI, GASPAR CAON, NOAH VARGAS

Última compilação do programa feita nas versões:

	javac 21.0.10

e executado na versão:

	openjdk version "21.0.10" 2026-01-20
	OpenJDK Runtime Environment (build 21.0.10+7-Ubuntu-124.04)
	OpenJDK 64-Bit Server VM (build 21.0.10+7-Ubuntu-124.04, mixed mode, sharing)
*/

/** TODO pensar em outras distribuições de probabilidade
 */

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    Scanner inputUsuario = new Scanner(System.in);

    int turno = 0; 

    static final int QUANTIDADE_POSTOS_ATENDIMENTO = 5;
    int quantidadeMinimadePostosFuncionando = 3;
    Posto postosDeAtendimento[] = new Posto[QUANTIDADE_POSTOS_ATENDIMENTO];

    //Fila<Cliente> filaUnica = new Fila<>(); // A debater se usaremos a classe Fila.java ou FilaPrioritaria.java
    FilaPrioritaria<Cliente> filaUnica = new FilaPrioritaria<>();

    int NumeradorDeSenhas = (int)(50*Math.random()); // inicia a numeração de senhas em um número aleatório inicial
    Pilha<Senha> pilhaSenhasChamadas = new Pilha<>();
    
    public static void main(String[] args) {
        
        Main BancoPraxedes = new Main();
        
        BancoPraxedes.inicializa();
        BancoPraxedes.lacoSimulador();

        System.out.println("\nVocê saiu do simulador de fila de banco Praxedes.");
    }

    public void inicializa() {
        // Cria postos de atendimento do Banco Praxedes
        for (int i=0; i < QUANTIDADE_POSTOS_ATENDIMENTO; i++) {
            postosDeAtendimento[i] = new Posto(i+1, false, false, null);
        }

        // Abre alguns postos
        for (int i=0; i < quantidadeMinimadePostosFuncionando; i++) {
            abrePosto(i);
        }

        // Gera alguns clientes e encadeia-os da fila. Senha aleatória e tempo de atendimento aleatório.
        for (int i=0; i<20; i++) {
            Cliente novoCliente = new Cliente("Cliente " + i, geraSenha(), (int)(Math.random()* (5 - 1)) + 1);
            filaUnica.getFila().inserirFila(novoCliente);
        }
    }
    
    public void lacoSimulador() {

        while(true) {
            turno++;
            System.out.println("Turno atual: " + turno);

            decideDesistenciaClientes();
           // decideChegaNovoClienteNaFila()

            processaAtendimentoPostos();

           // metodo chamar clientes n pode funcionar no primeiro turno, para motivos de melhro visualizacao
            if (turno > 1) { 
                chamarClientesParaPostosLivres();
            } else {
                System.out.println(">> AVISO: Primeiro turno. Os postos aguardarão o próximo turno para iniciar os atendimentos.");
            }

            mostraPostos();
            filaUnica.mostraFilaPrioritaria();

            System.out.println("\n(Enter para o próximo turno; 0 para sair)");
            String x = inputUsuario.nextLine();
            if ("0".equals(x) == true) return;
        }
    }

    /** Retorna 'true' ou 'falso' com aproximadamente 50% de chance cada.
     * @return boolean
     */
    public boolean caraOuCoroa() {
        return (int)(2*Math.random()) == 0;      
    }

    public Senha geraSenha() {
        return new Senha(caraOuCoroa(), ++NumeradorDeSenhas);
    }

    public void mostraPostos() {
        for (int i=0; i < QUANTIDADE_POSTOS_ATENDIMENTO; i++) {
            System.out.println(postosDeAtendimento[i]);
        }
    }

    public void abrePosto(int numeroPostoInformado) {
        postosDeAtendimento[numeroPostoInformado].setEmFuncionamento(true);
    }

    public void fechaPosto() {}

    /** Sorteia se um novo cliente vai aparecer na fila segundo uma distribuição de probabilidade. */
    public boolean sorteiaNovoClienteNaFila() {
        return caraOuCoroa();
    }

    /** Sorteia se um cliente na fila desistirá. O cliente possui uma pequena probabilidade de
     * desistir de esperar. O valor padrão é 10% de chance. Consulte a classe <b>Cliente.java</b>.
     */
    public boolean sorteiaDesistencia(Cliente clientePodendoDesistir) {
        double x = Math.random();
        if ((0 <= x) && (x < clientePodendoDesistir.getProbabilidadeDesistencia())) {
            return true;
        } else {
            return false;
        }
    }

    /** Método que decide se um cliente sai ou não da fila, baseado na sua probabilidade de desistência.
     * Quando um cliente decide sair da fila, o nó que o contém não é removido imediatamente.
     * Antes, é preciso guardar uma referência a esse cliente em um ArrayList. Após percorrer toda a fila
     * e avaliar todos os clientes desistentes (pois pode haver mais de um em um dado turno), os clientes
     * elencados para sair são removidos da fila através do método auxiliar <b>removeClientesDesistentes()</b>.
     * Esta remoção em dois passos é prudente pois evita acoplar a travessia da fila com remoção de nós da mesma fila.
     */
    public void decideDesistenciaClientes() {

        ArrayList<Cliente> listaClientesDesistentes = new ArrayList<>();
        No<Cliente> noAuxiliar = filaUnica.getFila().getInicio();

        while (noAuxiliar != null) {
            Cliente clienteAuxiliar = noAuxiliar.getDado();

            if (sorteiaDesistencia(clienteAuxiliar) == true) {
                
                listaClientesDesistentes.addLast(clienteAuxiliar);
                System.out.println(clienteAuxiliar + " desistiu de esperar.");
            }
            noAuxiliar = noAuxiliar.getProximo();
        }
        System.out.println("Lista de clientes desistentes = " + listaClientesDesistentes);
        removeClientesDesistentes(listaClientesDesistentes);
    }

    /** Este método usa uma expressão lambda para percorrer todos os clientes de uma ArrayList,
     * executando a operação de remoção da classe FilaPrioritaria.java.
     * @param lista
     */
    public void removeClientesDesistentes(ArrayList<Cliente> lista) {
        lista.forEach((Cliente c) -> {
            filaUnica.removerFilaPrioritaria(c.getSenha().getNumero());
            }
        ); 
    }

    /** Varre os postos de atendimento procurando postos abertos e livres.
     * Se encontrar, remove o próximo cliente da frente da fila e o aloca no posto.
     * A senha do cliente também é empilhada no histórico de senhas chamadas.
     */
    public void chamarClientesParaPostosLivres() {
        
        if (filaUnica.getFila().filaVazia() == true) {
            System.out.println(">> AVISO: A fila está vazia. Nenhum cliente para chamar.");
            return; // Sai do método pois não há ninguém para chamar
        }

        for (int i = 0; i < QUANTIDADE_POSTOS_ATENDIMENTO; i++) {
            if (postosDeAtendimento[i].getEmFuncionamento() == true && 
                postosDeAtendimento[i].getAtendendoCliente() == false) {
                
                if (filaUnica.getFila().filaVazia() == false) {
                    Cliente clienteChamado = filaUnica.getFila().removerFila();
                    postosDeAtendimento[i].clienteEntra(clienteChamado);
                    pilhaSenhasChamadas.inserirPilha(clienteChamado.getSenha());
                    System.out.println(">> ATENDIMENTO: " + clienteChamado.getNome() + " chamado ao Posto " + postosDeAtendimento[i].getNumero() + " (Senha: " + clienteChamado.getSenha() + ")");
                    return; // Encerra o método após colocar UM cliente. O próximo será chamado apenas no próximo turno.
                } else {
                    // Se a fila esvaziar enquanto alocamos clientes nos postos
                    System.out.println(">> AVISO: A fila esvaziou. Postos restantes aguardarão novos clientes.");
                    break; // Sai do laço
                }
            }
        }
    }

    /** Varre os postos de atendimento procurando postos ocupados.
     * Se encontrar, diminui o tempo de atendimento do cliente em 1 turno.
     * Se o tempo de atendimento chegar a zero, o cliente é removido do posto.
     */
    public void processaAtendimentoPostos() {
        for (int i = 0; i < QUANTIDADE_POSTOS_ATENDIMENTO; i++) {
            if (postosDeAtendimento[i].getEmFuncionamento() == true && 
                postosDeAtendimento[i].getAtendendoCliente() == true) {
                
                Cliente clienteNoPosto = postosDeAtendimento[i].getCliente();
                clienteNoPosto.setTempoAtendimento(clienteNoPosto.getTempoAtendimento() - 1);
                
                if (clienteNoPosto.getTempoAtendimento() <= 0) {
                    postosDeAtendimento[i].clienteSai();
                    System.out.println(">> ATENDIMENTO CONCLUÍDO: " + clienteNoPosto.getNome() + " concluiu o atendimento e liberou o Posto " + postosDeAtendimento[i].getNumero());
                }
            }
        }
    }
}
