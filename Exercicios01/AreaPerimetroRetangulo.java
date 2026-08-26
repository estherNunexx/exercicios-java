import java.util.Scanner;

public class AreaPerimetroRetangulo {
    public static void main(String[] args) {
          try (Scanner entrada = new Scanner(System.in)) {

        System.out.print("Digite a base do retângulo: ");
        double base = entrada.nextDouble();

        System.out.print("Digite a altura do retângulo: ");
        double altura = entrada.nextDouble();

        double area = base * altura;
        double perimetro = 2 * (base + altura);

        System.out.println("Área: " + area);
        System.out.println("Perímetro: " + perimetro);

        entrada.close();
    }
}

}
