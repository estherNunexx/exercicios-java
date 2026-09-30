import java.util.Scanner;

public class array {
public static void main(String[] args) {

int[] notas = {8, 7, 9, 10, 6};

    try (Scanner entrada = new Scanner(System.in)) {

    try {

        System.out.print("Digite uma posição: ");
        int posicao = entrada.nextInt();

        System.out.println("Valor encontrado: " + notas[posicao]);

  } catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("Essa posição não existe no array.");
      
   }  
  }
 }
}
