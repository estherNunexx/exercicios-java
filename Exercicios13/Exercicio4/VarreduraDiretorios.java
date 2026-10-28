import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class VarreduraDiretorios {
public static void main(String[] args) {

        Path projeto = Path.of("projeto");
        long totalBytes = 0;

        try (Stream<Path> arquivos = Files.walk(projeto)) {
            try {
                totalBytes = arquivos
                        .filter(Files::isRegularFile)
                        .filter(path ->
                                path.toString().endsWith(".java"))
                        .mapToLong(path -> {

                            try {
                                long tamanho =
                                        Files.size(path);

                                System.out.println(
                                        projeto.relativize(path)
                                                + " - "
                                                + tamanho
                                                + " bytes"
                                );

                                return tamanho;

                            } catch (IOException e) {
                                System.out.println(
                                        "Não foi possível obter o tamanho de: "
                                                + path
                                );

                                return 0;
                            }
                        })
                        .sum();

                System.out.println(
                        "\nTamanho total dos arquivos Java: "
                                + totalBytes
                                + " bytes"
                );

            } catch (Exception e) {

                System.out.println(
                        "Erro durante a leitura: "
                                + e.getMessage()
                );
            }

        } catch (IOException e) {

            System.out.println(
                    "Erro ao acessar o diretório: "
                            + e.getMessage()
            );
        }
    }
}
