abstract class Forma {
    protected String cor;

    public Forma(String cor) {
        this.cor = cor;
    }

    public String getCor() {
        return cor;
    }

    public abstract double calcularArea();

    public void exibirCor() {
        System.out.println("Cor da forma: " + cor);
    }
}

class Retangulo extends Forma {
    double largura;
    double altura;

    public Retangulo(String cor, double largura, double altura) {
        super(cor);
        this.largura = largura;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return largura * altura;
    }
}

class Circulo extends Forma {
    double raio;

    public Circulo(String cor, double raio) {
        super(cor);
        this.raio = raio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * raio * raio;
    }
}

public class ClasseForma {
    public static void main(String[] args) {

        Retangulo retangulo = new Retangulo("Azul", 5, 3);
        Circulo circulo = new Circulo("Vermelho", 4);

        retangulo.exibirCor();
        System.out.println("Área: " + retangulo.calcularArea());

        System.out.println();

        circulo.exibirCor();
        System.out.println("Área: " + circulo.calcularArea());
    }
}
