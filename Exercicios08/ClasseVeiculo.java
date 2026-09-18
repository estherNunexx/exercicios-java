class Veiculo {
    String marca;
    String modelo;

    public Veiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public void exibirDetalhes() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
    }
}

class Carro extends Veiculo {
    int quantidadePortas;

    public Carro(String marca, String modelo, int quantidadePortas) {
        super(marca, modelo);
        this.quantidadePortas = quantidadePortas;
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Quantidade de portas: " + quantidadePortas);
    }
}

class Moto extends Veiculo {
    int cilindradas;

    public Moto(String marca, String modelo, int cilindradas) {
        super(marca, modelo);
        this.cilindradas = cilindradas;
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Cilindradas: " + cilindradas);
    }
}

public class ClasseVeiculo {
    public static void main(String[] args) {

        Carro carro = new Carro("BYD", "Dolff", 4);
        Moto moto = new Moto("Honda", "CB 300f", 300);

        System.out.println("CARRO");
        carro.exibirDetalhes();

        System.out.println();

        System.out.println("MOTO");
        moto.exibirDetalhes();
    }
}
