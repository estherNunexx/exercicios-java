class FiguraGeometrica {

    public double calcularArea() {
        return 0.0;
    }
}

class Quadrado extends FiguraGeometrica {
    double lado;

    public Quadrado(double lado) {
        this.lado = lado;
    }

    @Override
    public double calcularArea() {
        return lado * lado;
    }
}

class Retangulo extends FiguraGeometrica {
    double largura;
    double altura;

    public Retangulo(double largura, double altura) {
        this.largura = largura;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return largura * altura;
    }
}

class Circulo extends FiguraGeometrica {
    double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * raio * raio;
    }
}

public class ClasseFiguraGeometrica {
    public static void main(String[] args) {

        FiguraGeometrica[] figuras = {
            new Quadrado(5),
            new Retangulo(4, 6),
            new Circulo(3)
        };

        for (FiguraGeometrica figura : figuras) {
            System.out.println("Área: " + figura.calcularArea());
        }
    }
}
