import java.util.Scanner;
import java.util.InputMismatchException;

public class Divisao {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Digite o primeiro número: ");
            int n1 = sc.nextInt();

            System.out.print("Digite o segundo número: ");
            int n2 = sc.nextInt();

            int resultado = n1 / n2;

            System.out.println("Resultado: " + resultado);
        }
        catch (ArithmeticException e) {
            System.out.println("Erro: divisão por zero");
        }
        catch (InputMismatchException e) {
            System.out.println("Erro: digite apenas números inteiros");
        }
        finally {
            System.out.println("Operação finalizada");
            sc.close();
        }
    }
}
