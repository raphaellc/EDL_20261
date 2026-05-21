public class Senha {
    
    int numero;
    boolean serPriotaria;

    /// CONSTRUTORES
    /** Por padrão, a senha é comum. */
    public Senha() {
        this.serPriotaria = false;
    }

    /** Construtor que permite atribuição de prioridade para uma senha.
     * Use 'true' para senha prioriária ou 'false' para senha comum.
     * @param serPrioritaria
     */
    public Senha(boolean prioridade_informada) {
        this.serPriotaria = prioridade_informada;
    }

    /// GETTER-SETTER
    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numeroSenha_informada) {
        this.numero = numeroSenha_informada;
    }

    public boolean getPrioridade() {
        return this.serPriotaria;
    }

    /// MÉTODOS
    public boolean mudaPrioridade() {
        serPriotaria = !serPriotaria;
        return serPriotaria;
    }

    @Override
    public String toString() {
        if (serPriotaria == true) return "\tsenha é Prioriária";
        else return "\tsenha é Comum";
    }

}
