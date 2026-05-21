package AugustoFeltrin.TrabalhoGB;

public class Senha {
    private char tipo;
    private int numero;

    public Senha(char tipo, int numero){
        this.tipo = tipo;
        this.numero = numero;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString(){
        return tipo + String.format("%03d", numero);
    }
}