import java.util.InputMismatchException;
import java.util.Scanner;

public class trycath_Calculadora {

    public static void main(String[] args) {

    try (Scanner entrada = new Scanner(System.in)) {

    try {

        System.out.print("Digite o primeiro número: ");
        int numero1 = entrada.nextInt();

        System.out.print("Digite o segundo número: ");
        int numero2 = entrada.nextInt();

        System.out.print("Operação desejada (+, -, *, /): ");
        String operacao = entrada.next();

        int resultado;

        switch (operacao) {

        case "+":
            resultado = numero1 + numero2;
            System.out.println("Resultado: " + resultado);
            break;

        case "-":
            resultado = numero1 - numero2;
            System.out.println("Resultado: " + resultado);
            break;

        case "*":
            resultado = numero1 * numero2;
            System.out.println("Resultado: " + resultado);
            break;

        case "/":
            resultado = numero1 / numero2;
            System.out.println("Resultado: " + resultado);
            break;

            default:
            System.out.println("Operação inexistente.");
}

    } catch (InputMismatchException e) {

      System.out.println("Entrada inválida! Digite apenas números inteiros ");

    } catch (ArithmeticException e) {

      System.out.println("Não é possível dividir por zero!");
   }
  } 
 }
}
