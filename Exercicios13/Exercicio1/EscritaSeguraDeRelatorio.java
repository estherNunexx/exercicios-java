import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

public class EscritaSeguraDeRelatorio {

    public static void main(String[] args) {

        Path diretorio = Path.of(
                "dados",
                "relatorios"
        );

        Path arquivo = Path.of(
                "dados",
                "relatorios",
                "sumario.txt"
        );

        String texto = """
                RELATÓRIO DE EXECUÇÃO
                Sistema executado com sucesso!
                Data e hora: %s
                """.formatted(LocalDateTime.now());

        try {

            Files.createDirectories(diretorio);

            Files.writeString(
                    arquivo,
                    texto,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING
            );

            System.out.println(
                    "Relatório criado em: " + arquivo
            );

        } catch (IOException e) {

            System.out.println(
                    "Erro ao criar ou escrever o relatório: "
                            + e.getMessage()
            );
        }
    }
}
