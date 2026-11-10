public class ItemPedido {

    private Long id;
    private String produto;
    private Integer quantidade;

    public ItemPedido(Long id, String produto, Integer quantidade) {
        this.id = id;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public String getProduto() {
        return produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }
}
