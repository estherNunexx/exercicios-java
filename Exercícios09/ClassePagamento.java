interface MetodoPagamento {
    void processarPagamento(double valor);
    String obterDetalhes();
}

class CartaoCredito implements MetodoPagamento {
    String numeroCartao;
    double limite;

    public CartaoCredito(String numeroCartao, double limite) {
        this.numeroCartao = numeroCartao;
        this.limite = limite;
    }

    public void processarPagamento(double valor) {
        if (valor <= limite) {
            limite = limite - valor;
            System.out.println("Pagamento com cartão realizado!");
        } else {
            System.out.println("Limite insuficiente!");
        }
    }

    public String obterDetalhes() {
        return "Cartão de Crédito : Número: " + numeroCartao;
    }
}

class Pix implements MetodoPagamento {
    String chavePix;

    public Pix(String chavePix) {
        this.chavePix = chavePix;
    }

    public void processarPagamento(double valor) {
        System.out.println("Pagamento via Pix realizado!");
    }

    public String obterDetalhes() {
        return "Pix : Chave: " + chavePix;
    }
}

public class ClassePagamento {
    public static void finalizarCompra(MetodoPagamento metodo, double total) {
        System.out.println(metodo.obterDetalhes());
        metodo.processarPagamento(total);
    }

    public static void main(String[] args) {

        MetodoPagamento cartao = new CartaoCredito("123456789", 1000);
        MetodoPagamento pix = new Pix("pix@email.com");

        finalizarCompra(cartao, 300);
        System.out.println();

        finalizarCompra(pix, 150);
    }
}
