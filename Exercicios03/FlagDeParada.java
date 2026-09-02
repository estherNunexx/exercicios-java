import java.util.Scanner;

public class FlagDeParada {
public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);

int numero;
int quantidade = 0;
int soma = 0;
int media;

    System.out.print("Digite um número: ");
    numero = entrada.nextInt();

    while (numero >= 0) {
        soma = soma + numero;
        quantidade++;

        System.out.print("Digite outro número ou negativo para parar: ");
        numero = entrada.nextInt();
        }

        if (quantidade > 0) {
        media =(int) soma /quantidade;

        System.out.println("\nQuantidade de números: " + quantidade);
        System.out.println("Soma total: " + soma);
        System.out.println("Média: " + media);
        } else {
    System.out.print("\nNenhum número positivo foi digitado.");
        }

        entrada.close();
    }
}
