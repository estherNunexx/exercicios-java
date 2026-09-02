import java.util.Scanner;

public class SituacaoAluno {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite a primeira nota: ");
        double nota1 = entrada.nextDouble();

        System.out.print("Digite a segunda nota: ");
        double nota2 = entrada.nextDouble();

        double media = (nota1 + nota2) / 2;

        System.out.println("Média: " + media);

        if (media >= 7.0) {
            System.out.println("Aluno aprovado.");
        } else if (media >= 5.0) {
            System.out.println("Aluno em recuperação.");
        } else {
            System.out.println("Aluno reprovado.");
        }

        entrada.close();
    }
}
