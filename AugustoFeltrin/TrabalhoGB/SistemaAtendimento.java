package AugustoFeltrin.TrabalhoGB;

public class SistemaAtendimento {
    
    // Filas de espera
    private Fila<Senha> filaNormal;
    private Fila<Senha> filaPrioritaria;

    // Histórico de atendimentos
    private Pilha<Senha> historico;

    // Postos de atendimento
    private Posto[] postos;

    // Controle de geração das senhas
    private int contadorNormal;
    private int contadorPrioritaria;

    // Controle da regra 2N : 1P
    private int sequenciaNormais;
    
    // Estatísticas do sistema
    private int totalAtendidas;
    private int totalDesistencias;

    public SistemaAtendimento(){
        filaNormal = new Fila<>();
        filaPrioritaria = new Fila<>();

        historico = new Pilha<>();
        postos = new Posto[5];

        for (int i = 0; i < postos.length; i++) {
            postos[i] = new Posto(i + 1);
        }
    
        postos[3].setAberto(false);
        postos[4].setAberto(false);

        contadorNormal = 0; 
        contadorPrioritaria = 0; 
        
        sequenciaNormais = 0; 
        
        totalAtendidas = 0; 
        totalDesistencias = 0;
    }

    public void gerarSenhaNormal(){
        contadorNormal++;
        Senha senha = new Senha('N', contadorNormal);
        filaNormal.enfileirar(senha);
    }

    public void gerarSenhaPrioritaria(){
        contadorPrioritaria++;
        Senha senha = new Senha('P', contadorPrioritaria);
        filaPrioritaria.enfileirar(senha);
    }

    /*private*/ public Senha proximaSenha() {
    	if(sequenciaNormais < 2) {
    		if(!filaNormal.estaVazia()) {
    			Senha senha = filaNormal.desenfileirar();
    			sequenciaNormais++;
    			return senha;
    		} 
    	} else if (!filaPrioritaria.estaVazia()) {
    			Senha senha = filaPrioritaria.desenfileirar();
    			sequenciaNormais = 0;
    			return senha;
    	}
		return null;
    }
}
