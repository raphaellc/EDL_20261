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
        ocupado = true;
    }

    public void liberarPosto(){
        senhaAtual = null;
        ocupado = false;
    }
    
    public int getId(){
        return id;
    }

    public void setAberto(boolean aberto){
        this.aberto = aberto;
    }

    public boolean isAberto(){
        return aberto;
    }

    public boolean isOcupado(){
        return ocupado;
    }

    public Senha getSenhaAtual(){
        return senhaAtual;
    }

    @Override
    public String toString(){
        if(!aberto){
            return "Posto " + id + " - Fechado";
        } else if (ocupado) { 
            return "Posto " + id + " - Ocupado: " + senhaAtual;
        } else {
            return "Posto " + id + " - Livre"; 
        }
    }
}
