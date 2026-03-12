package raphaellc.ProjetoSaborCaseiro.br.com.SaborCaseiro.main;

import raphaellc.ProjetoSaborCaseiro.br.com.SaborCaseiro.model.Produto;
import raphaellc.ProjetoSaborCaseiro.br.com.SaborCaseiro.service.EstoqueService;

public class Panificadora {
    public static void main(String[] args) {
        EstoqueService estoqueService = new EstoqueService();
        Produto p = new Produto("Pão", 2.5, 10);
        estoqueService.adicionarProduto(p);
        estoqueService.removerProduto(p);
        estoqueService.listarProdutos();
    }
}