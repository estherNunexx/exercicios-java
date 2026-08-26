import java.util.Scanner;

public class ParOuImpar {
    public static void main(String[] args) {
       try (Scanner entrada = new Scanner(System.in)) {
        System.out.print("Digite um número inteiro: ");
        int numero = entrada.nextInt();

        if (numero % 2 == 0) {
            System.out.println("O número é par");
        } else {
            System.out.println("O número é ímpar");
        }

        entrada.close();
    }
}

}
