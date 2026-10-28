package Service;
import dominio.Produto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CatalogoService {

    private final List<Produto> produtos = new ArrayList<>();

    public void cadastrar(Produto p) {

        if (p == null) {
            throw new IllegalArgumentException(
                    "Não é permitido cadastrar um produto nulo"
            );
        }

        if (produtos.contains(p)) {
            throw new IllegalStateException(
                    "Já existe um produto com o código: "
                            + p.getCodigo()
            );
        }

        produtos.add(p);
    }

    public Produto obterPorPosicao(int indice) {

        if (produtos.isEmpty()) {
            throw new IllegalStateException(
                    "O catálogo está vazio"
            );
        }

        if (indice < 0 || indice >= produtos.size()) {
            throw new IndexOutOfBoundsException(
                    "Posição inválida: " + indice
            );
        }

        return produtos.get(indice);
    }

    public boolean excluirPorCodigo(String codigo) {

        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "O código do produto é obrigatório"
            );
        }

        return produtos.removeIf(
                p -> p.getCodigo().equalsIgnoreCase(codigo.trim())
        );
    }
    public void ordenarPorPreco() {
        if (produtos.isEmpty()) {
            throw new IllegalStateException(
                    "Não é possível ordenar um catálogo vazio"
            );
        }

        Collections.sort(produtos);
    }

    public List<Produto> listarTodos() {
        return new ArrayList<>(produtos);
    }

    public int getTotalProdutos() {
        return produtos.size();
    }
}
