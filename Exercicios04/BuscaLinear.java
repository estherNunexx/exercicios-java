import java.util.Scanner;

public class BuscaLinear {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int[] vetor = new int[6];
        int x;
        boolean encontrado = false;
        int posicao = -1;

        for (int i = 0; i < 6; i++) {
            System.out.print("Digite o valor " + (i + 1) + ": ");
            vetor[i] = entrada.nextInt();
        }

        System.out.print("Digite o número que deseja buscar: ");
        x = entrada.nextInt();

        for (int i = 0; i < 6; i++) {
            if (vetor[i] == x) {
            encontrado = true;
            posicao = i;
            break;
            }
        }

        if (encontrado) {
            System.out.println("Número encontrado na posição: " + posicao);
        } else {
            System.out.println("Número não encontrado.");
        }

        entrada.close();
    }
}
