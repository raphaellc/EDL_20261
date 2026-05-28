/*
GABRIEL PONZONI, GASPAR CAON, NOAH VARGAS

Última compilação do programa feita nas versões:

	javac 21.0.10

e executado na versão:

	openjdk version "21.0.10" 2026-01-20
	OpenJDK Runtime Environment (build 21.0.10+7-Ubuntu-124.04)
	OpenJDK 64-Bit Server VM (build 21.0.10+7-Ubuntu-124.04, mixed mode, sharing)
*/

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    Scanner inputUsuario = new Scanner(System.in);

    int turno = 0; 

    static final int QUANTIDADE_POSTOS_ATENDIMENTO = 5;
    static final int TAMANHO_FILA_NECESSARIO_PARA_4_POSTOS = 15;
    static final int TAMANHO_FILA_NECESSARIO_PARA_5_POSTOS = 25;
    static final int numeroInicialDeClientes = 10;
    static final double probabilidadeNovoClienteNaFila = 0.75;
    int quantidadeMinimaDePostosFuncionando = 3;
    Posto postosDeAtendimento[] = new Posto[QUANTIDADE_POSTOS_ATENDIMENTO];

    //Fila<Cliente> filaUnica = new Fila<>(); // A debater se usaremos a classe Fila.java ou FilaPrioritaria.java // vamos usar FilaPrioritaria pois ja está aqui #remoção
    FilaPrioritaria<Cliente> filaUnica = new FilaPrioritaria<>();

    int numeradorDeSenhas = (int)(50*Math.random()); // inicia a numeração de senhas em um número aleatório inicial
    int totalDeClientes = 0; // Guarda o numero total de clientes durante a execução da simulacão
    Pilha<Senha> pilhaSenhasChamadas = new Pilha<>();
    
    Pilha<Cliente> historicoDesistentes = new Pilha<>();
    Pilha<Cliente> historicoAtendidos = new Pilha<>();

    public static void main(String[] args) {
        
        Main BancoPraxedes = new Main();
        
        BancoPraxedes.inicializa();
        BancoPraxedes.lacoSimulador();

        System.out.println("\nVocê saiu do simulador de fila de banco Praxedes.");
        
        System.out.println("\n--- RELATÓRIO FINAL ---");
        System.out.println("Clientes Atendidos:");
        BancoPraxedes.historicoAtendidos.mostraPilha();
        System.out.println("\nClientes Desistentes:");
        BancoPraxedes.historicoDesistentes.mostraPilha();
    }

    public void inicializa() {
        // Cria postos de atendimento do Banco Praxedes
        for (int i=0; i < QUANTIDADE_POSTOS_ATENDIMENTO; i++) {
            postosDeAtendimento[i] = new Posto(i+1, false, false, null);
        }

        // Abre alguns postos
        for (int i=0; i < quantidadeMinimaDePostosFuncionando; i++) {
            abrePosto(i);
        }

        // Gera alguns clientes e encadeia-os na fila. Senha aleatória e tempo de atendimento aleatório.
        for (int i=0; i<numeroInicialDeClientes; i++) {
            Cliente novoCliente = new Cliente("Cliente " + totalDeClientes, geraSenha(), geraTempoDeAtendimento());
            filaUnica.getFila().inserirFila(novoCliente);
            totalDeClientes++;
        }
    }
    
    public void lacoSimulador() {

        while(true) {

            clearScreen();
            turno++;
            System.out.println("\n\n\nTurno atual: " + turno);
            
            processaAtendimentoPostos();

            // decideQuantidadeMinimaDePostosFuncionando();
            alteraQuantidadeMinimaDePostosFuncionando(); // Este método deve ser chamado logo após a conclusão de um atendimento
            
            // Este comando poderia ser transferido para o método inicializar()
            // metodo chamar clientes n pode funcionar no primeiro turno, para motivos de melhor visualização
            if (turno > 1) { 
                chamarClientesParaPostosLivres();
            } else {
                System.out.println("\n\t>> AVISO: Primeiro turno. Os postos aguardarão o próximo turno para iniciar os atendimentos.");
            }

            decideDesistenciaClientes();
            decideChegaNovoClienteNaFila(); // Isto evitará que um cliente recém chegado na fila desista.

            mostraPostos();
            filaUnica.mostraFilaPrioritaria();

            // Talvez melhor só mostrar as pilhas ao sair da simulação. Passar para método main()
            System.out.println("\n--- Histórico de Atendidos ---");
            historicoAtendidos.mostraPilha();
            System.out.println("\n--- Histórico de Desistentes ---");
            historicoDesistentes.mostraPilha();

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

    /** Gera uma senha P ou N aleatoriamente. Seu número é único na simulação, baseado
     * no numerador de senhas. É necessário usar <b>++numeradorDeSenhas</b> ao invés de
     * <b>numeradorDeSenhas++</b> para que o incremento se dê ANTES da linha ser executada.
     */
    public Senha geraSenha() {
        return new Senha(caraOuCoroa(), ++numeradorDeSenhas);
    }

    /** Gera um tempo de atendimento aleatório segundo a fórmula empregada no método. */
    public int geraTempoDeAtendimento() {
        return (int)(Math.random()*4) + 5;
    }

    /** Lista o estado de todos os postos na tela.
     * @see método <b>toString()</b> em <b>Posto.java</b> para entender como isso é feito.
     */
    public void mostraPostos() {
        for (int i=0; i < QUANTIDADE_POSTOS_ATENDIMENTO; i++) {
            System.out.println(postosDeAtendimento[i]);
        }
    }

    /** Abre um posto. Atenção: índice dos postos inicia em 0
     * @param numeroPostoInformado
     */
    public void abrePosto(int numeroPostoInformado) {
        postosDeAtendimento[numeroPostoInformado].setEmFuncionamento(true);
    }

    /** Fecha um posto. Atenção: índice dos postos inicia em 0.
     * @return postoAretornar
     */
    public Posto fechaPosto(int numeroPostoInformado) {
        postosDeAtendimento[numeroPostoInformado].setEmFuncionamento(false);
        Posto postoAretornar = postosDeAtendimento[numeroPostoInformado];
        return postoAretornar;
    }

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
                System.out.println("\n\tDESISTÊNCIA: " + clienteAuxiliar + " desistiu de esperar.");
            }
            noAuxiliar = noAuxiliar.getProximo();
        }
        

        // Guarda os clientes desistentes no histórico de desistentes
        for (Cliente c : listaClientesDesistentes) {
            historicoDesistentes.inserirPilha(c);
        }
        removeClientesDesistentes(listaClientesDesistentes);
            /* Primeiro, insere desistentes na pilha de desistentes. Segundo, remove clientes da fila. */
    }

    /** Este método percorre todos os clientes de um ArrayList,
     * executando a operação de remoção da classe FilaPrioritaria.java.
     * @param lista
     */
    public void removeClientesDesistentes(ArrayList<Cliente> lista) {
        for (Cliente c : lista) {
            filaUnica.removerFilaPrioritaria(c.getSenha().getNumero());
        }
    }

    /** Varre os postos de atendimento procurando postos abertos e livres.
     * Se encontrar, remove o próximo cliente da frente da fila e aloca-o no posto.
     * A senha do cliente também é empilhada no histórico de senhas chamadas.
     */
    public void chamarClientesParaPostosLivres() {
        
        if (filaUnica.getFila().filaVazia() == true) {
            System.out.println("\n\t>> AVISO: A fila está vazia. Nenhum cliente para chamar.");
            return; // Sai do método pois não há ninguém para chamar
        }

        for (int i = 0; i < QUANTIDADE_POSTOS_ATENDIMENTO; i++) {
            if (postosDeAtendimento[i].getEmFuncionamento() == true && 
                postosDeAtendimento[i].getAtendendoCliente() == false) {

                Cliente clienteAchamar;

                if (decideSeSelecionaSenhaNouP() == false) {
                    clienteAchamar = chamaProximoClienteFila();
                    postosDeAtendimento[i].clienteEntra(clienteAchamar);
                    pilhaSenhasChamadas.inserirPilha(clienteAchamar.getSenha());
                    historicoAtendidos.inserirPilha(clienteAchamar);
                        /* Guarda o cliente no histórico de atendidos, mesmo que o atendimento ainda não tenha sido concluído. O mesma para a senha.
                        Na verdade, a ideia aqui não é um histórico de atendidos, mas sim um histórico de clientes chamados */
                    System.out.println("\n\t>> ATENDIMENTO: " + clienteAchamar.getNome() + " chamado ao Posto " + postosDeAtendimento[i].getNumero() + " (Senha: " + clienteAchamar.getSenha() + ")");
                    return; 

                } else {

                    No<Cliente> noAuxiliar = filaUnica.getFila().getInicio();
                    //clienteAchamar = noAuxiliar.getDado();
                    
                    // percorre a fila em busca de cliente que satisfaça a condição de seleção "P ou N"
                    while (noAuxiliar != null) {
                        clienteAchamar = noAuxiliar.getDado();

                        if (clienteAchamar.getSenha().getPrioridade() == decideSenhaPouN()) {
                            filaUnica.removerFilaPrioritaria(clienteAchamar.getSenha().getNumero());
                            postosDeAtendimento[i].clienteEntra(clienteAchamar);
                            pilhaSenhasChamadas.inserirPilha(clienteAchamar.getSenha());
                            historicoAtendidos.inserirPilha(clienteAchamar);
                            System.out.println("\n\t>> ATENDIMENTO: " + clienteAchamar.getNome() + " chamado ao Posto " + postosDeAtendimento[i].getNumero() + " (Senha: " + clienteAchamar.getSenha() + ")");
                            return; 
                        }
                        noAuxiliar = noAuxiliar.getProximo();
                    }

                    System.out.println("\n\t>> AVISO: nenhum cliente satisfaz a condição de prioridade. Chamando o primeiro da fila...");
                    clienteAchamar = chamaProximoClienteFila();
                    postosDeAtendimento[i].clienteEntra(clienteAchamar);
                    pilhaSenhasChamadas.inserirPilha(clienteAchamar.getSenha());
                    historicoAtendidos.inserirPilha(clienteAchamar);
                       
                    System.out.println("\n\t>> ATENDIMENTO: " + clienteAchamar.getNome() + " chamado ao Posto " + postosDeAtendimento[i].getNumero() + " (Senha: " + clienteAchamar.getSenha() + ")");
                    return; 
                }
                
            }
        }
    }

    /** Apenas retorna o próximo cliente da fila, desconsiderando sua categoria (P ou N) */
    public Cliente chamaProximoClienteFila() {
        return filaUnica.getFila().removerFila();
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
                    System.out.println("\n\t>> ATENDIMENTO CONCLUÍDO: " + clienteNoPosto.getNome() + " concluiu o atendimento e liberou o Posto " + postosDeAtendimento[i].getNumero());
                }
            }
        }
    }

    /** Verifica se ao menos 3 clientes estão em atendimento. Se sim, suas senhas já foram empilhadas na pilha de senhas.
     * Deve-se chamar os próximoas clientes da fila com triagem de senha. Caso contrário, o primeiro cliente da fila será chamado
     * sem necessidade de triagem. Retorna <b>true</b> para triar (tamanho da pilha de senhas > 3) ou <b>false</b> para ignorar triagem (tamanho <= 3).
     * Este método deve ser chamado dentro do método <b>chamarClientesParaPostosLivres()<b/>. Este método se aplica principalmente para
     * a situação inicial da fila, quando ainda nenhum cliente foi atendido.
     */
    public boolean decideSeSelecionaSenhaNouP() {
        if (pilhaSenhasChamadas.getTamanho() <=3) { // significa que 3 ou menos clientes estão em atendimento, e ninguém antes deles foi atendido. 
            return false;
        } else return true;
    }

     /** Baseado na inspeção da pilha de clientes atendidos (senhas chamadas), decide se o próximo cliente chamado será N ou P.
     * A pilha de clientes atendidos deve ser comparada com o critério 2N-1P, ou seja, P é chamado após 2N, e N é chamado após P, ou P seguindo de N.
     * Retorna "true" para selecionar senha P, ou "false" para selecionar senha N.
     * @return serPrioritaria
    */
    public boolean decideSenhaPouN() {
        
        // Se a pilha de chamadas não tiver ao menos 3 senhas, escolhe qualquer senha.
        if (pilhaSenhasChamadas.getTopo() == null ||
            pilhaSenhasChamadas.getTopo().getProximo() == null ||
            pilhaSenhasChamadas.getTopo().getProximo().getProximo() == null) {
            
            return caraOuCoroa(); 
        }

        Senha ultimaSenhaChamada = pilhaSenhasChamadas.getTopo().getDado();
        Senha penultimaSenhaChamada = pilhaSenhasChamadas.getTopo().getProximo().getDado();

        if (ultimaSenhaChamada.getPrioridade() == true) {
            return false; // último foi P; chamar senha N
        } else {
            if (penultimaSenhaChamada.getPrioridade() == true) {
                return false; // último e penúltimo chamados foram N-P; chamar N
            } else {
                return true; // último e penúltimo chamados foram N-N; chamar P
            }
        }
    }

    //public boolean decideQuantidadeMinimaDePostosFuncionando() {}

    /** Muda o número de postos funcionando de acordo com o tamanho da fila. O tamanho da fila varia de 0 a infinito.
     * Os valores TAMANHO_FILA_NECESSARIO_PARA_4_POSTOS e TAMANHO_FILA_NECESSARIO_PARA_5_POSTOS são constantes declaradas
     * adequadamente no cabeçalho do programa. Esses valores dividem a fila em intervalos definidos.
     * Esses intervalos são comparados com o tamanho real da fila para, somente então, tomar-se a decisão de manter, aumentar
     * ou diminuir a fila. <b>Este método deve ser chamado imediatamente após a conclusão de um atendimento, evitando que
     * um cliente seja chamado antes de um posto fechar, havendo esta necessidade.</b>
     * 
     * 0 .......... tamanho1 .......... tamanho2 .............. (inf)
     *   [3 postos]          [4 postos]          [4 postos]
     */
    public void alteraQuantidadeMinimaDePostosFuncionando() {
        if (filaUnica.getFila().getTamanho() >= TAMANHO_FILA_NECESSARIO_PARA_4_POSTOS) {
            postosDeAtendimento[3].setEmFuncionamento(true);
            System.out.println("\n\t>> AVISO: O posto 4 abriu. ");

            if (filaUnica.getFila().getTamanho() >= TAMANHO_FILA_NECESSARIO_PARA_5_POSTOS) {
                postosDeAtendimento[4].setEmFuncionamento(true);
                System.out.println("\n\t>> AVISO: O posto 5 abriu. ");
            }
            else {
                 postosDeAtendimento[4].setEmFuncionamento(false);
            }
        }
        else { // garante que ambos os postos estejam fechados caso a fila seja muito pequena, evitando que o 5 esteja aberto e o 4 esteja fechado
            postosDeAtendimento[3].setEmFuncionamento(false);
            postosDeAtendimento[4].setEmFuncionamento(false);
        }
    }

    /** Decide aleatoriamente se um novo cliente aparecerá no fim da fila. Probabilidade dada pela constante <b>probabilidadeNovoClienteNaFila</b>. */
    public void decideChegaNovoClienteNaFila() {
        if (Math.random() <= probabilidadeNovoClienteNaFila){
            Cliente novoCliente = new Cliente("Cliente " + totalDeClientes, geraSenha(), geraTempoDeAtendimento());
            filaUnica.getFila().inserirFila(novoCliente);
            totalDeClientes++;
            System.out.println("\n\t>> AVISO: " + filaUnica.getFila().getFim() + " entrou na fila.");
        }
    }

    /** Limpa o terminal. Usado a cada novo turno. */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
