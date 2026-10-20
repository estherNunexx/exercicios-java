import java.util.Arrays;
import java.util.List;

public class Exercicio1 {
public static void main(String[] args) {

    try {
    List<String> nomes = Arrays.asList(
    "ana",
    "carlos",
    "beatriz",
    "antonio",
    "amanda",
    "bernardo"
    );

        if (nomes == null || nomes.isEmpty()) {
            throw new IllegalStateException(
            "A lista de nomes está vazia."
);
    }

        List<String> resultado = nomes.stream()
            .filter(nome -> nome != null
            && nome.toLowerCase().startsWith("a"))
            .map(nome -> nome.toUpperCase())
            .sorted()
            .toList();

        System.out.println(
        "Nomes que começam com A:"
);

        System.out.println(resultado);

    } catch (IllegalStateException e) {

    System.out.println(
    "Erro: " + e.getMessage()
);

        } finally {

        System.out.println(
        "Operação finalizada."
    );
}
    }
}
