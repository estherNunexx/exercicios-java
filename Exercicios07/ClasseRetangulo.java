class Retangulo {
    private double largura;
    private double altura;

    public Retangulo(double largura, double altura) {
        setLargura(largura);
        setAltura(altura);
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        if (largura > 0) {
            this.largura = largura;
        } else {
            this.largura = 1.0;
            System.out.println("Largura inválida");
        }
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        if (altura > 0) {
            this.altura = altura;
        } else {
            this.altura = 1.0;
            System.out.println("Altura inválida");
        }
    }

    public double calcularArea() {
        return largura * altura;
    }

    public double calcularPerimetro() {
        return 2 * (largura + altura);
    }
}

public class ClasseRetangulo {
    public static void main(String[] args) {

        Retangulo retangulo = new Retangulo(5, 3);

        System.out.println("Largura: " + retangulo.getLargura());
        System.out.println("Altura: " + retangulo.getAltura());
        System.out.println("Área: " + retangulo.calcularArea());
        System.out.println("Perímetro: " + retangulo.calcularPerimetro());

        System.out.println();

        Retangulo retangulo2 = new Retangulo(-5, 0);

        System.out.println("Largura: " + retangulo2.getLargura());
        System.out.println("Altura: " + retangulo2.getAltura());
    }
}
