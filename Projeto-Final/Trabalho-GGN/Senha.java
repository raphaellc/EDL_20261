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
    public Senha(boolean priodidadeInformada) {
        this.serPriotaria = priodidadeInformada;
    }

    /** Construtor completo para uma senha.
     * Use 'true' para senha prioriária ou 'false' para senha comum.
     * Informe também o número da senha.
     * @param prioridadeInformada
     * @param numeroInformado
     */
    public Senha(boolean prioridadeInformada, int numeroInformado) {
        this.serPriotaria = prioridadeInformada;
        this.numero = numeroInformado;
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

    /** Este "Override" utiliza um operador ternário, significando:
     * "se a senha for prioritária, imprima "P"; caso contrário, imprima "N"
    */
    @Override
    public String toString() {
        String x = (serPriotaria==true) ? "P" : "N";
        return "nº" + numero
                    + "("
                    + x
                    + ")";

        //if (serPriotaria == true) return "P";
        //else return "N";
    }

}
