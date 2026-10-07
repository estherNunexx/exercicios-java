import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Dicionariofreq {
public static void main(String[] args) {

Scanner entrada = new Scanner(System.in);
HashMap<String, Integer> frequencia = new HashMap<>();

    try {
      System.out.print("Digite uma frase: ");
      String texto = entrada.nextLine();

    if (texto == null || texto.trim().isEmpty()) {
        throw new IllegalArgumentException(
        "O texto não pode ser vazio."
    );
    }

        String[] palavras = texto
            .toLowerCase()
            .trim()
            .split("\\s+");

      if (palavras.length == 0) {
          throw new IllegalStateException(
          "Nenhuma palavra foi encontrada."
);
}

        for (String palavra : palavras) {

              requencia.put(
                  palavra,
                  frequencia.getOrDefault(palavra, 0) + 1
);
} 
          if (frequencia.isEmpty()) {
             throw new IllegalStateException(
              "O mapa de frequência está vazio."
);
}

System.out.println("\nFrequência das palavras:");

            for (Map.Entry<String, Integer> item
                    : frequencia.entrySet()) {

                System.out.println(
                        item.getKey() + " = " + item.getValue()
                );
            }

        } catch (IllegalArgumentException e) {

            System.out.println("Erro: " + e.getMessage());

        } catch (IllegalStateException e) {

            System.out.println("Erro: " + e.getMessage());

        } finally {

            entrada.close();
            System.out.println("\nOperação finalizada.");
        }
    }
}
