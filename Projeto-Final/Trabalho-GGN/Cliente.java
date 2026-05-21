public class Cliente {
    
    private String nome;
    private Senha senhaCliente = new Senha();
    private int tempoAtendimento = 1;

    /// CONSTRUTORES
    /** Construtor mínimo para um cliente. Informe apenas o nome.
     * Sua a senha é uma senha padrão (não prioritária), e seu
     * tempo de atendimento é de 1 turno. OBS: Este cliente genérico
     * não é muito útil para a simulação. Prefira o construtor com
     * mais parâmetros personalizáveis.
     * @param nomeInformado
     */
    public Cliente(String nomeInformado) {
        this.nome = nomeInformado;
    }

    public Cliente(String nomeInformado, Senha senhaInformada) {
        this.nome = nomeInformado;
        this.senhaCliente = senhaInformada;
    }

    public Cliente(String nomeInformado, Senha senhaInformada, int tempoAtendimentoInformado) {
        this.nome = nomeInformado;
        this.senhaCliente = senhaInformada;
        this.tempoAtendimento = tempoAtendimentoInformado;
    }

    /// GETTER-SETTER
    public String getNome() {
        return nome;
    }

    public Senha getSenha() {
        return senhaCliente;
    }

    public void setSenha(Senha senhaInformada) {
        senhaCliente = senhaInformada;
    }

    public int getTempoAtendimento() {
        return tempoAtendimento;
    }

    public void setTempoAtendimento(int tempoAtendimentoInformado) {
        tempoAtendimento = tempoAtendimentoInformado;
    }
    

}
