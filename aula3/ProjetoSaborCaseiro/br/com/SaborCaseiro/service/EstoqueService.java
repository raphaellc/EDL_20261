package raphaellc.ProjetoSaborCaseiro.br.com.SaborCaseiro.service;

import java.util.ArrayList;
import java.util.List;
import raphaellc.ProjetoSaborCaseiro.br.com.SaborCaseiro.model.*;

public class EstoqueService {
    private List<Produto> estoque;

    public EstoqueService() {
        this.estoque = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        estoque.add(produto);
    }

    public void removerProduto(Produto produto) {
        estoque.remove(produto);
    }

    public List<Produto> listarProdutos() {
        return estoque;
    }
}
