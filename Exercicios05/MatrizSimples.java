import java.util.Scanner;

public class MatrizSimples {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int[][] matriz = new int[3][3];

        for (int i = 0; i < 3; i++) {
    for (int j = 0; j < 3; j++) {
            System.out.print("Digite o valor [" + i + "][" + j + "]: ");
            matriz[i][j] = entrada.nextInt();
            }
        }

        System.out.println("Matriz:");

        for (int i = 0; i < 3; i++) {
          for (int j = 0; j < 3; j++) {
            System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        entrada.close();
    }
}
