import java.util.Scanner;

public class SomaPorLinha {
public static void main(String[] args) {
Scanner entrada = new Scanner(System.in);

  int[][] matriz = new int[4][3];
  int[] somaLinhas = new int[4];

    for (int i = 0; i < 4; i++) {
        int soma = 0;

            for (int j = 0; j < 3; j++) {
                System.out.print("Digite o valor [" + i + "][" + j + "]: ");
                matriz[i][j] = entrada.nextInt();
              
              soma = soma + matriz[i][j];
            }
          somaLinhas[i] = soma;
        }

  System.out.println("Soma de cada linha:");

  for (int i = 0; i < 4; i++) {
        System.out.println("Linha " + i + ": " + somaLinhas[i]);
        }

        entrada.close();
    }
}
