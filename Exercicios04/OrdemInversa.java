import java.util.Scanner;

public class OrdemInversa {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int[] vetor = new int[5];

        for (int i = 0; i < 5; i++) {
            System.out.print("Digite o valor " + (i + 1) + ": ");
            vetor[i] = entrada.nextInt();
        }

        System.out.println("Valores na ordem inversa:");

        for (int i = 4; i >= 0; i--) {
            System.out.println(vetor[i]);
        }

        entrada.close();
    }
}
