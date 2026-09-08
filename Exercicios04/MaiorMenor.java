import java.util.Scanner;

public class MaiorMenor {
public static void main(String[] args) {
   Scanner entrada = new Scanner(System.in);
      
        int[] vetor = new int[10];

        for (int i = 0; i < 10; i++) {
            System.out.print("Digite o valor " + (i + 0) + ": ");
            vetor[i] = entrada.nextInt();
        }
        int maior = vetor[0];
        int menor = vetor[0];
        int posMaior = 0;
        int posMenor = 0;

        for (int i = 1; i < 10; i++) {
            if (vetor[i] > maior) {
                maior = vetor[i];
                posMaior = i;
            }

            if (vetor[i] < menor) {
                menor = vetor[i];
                posMenor = i;
            }
        }
        System.out.println("Maior valor: " + maior);
        System.out.println("Índice do maior: " + posMaior);
        System.out.println("Menor valor: " + menor);
        System.out.println("Índice do menor: " + posMenor);
        entrada.close();
    }
}
