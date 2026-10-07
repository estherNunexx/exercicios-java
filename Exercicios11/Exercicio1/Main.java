import dominio.Tarefa;
import service.GerenciadorTarefasService;
import java.util.Scanner;

public class Main {
public static void main(String[] args) {

    Scanner entrada = new Scanner(System.in);
    GerenciadorTarefasService gerenciador =
    new GerenciadorTarefasService();

    try {
      for (int i = 0; i < 5; i++) {

      System.out.print("Digite a tarefa " + (i + 1) + ": ");
      String nome = entrada.nextLine();

        gerenciador.adicionarTarefa(
        new Tarefa(nome)
);
}

            System.out.println("\nTarefas cadastradas:");
            System.out.println(gerenciador.listarTodas());

            System.out.print("\nDigite uma tarefa para verificar: ");
            String busca = entrada.nextLine();

            if (gerenciador.verificarTarefa(busca)) {
                System.out.println("A tarefa existe.");
            } else {
                System.out.println("A tarefa não existe.");
            }

            System.out.print("\nDigite o índice da tarefa que deseja remover: ");
            int indice = Integer.parseInt(entrada.nextLine());

            gerenciador.removerPorIndice(indice);

            System.out.println("Tarefa removida.");

            gerenciador.ordenar();

            System.out.println("\nLista ordenada:");
            System.out.println(gerenciador.listarTodas());

        } catch (NumberFormatException e) {

            System.out.println("Digite um número válido para o índice.");

        } catch (IllegalArgumentException e) {

            System.out.println("Erro: " + e.getMessage());

        } catch (IndexOutOfBoundsException e) {

            System.out.println("Erro: " + e.getMessage());

        } catch (IllegalStateException e) {

            System.out.println("Erro: " + e.getMessage());

        } finally {

            entrada.close();
            System.out.println("\nOperação finalizada.");
        }
    }
}
