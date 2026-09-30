import java.util.Scanner;

public class idadeString {
public static void main(String[] args) {

try (Scanner entrada = new Scanner(System.in)) {

    try {

        System.out.print("Digite sua idade em números: ");
        String idade = entrada.nextLine();

        int idadeNumero = Integer.parseInt(idade);

        System.out.println("Sua idade é: " + idadeNumero);

} catch (NumberFormatException e) {

    System.out.println("Entrada inválida! Digite sua idade usando apenas números.");
    
    }
   }
  }
 } 
