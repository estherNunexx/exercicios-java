package dominio;

import java.util.Objects;

public class Produto implements Comparable<Produto> {

    private String codigo;
    private String descricao;
    private double preco;
    private int quantidade;

    public Produto(String codigo, String descricao, double preco, int quantidade) {

        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "O código do produto é obrigatório."
            );
        }

        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "A descrição do produto é obrigatória."
            );
        }

        if (preco < 0) {
            throw new IllegalArgumentException(
                    "O preço não pode ser negativo."
            );
        }

        if (quantidade < 0) {
            throw new IllegalArgumentException(
                    "A quantidade não pode ser negativa."
            );
        }

        this.codigo = codigo.trim();
        this.descricao = descricao.trim();
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public int compareTo(Produto outro) {
        return Double.compare(this.preco, outro.preco);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Produto outro = (Produto) obj;

        return Objects.equals(this.codigo, outro.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public String toString() {
        return String.format(
                "Código: %s | Descrição: %s | Preço: %.2f | Quantidade: %d",
                codigo,
                descricao,
                preco,
                quantidade
        );
    }
}
