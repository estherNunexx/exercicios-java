import java.io.IOException;

public class Servico {

    public void processarArquivo(String caminho) throws ProcessamentoDadosException {

        try {

            if (caminho == null || caminho.isEmpty()) {
                throw new IOException("Caminho do arquivo inválido.");
            }

            int numero = Integer.parseInt("abc");

            System.out.println("Número: " + numero);
        }
        catch (Exception e) {
            throw new ProcessamentoDadosException(
                "Erro ao processar o arquivo.",
                e
            );
        }
    }
}
