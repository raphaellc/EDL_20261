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
        for (int i=0; i<10; i++) {
            Cliente novoCliente = new Cliente("Cliente " + i, geraSenha(), (int)(2*Math.random())+1);
            filaUnica.getFila().inserirFila(novoCliente);
        }

        // Ocupa os postos abertos
        for (int i=0; i < QUANTIDADE_POSTOS_ATENDIMENTO; i++) {
            if (postosDeAtendimento[i].getEmFuncionamento() == true &&
                postosDeAtendimento[i].getAtendendoCliente() == false) {
                    postosDeAtendimento[i].clienteEntra(filaUnica.getFila().removerFila());
                }
        }
    }
    
    public void lacoSimulador() {

        while(true) {
            turno++;
            System.out.println("Turno atual: " + turno);

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

    /** Sorteia se um cliente na fila desistirá */
    public boolean sorteiaDesistencia(Cliente clientePodeDesistir) {
        double x = Math.random();
        if ((0 <= x) && (x < clientePodeDesistir.getProbabilidadeDesistencia())) {
            filaUnica.getFila().removerFilaPrioritaria(i);
        }
    }
}
