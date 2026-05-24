package AugustoFeltrin.TrabalhoGB;
import java.util.Random;

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
    
    private Senha proximaSenha(){

    // tenta normal primeiro
    if(sequenciaNormais < 2 && !filaNormal.estaVazia()){

        sequenciaNormais++;

        return filaNormal.desenfileirar();
    }

    // tenta prioritária
    if(!filaPrioritaria.estaVazia()){

        sequenciaNormais = 0;

        return filaPrioritaria.desenfileirar();
    }

    // fallback normal
    if(!filaNormal.estaVazia()){

        sequenciaNormais++;

        return filaNormal.desenfileirar();
    }
        return null;
    }

    public void atenderProximaSenha(){
        for(int i = 0; i < postos.length; i++){
            Posto posto = postos[i];
            if(posto.isAberto() && !posto.isOcupado()){
                Senha senha = proximaSenha();

                if(senha != null){
                    posto.ocuparPosto(senha);
                    historico.empilhar(senha);
                    totalAtendidas++;
                }
            }
        }
    }

    public void mostrarStatus(){
        System.out.println("\n========== STATUS DO SISTEMA ==========");
        
        int totalFila = filaNormal.getTamanho() + filaPrioritaria.getTamanho();
        System.out.println("Fila total: " + totalFila);

        System.out.println("\nPróxima normal: " + filaNormal.frente());
        System.out.println("Próxima prioritária: " + filaPrioritaria.frente());

        System.out.println("\n--- POSTOS DE ATENDIMENTO ---");
        for (int i = 0; i < postos.length; i++) {
            System.out.println(postos[i]);
        }

        System.out.println("--- ESTATÍSTICAS ---");
        System.out.println("Atendidas: " + totalAtendidas);
        System.out.println("Desistências: " + totalDesistencias);
        System.out.println("=======================================\n");
    }

    public void liberarPostos(){
        for(int i = 0; i < postos.length; i++){
            Posto posto = postos[i];
            
            if(posto.isAberto() && posto.isOcupado()){
                posto.liberarPosto();
            }
        }
    }
    public void simularDesitencia(){
        if(!filaNormal.estaVazia()){
            Senha senha = filaNormal.desenfileirar();
            totalDesistencias++;            
            System.out.println("Senha " + senha + " desistiu");
        } else if (!filaPrioritaria.estaVazia()){
            Senha senha = filaPrioritaria.desenfileirar();
            totalDesistencias++;
            System.out.println("Senha " + senha + " desistiu");
        }
    }

    public void mostrarHistorico(){
        System.out.println("\n===== HISTÓRICO DE ATENDIMENTOS =====");
        historico.listaPilha();
    }

    public void iniciarSimulacao(){
        Random random = new Random();
    
        for(int i = 1; i <= 10; i++){
            System.out.println("\n========= ITERAÇÃO " + i + " =========");
            
            int novaSenhas = random.nextInt(6) + 1;
            int tipoSenha = random.nextInt(100);

            for(int j = 0; j < novaSenhas; j++){
                if(tipoSenha < 60){
                    gerarSenhaNormal();
                } else {
                    gerarSenhaPrioritaria();
                }
            }
        
            if(random.nextInt(100) < 20){
                simularDesitencia();
            }
            atenderProximaSenha();
            mostrarStatus();
            liberarPostos();
        } 

        mostrarHistorico();
    }

}