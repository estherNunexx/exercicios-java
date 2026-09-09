class Produto {
    private String nome;
    private double preco;
    private int quantidadeEstoque;

    // Construtor completo
    public Produto(String nome, double preco, int quantidadeEstoque) {
        this.nome = nome;
        setPreco(preco);
        setQuantidadeEstoque(quantidadeEstoque);
    }

    
    public Produto(String nome, double preco) {
        this.nome = nome;
        setPreco(preco);
        this.quantidadeEstoque = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco >= 0) {
            this.preco = preco;
        }
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        if (quantidadeEstoque >= 0) {
            this.quantidadeEstoque = quantidadeEstoque;
        }
    }

    public double calcularValorTotalEmEstoque() {
        return preco * quantidadeEstoque;
    }
}

public class ClasseProduto {
    public static void main(String[] args) {

        Produto produtoA = new Produto("Blush", 25.00, 10);

        Produto produtoB = new Produto("Gloss", 10.00);

        System.out.println("Produto A:");
        System.out.println("Nome: " + produtoA.getNome());
        System.out.println("Preço: R$ " + produtoA.getPreco());
        System.out.println("Estoque: " + produtoA.getQuantidadeEstoque());
        System.out.println("Valor total: R$ " + produtoA.calcularValorTotalEmEstoque());

        System.out.println();

        System.out.println("Produto B:");
        System.out.println("Nome: " + produtoB.getNome());
        System.out.println("Preço: R$ " + produtoB.getPreco());
        System.out.println("Estoque: " + produtoB.getQuantidadeEstoque());

        System.out.println();

        produtoA.setPreco(-10.0);

        System.out.println("Preço atual: R$ " + produtoA.getPreco());
    }
}
