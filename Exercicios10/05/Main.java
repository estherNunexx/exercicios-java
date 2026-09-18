public class Main {
    public static void main(String[] args) {

        Servico servico = new Servico();

        try {
            servico.processarArquivo("");
        }
        catch (ProcessamentoDadosException e) {
            System.out.println("Erro: " + e.getMessage());
            System.out.println("Causa: " + e.getCause().getMessage());
        }
    }
}
