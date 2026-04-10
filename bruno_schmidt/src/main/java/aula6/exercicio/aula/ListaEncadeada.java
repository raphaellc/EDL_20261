package aula6.exercicio.aula;

import aula5.conteudo.aula.lista.ligada.NoSimples;

public interface ListaEncadeada<N, T> {
    N buscar(int pos);
    void adicionar(T dado);
    void remover(int pos);
    void atualizar(int pos, T novoDado);
    void mostrarTudo();
    int tamanho();
}
