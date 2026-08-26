import java.util.Scanner;

public class ConverteCelsiusFahrenheit {
    public static void main(String[] args) {
        try (Scanner entrada = new Scanner(System.in)) {

        System.out.print("Digite a temperatura em Celsius: ");
        double celsius = entrada.nextDouble();

        double fahrenheit = (celsius * 1.8) + 32;

        System.out.println("A temperatura em Fahrenheit é: " + fahrenheit);

        entrada.close();
    }
}

}
