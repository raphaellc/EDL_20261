public class Posto {
    
    boolean emAtendimento;
    Cliente clienteEmAtendimento;

    /// CONSTRUTOR
    /** Por padrão, o posto está livre. */
    public Posto() {
        this.emAtendimento = false;
        this.clienteEmAtendimento = null;
    }

    /// MÉTODOS
    /** Informe o cliente a atender. O status do posto mudará
     * automaticamente para ocupado. Retorna o nome do cliente.
     * @param clienteParaAtender
     * @return cliente.getDado()
     */
    public String clienteEntra(Cliente clienteParaAtender) {
        clienteEmAtendimento = clienteParaAtender;
        emAtendimento = true;
        return clienteEmAtendimento.getPessoa().getDado();
    }

    /** Remove cliente do posto. Retorna o cliente que foi
     * atendido.
     * @returns nomeCliente;
     */
    public String clienteSai() {
        String nomeCliente = clienteEmAtendimento.getPessoa().getDado();
        clienteEmAtendimento = null;
        return nomeCliente;
    }
    
}
