import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ProdutosCSV {
public static void main(String[] args) {

        Path arquivo = Path.of("produtos.csv");
        double totalGeral = 0;

        try {
            List<String> linhas = Files.readAllLines(arquivo);

            for (int i = 1; i < linhas.size(); i++) {
                String linha = linhas.get(i);
                if (linha.trim().isEmpty()) {
                    continue;
                }
                String[] campos = linha.split(",");

                if (campos.length != 3) {
                    System.out.println(
                            "Linha com formato inválido: "
                                    + linha
                    );
                    continue;
                }
                String nome = campos[0];
                int quantidade =
                        Integer.parseInt(campos[1]);

                double preco =
                        Double.parseDouble(campos[2]);
                double total = quantidade * preco;

                totalGeral += total;
                System.out.printf(
                        "%s - Total: R$ %.2f%n",
                        nome,
                        total
                );
            }
            System.out.printf(
                    "%nValor global do inventário: R$ %.2f%n",
                    totalGeral
            );

        } catch (NumberFormatException e) {
            System.out.println(
                    "Erro: existe um número inválido no arquivo!"
            );

        } catch (IOException e) {
            System.out.println(
                    "Erro ao ler o arquivo: "
                            + e.getMessage()
            );
        }
    }
}
