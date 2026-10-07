import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ControleEstoque {
public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        HashMap<String, Integer> estoque = new HashMap<>();

        try {
            estoque.put("A01", 10);
            estoque.put("A02", 3);
            estoque.put("A03", 0);
            estoque.put("A04", 8);

            if (estoque.isEmpty()) {
                throw new IllegalStateException(
                        "O estoque está vazio."
                );
            }

            System.out.println("Estoque atual:");
            System.out.println(estoque);

            System.out.print("\nDigite o código do produto: ");
            String codigo = entrada.nextLine();

            if (codigo == null || codigo.trim().isEmpty()) {
                throw new IllegalArgumentException(
                        "O código não pode ser vazio."
                );
            }

            codigo = codigo.trim();

            if (!estoque.containsKey(codigo)) {
                throw new IllegalArgumentException(
                        "Produto não encontrado."
                );
            }

            System.out.print(
                    "Digite a quantidade para adicionar/remover: "
            );

            int quantidade = Integer.parseInt(
                    entrada.nextLine()
            );

            int novaQuantidade =
                    estoque.get(codigo) + quantidade;

            if (novaQuantidade < 0) {
                throw new IllegalArgumentException(
                        "O estoque não pode ficar negativo."
                );
            }

            estoque.put(codigo, novaQuantidade);

            System.out.println("\nEstoque atualizado:");
            System.out.println(estoque);

            System.out.println(
                    "\nProdutos com estoque abaixo de 5:"
            );

            for (Map.Entry<String, Integer> item
                    : estoque.entrySet()) {

                if (item.getValue() < 5) {

                    System.out.println(
                            item.getKey()
                                    + " = "
                                    + item.getValue()
                    );
                }
            }

        } catch (NumberFormatException e) {

            System.out.println(
                    "Digite uma quantidade usando números."
            );

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
