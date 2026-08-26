import java.util.Scanner;

public class CalculaSalario {
    public static void main(String[] args) {
        try (Scanner entrada = new Scanner(System.in)) {

        System.out.print("Digite o valor da hora de trabalho: ");
        double valorHora = entrada.nextDouble();

        System.out.print("Digite a quantidade de horas trabalhadas: ");
        double horasTrabalhadas = entrada.nextDouble();

        double salarioBruto = valorHora * horasTrabalhadas;
        double descontoInss = salarioBruto * 0.10;
        double salarioLiquido = salarioBruto - descontoInss;

        System.out.printf("Salário Bruto: R$ %.2f%n", salarioBruto);
        System.out.printf("Salário Líquido: R$ %.2f%n", salarioLiquido);

        entrada.close();
    }
}

}
