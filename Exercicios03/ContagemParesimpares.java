import java.util.Scanner;

public class ContagemParesimpares {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int A, B;
        int pares = 0;
        int impares = 0;

        System.out.print("Digite o valor de A: ");
        A = entrada.nextInt();

        System.out.print("Digite o valor de B: ");
        B = entrada.nextInt();

        for (int i = A; i <= B; i++) {
            if (i % 2 == 0) {
                pares++;
            } else {
                impares++;
            }
        }

        System.out.println("Quantidade de números pares: " + pares);
        System.out.println("Quantidade de números ímpares: " + impares);

        entrada.close();
    }
}
