import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LeituraLinha {

    public static void main(String[] args) {

        Path arquivo = Path.of("servidor.log");

        try (Stream<String> linhas = Files.lines(arquivo)) {

            List<String> erros = linhas
                    .filter(linha -> linha.startsWith("[ERROR]"))
                    .map(linha -> linha.replace("[ERROR] ", ""))
                    .collect(Collectors.toList());

            System.out.println(
                    "Total de erros: " + erros.size()
            );

            System.out.println("\nMensagens de erro:");

            erros.forEach(System.out::println);

        } catch (IOException e) {

            System.out.println(
                    "Erro ao ler o arquivo: "
                            + e.getMessage()
            );
        }
    }
}
