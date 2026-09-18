import java.util.Scanner;

public class Vetor {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] vet = {"10", "25", "abc", "50"};

        try {
            System.out.print("Digite o índice: ");
            int pos = sc.nextInt();

            int numero = Integer.parseInt(vet[pos]);

            System.out.println("Número convertido: " + numero);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Erro: índice inexistente.");
        }
        catch (NumberFormatException e) {
            System.out.println("Erro: o valor não é um número válido.");
        }

        sc.close();
    }
}
