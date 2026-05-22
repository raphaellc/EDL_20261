public class Posto {
    
    private int numero;
    private boolean emFuncionamento;
    private boolean atendendoCliente;
    private Cliente clienteEmAtendimento;

    

    // TODO reavaliar a necessidade de haver 2 booleanos aqui: pode gerar situação inusitada em que o posto esteja fechado E com cliente

    /// CONSTRUTOR
    /** Informe o número do posto, se está aberto, se está atendendo cliente e o nome do cliente.
     * @param numeroInformado
     * @param emFuncionamentoInformado
     * @param atendendoClienteInformadoInformado
     * @param clienteEmAtendimentoInformado
     */
    public Posto(int numeroInformado, boolean emFuncionamentoInformado, boolean atendendoClienteInformadoInformado, Cliente clienteEmAtendimentoInformado) {
        this.numero = numeroInformado;
        this.emFuncionamento = emFuncionamentoInformado;
        this.atendendoCliente = atendendoClienteInformadoInformado;
        this.clienteEmAtendimento = clienteEmAtendimentoInformado;
    }

    // GETTER-SETTER
    public int getNumero() {return numero;}
    public void setNumero(int numeroInformado) {numero = numeroInformado;}
    
    public boolean getEmFuncionamento() {return emFuncionamento;}
    public void setEmFuncionamento(boolean emFuncionamentoInformado) {emFuncionamento = emFuncionamentoInformado;}

    public boolean getAtendendoCliente() {return atendendoCliente;}
    public void setAtendendoCliente(boolean atendendoClienteInformado) {atendendoCliente = atendendoClienteInformado;}

    public Cliente getCliente() {return clienteEmAtendimento;}

    /// MÉTODOS
    /** Informe o cliente a atender. O status do posto mudará automaticamente para ocupado.
     * Retorna o nome do cliente. Se o posto estiver fechado, retornará String vazia "" com uma mensagem de aviso.
     * @param clienteParaAtender
     * @return clienteParaAtender.getNome()
     */
    public String clienteEntra(Cliente clienteParaAtender) {
        
        if (emFuncionamento == false) {
            System.out.println("Posto " + getNumero() + " fechado.");
            return "";
        }
        
        clienteEmAtendimento = clienteParaAtender;
        atendendoCliente = true;
        return clienteEmAtendimento.getNome();
    }

    /** Remove cliente do posto. Retorna o cliente que foi
     * atendido.
     * @returns nomeCliente;
     */
    public String clienteSai() {
        String nomeCliente = clienteEmAtendimento.getNome();
        clienteEmAtendimento = null;
        atendendoCliente = false; //precisa ser false, n null se n da b.o
        return nomeCliente;
    }

    public String converteBooleanToStringFuncionamento() {
        if (emFuncionamento == true) return "Aberto";
        else return "Fechado";
    }

    public String converteBooleanToStringAtendimento() {
        if (atendendoCliente == true) return "Ocupado";
        else return "Livre";
    }
    
    /** */
    @Override
    public String toString() {
        
        if (emFuncionamento == true) {

            if (clienteEmAtendimento == null) {
                // se o posto estiver aberto, mas sem cliente, retorna apenas o status do posto
                return "Posto nº" + getNumero()
                                  + ", "
                                  + converteBooleanToStringFuncionamento()
                                  + ", "
                                  + converteBooleanToStringAtendimento();
            }

            return "Posto nº" + getNumero()
                              + ", "
                              + converteBooleanToStringFuncionamento()
                              + ", "
                              + converteBooleanToStringAtendimento()
                              + ": "
                              + clienteEmAtendimento
                              + ", "
                              + clienteEmAtendimento.getSenha()
                              + ", "
                              + clienteEmAtendimento.getTempoAtendimento();

        } else {
            
            return "Posto nº" + getNumero()
                              + ", "
                              + converteBooleanToStringFuncionamento();
        }
    }
}
