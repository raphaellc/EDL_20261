package AugustoFeltrin.TrabalhoGB;

public class Posto {
    private int id;
    private boolean aberto;
    private boolean ocupado;
    private Senha senhaAtual;

    public Posto(int id){
        this.id = id;
        this.aberto = true;
        this.ocupado = false;
        this.senhaAtual = null;
    }

    public void ocuparPosto(Senha senha){
        senhaAtual = senha;
    }

    public void liberarPosto(){
        senhaAtual = null;
        ocupado = false;
    }
}
