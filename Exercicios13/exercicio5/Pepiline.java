import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Pepiline {

    public static void main(String[] args) {

        Path arquivoEntrada =
                Path.of("clientes_bruto.txt");

        Path arquivoSaida =
                Path.of("clientes_padronizado.txt");

        try (Stream<String> linhas =
                     Files.lines(arquivoEntrada)) {

            List<String> clientes = linhas
                    .map(String::trim)
                    .filter(linha -> !linha.isBlank())
                    .map(Exercicio5::padronizarNome)
                    .collect(Collectors.toList());

            Files.write(
                    arquivoSaida,
                    clientes,
                    StandardOpenOption.CREATE
            );

            System.out.println(
                    "Arquivo padronizado criado com sucesso."
            );

        } catch (IOException e) {

            System.out.println(
                    "Erro ao processar os arquivos: "
                            + e.getMessage()
            );
        }
    }

    public static String padronizarNome(String nome) {

        String nomeMinusculo =
                nome.toLowerCase();

        return nomeMinusculo.substring(0, 1).toUpperCase()
                + nomeMinusculo.substring(1);
    }
}
