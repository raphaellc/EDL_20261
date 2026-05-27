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
    static final int TAMANHO_FILA_NECESSARIO_PARA_4_POSTOS = 15;
    static final int TAMANHO_FILA_NECESSARIO_PARA_5_POSTOS = 25;
    int quantidadeMinimaDePostosFuncionando = 3;
    Posto postosDeAtendimento[] = new Posto[QUANTIDADE_POSTOS_ATENDIMENTO];

    //Fila<Cliente> filaUnica = new Fila<>(); // A debater se usaremos a classe Fila.java ou FilaPrioritaria.java // vamos usar FilaPrioritaria pois ja está aqui #remoção
    FilaPrioritaria<Cliente> filaUnica = new FilaPrioritaria<>();

    int NumeradorDeSenhas = (int)(50*Math.random()); // inicia a numeração de senhas em um número aleatório inicial
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
        for (int i=0; i<20; i++) {
            Cliente novoCliente = new Cliente("Cliente " + i, geraSenha(), (int)(Math.random()* 4) + 1);
            filaUnica.getFila().inserirFila(novoCliente);
        }
    }
    
    public void lacoSimulador() {

        while(true) {
            turno++;
            System.out.println("Turno atual: " + turno);

            
            processaAtendimentoPostos();
            
            System.out.println("\n--- Histórico de Atendidos ---");
            historicoAtendidos.mostraPilha();
            System.out.println("\n--- Histórico de Desistentes ---");
            historicoDesistentes.mostraPilha();
            
            // alteraQuantidadeMinimaDePostosFuncionando() // Este método deve ser chamado logo após a conclusão de um atendimento
            
            // metodo chamar clientes n pode funcionar no primeiro turno, para motivos de melhro visualizacao
            if (turno > 1) { 
                chamarClientesParaPostosLivres();
            } else {
                System.out.println(">> AVISO: Primeiro turno. Os postos aguardarão o próximo turno para iniciar os atendimentos.");
            }

            // decideChegaNovoClienteNaFila()
            decideDesistenciaClientes(); // Este método deveria ser o último a ser chamado no while()

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
                System.out.println(clienteAuxiliar + " desistiu de esperar.");
            }
            noAuxiliar = noAuxiliar.getProximo();
        }
        removeClientesDesistentes(listaClientesDesistentes);
        
        // Guarda os clientes desistentes no histórico de desistentes
        for (Cliente c : listaClientesDesistentes) {
            historicoDesistentes.inserirPilha(c);
        }
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
                    /* Questiono a necessidade deste ramo ELSE do IF; entendo que o cliente que é chamado não pode mais sair da fila,
                    porque quando ele for chamado, ele é removido da fila com este comando:
                        Cliente clienteChamado = filaUnica.getFila().removerFila();
                    Quando os desistentes forem sorteados, este cliente já não constará mais na fila e não poderá mais desistir.
                    E também não importa a ordem em que os métodos aconteçam:
                        chamarClientesParaPostosLivres()
                        decideDesistenciaClientes()
                    ou
                        decideDesistenciaClientes()
                        chamarClientesParaPostosLivres()
                    Ambos métodos removem o cliente da fila. A questão é qual método deve ser chamado primeiro no laço principal
                    Entendo que seria uma melhor modelagem fazer nesta ordem:

                        chamarClientesParaPostosLivres()
                        decideDesistenciaClientes()
                    */
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
                    historicoAtendidos.inserirPilha(clienteNoPosto); // Guarda o cliente atendido no histórico de atendidos
                    /* É importante que o comando acima aconteça antes deste ponto. Assim que o cliente entra no posto,
                    sua senha deve imediatamente ir para a pilha de clientes atendidos, ainda que o seu atendimento não tenha concluído.
                    Desta forma, ficará registrado 'em tempo real' qual tipo de senha foi chamada (N ou P). Isto é necessário para
                    decidir qual tipo de cliente será o próximo chamado. */
                    System.out.println(">> ATENDIMENTO CONCLUÍDO: " + clienteNoPosto.getNome() + " concluiu o atendimento e liberou o Posto " + postosDeAtendimento[i].getNumero());
                }
            }
        }
    }

    /** Baseado na inspeção da pilha de clientes atendidos (senhas chamadas), decide se o próximo cliente chamado será N ou P.
     * A pilha de clientes atendidos deve ser comparada com o critério 2N-1P. if ( (2N e 1P) ou (1P e 2N) ) foram as 3 últimas
     * chamadas, deve chamar uma senha N ou P conforme a comparação. Este método deve ser chamado dentro do método <b>chamarClientesParaPostosLivres()<b/>
    */
    public void decideAtendendimentoNouP() {}

    /** Muda o número de postos funcionando de acordo com o tamanho da fila. O tamanho da fila varia de 0 a infinito.
     * Os valores TAMANHO_FILA_NECESSARIO_PARA_4_POSTOS e TAMANHO_FILA_NECESSARIO_PARA_5_POSTOS são constantes declaradas
     * adequadamente no cabeçalho do programa. Esses valores dividem o espaço da fila em intervalos definidos.
     * Esses intervalos são comparados com o tamanho real da fila para, somente então, tomar-se a decisão de manter, aumentar
     * ou dimnuir a fila. <b>Este método deve ser chamado imediatamente após a conclusão de um atendimento, evitando que
     * um cliente seja chamado antes de um posto fechar, havendo esta necessidade.</b>
     * 
     * 0 .......... tamanho1 .......... tamanho2 .............. (inf)
     *   [3 postos]          [4 postos]          [4 postos]
     */
    public void alteraQuantidadeMinimaDePostosFuncionando() {
        if (filaUnica.getFila().getTamanho() >= TAMANHO_FILA_NECESSARIO_PARA_4_POSTOS) {
            postosDeAtendimento[3].setEmFuncionamento(true);

            if (filaUnica.getFila().getTamanho() >= TAMANHO_FILA_NECESSARIO_PARA_5_POSTOS) {
                postosDeAtendimento[4].setEmFuncionamento(true);
            }
            else {
                 postosDeAtendimento[4].setEmFuncionamento(false);
            }
        }
        else { // garante que ambas os postos estejam fechados caso a fila seja muito pequena, evitando que o 5 esteja aberto e o 4 esteja fechado
            postosDeAtendimento[3].setEmFuncionamento(false);
            postosDeAtendimento[4].setEmFuncionamento(false);
        }
    }

    /** Decide aleatoriamente se um novo cliente aparecerá no fim da fila. Usar Math.random() para isso. Sugiro usar uma probabilidade de 10% */
    public void decideChegaNovoClienteNaFila() {}
}
