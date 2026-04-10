package Lista;

import java.util.Optional;

public interface ILista<T> {
    void adicionar(T dado);
    boolean adicionar(int posicao, T dado);
    Optional<T> obter(int posicao);
    boolean remover(int posicao);
    boolean remover(T dado);
    boolean contemNaLista(T dado);
    int getTamanho();
    boolean estaVazia();
    void limpar();
}
