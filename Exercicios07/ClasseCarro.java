class Carro {
    private String modelo;
    private int ano;
    private int velocidadeAtual;

    public Carro(String modelo, int ano) {
        this.modelo = modelo;
        this.ano = ano;
        this.velocidadeAtual = 0;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public int getVelocidadeAtual() {
        return velocidadeAtual;
    }

    public void acelerar(int incremento) {
        velocidadeAtual = velocidadeAtual + incremento;
    }

    public void frear(int decremento) {
        velocidadeAtual = velocidadeAtual - decremento;

        if (velocidadeAtual < 0) {
            velocidadeAtual = 0;
        }
    }

    public boolean isEmMovimento() {
        return velocidadeAtual > 0;
    }
}

public class ClasseCarro {
    public static void main(String[] args) {

        Carro carro = new Carro("BYD dolff", 2026);

        System.out.println("Modelo: " + carro.getModelo());
        System.out.println("Ano: " + carro.getAno());
        System.out.println("Velocidade: " + carro.getVelocidadeAtual());
        System.out.println("Está se movendo? " + carro.isEmMovimento());

        System.out.println();

        carro.acelerar(50);

        System.out.println("Depois de acelerar:");
        System.out.println("Velocidade: " + carro.getVelocidadeAtual());
        System.out.println("Está se movendo? " + carro.isEmMovimento());

        System.out.println();

        carro.frear(20);

        System.out.println("Depois de frear:");
        System.out.println("Velocidade: " + carro.getVelocidadeAtual());

        System.out.println();

        carro.frear(50);

        System.out.println("Depois de frear de novo:");
        System.out.println("Velocidade: " + carro.getVelocidadeAtual());
        System.out.println("Está se movendo? " + carro.isEmMovimento());
    }
}
