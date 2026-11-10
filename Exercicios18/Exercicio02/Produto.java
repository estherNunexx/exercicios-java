
public class Produto {

    private Long id;
    private String descricao;
    private Double precoUnitario;
    private Integer quantidadeEstoque;

    public Produto(Long id, String descricao, Double precoUnitario,
                   Integer quantidadeEstoque) {

        this.id = id;
        this.descricao = descricao;
        this.precoUnitario = precoUnitario;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getPrecoUnitario() {
        return precoUnitario;
    }

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }
}
