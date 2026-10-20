import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public class Exercicio2 {

    public static void main(String[] args) {

        try {

            List<Produto> produtos = Arrays.asList(
                    new Produto("Notebook", 3000.00),
                    new Produto("Mouse", 80.00),
                    new Produto("Teclado", 150.00),
                    new Produto("Monitor", 1200.00),
                    new Produto("Fone", 200.00),
                    new Produto("Webcam", 350.00)
            );

            if (produtos == null || produtos.isEmpty()) {
                throw new IllegalStateException(
                        "A lista de produtos está vazia."
                );
            }

            double total = produtos.stream()
                    .mapToDouble(produto -> produto.getPreco())
                    .sum();

            System.out.println("Valor total: R$ " + total);

            OptionalDouble media = produtos.stream()
                    .mapToDouble(produto -> produto.getPreco())
                    .average();

            if (media.isPresent()) {
                System.out.println(
                        "Preço médio: R$ " + media.getAsDouble()
                );
            }

            Optional<Produto> maiorProduto = produtos.stream()
                    .max(Comparator.comparingDouble(Produto::getPreco));

            if (maiorProduto.isPresent()) {
                System.out.println(
                        "Produto mais caro: " + maiorProduto.get()
                );
            }

        } catch (IllegalArgumentException e) {

            System.out.println("Erro: " + e.getMessage());

        } catch (IllegalStateException e) {

            System.out.println("Erro: " + e.getMessage());

        } finally {

            System.out.println("Operação finalizada.");
        }
    }
}
