import java.util.Scanner;

public class Senha {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int senha;
        int senhaCorreta = 2026;

        do {
            System.out.print("Digite a senha: ");
            senha = entrada.nextInt();

            if (senha != senhaCorreta) {
                System.out.println("Senha Incorreta! Tente novamente.");
            }

        } while (senha != senhaCorreta);

        System.out.println("Acesso Permitido!");

        entrada.close();
    }
}
