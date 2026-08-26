import java.util.Scanner;

public class ValidadorMaioridade {
    public static void main(String[] args) {
        try (Scanner entrada = new Scanner(System.in)) {

        System.out.print("Digite o ano de nascimento: ");
        int anoNascimento = entrada.nextInt();

        System.out.print("Digite o ano atual: ");
        int anoAtual = entrada.nextInt();

        int idade = anoAtual - anoNascimento;

        if (idade >= 18) {
            System.out.println("É maior de idade");
        } else {
            System.out.println("Não é menor de idade");
        }

        entrada.close();
    }
}

}
