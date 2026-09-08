import java.util.Scanner;

public class fatorial {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int n;
        long fatorial = 1;

        System.out.print("Digite um número inteiro: ");
        n = entrada.nextInt();

        for (int i = 1; i <= n; i++) {
            fatorial = fatorial * i;
        }

        System.out.println("Fatorial de " + n + ": " + fatorial);

        entrada.close();
    }
}
