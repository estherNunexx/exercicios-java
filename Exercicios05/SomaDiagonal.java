import java.util.Scanner;

public class SomaDiagonal {
public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);

        double[][] matriz = new double[4][4];
        double soma = 0;

    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++) {
          System.out.print("Digite o valor [" + i + "][" + j + "]: ");
           matriz[i][j] = entrada.nextDouble();
            }
        }

        for (int i = 0; i < 4; i++) {
            soma = soma + matriz[i][i];
        }

        System.out.println("Soma da diagonal principal: " + soma);
        etrada.close();
    }
}
