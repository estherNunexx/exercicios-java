package View;
import Controller.PessoaController;
import Model.Pessoa;
import java.util.Scanner;

public class PessoaView {

private Scanner entrada = new Scanner(System.in);
private PessoaController controller;

    public PessoaView(PessoaController controller) {
        this.controller = controller;
    }

    public void iniciar() {

        int opcao = -1;

        while (opcao != 0) {

            System.out.println("\n===== CADASTRO DE PESSOAS =====");
            System.out.println("1 - Incluir pessoa");
            System.out.println("2 - Listar pessoas");
            System.out.println("3 - Alterar pessoa");
            System.out.println("4 - Excluir pessoa");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            try {
                opcao = Integer.parseInt(entrada.nextLine());

                switch (opcao) {

                    case 1:
                        incluir();
                        break;

                    case 2:
                        listar();
                        break;

                    case 3:
                        alterar();
                        break;

                    case 4:
                        excluir();
                        break;

                    case 0:
                        System.out.println("Programa encerrado!");
                        break;

                    default:
                        System.out.println("Opção inválida!");
                }

            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido!");
            }
        }
    }

    private void incluir() {

        try {
            System.out.print("ID: ");
            int id = Integer.parseInt(entrada.nextLine());

            System.out.print("Nome: ");
            String nome = entrada.nextLine();

            System.out.print("Idade: ");
            int idade = Integer.parseInt(entrada.nextLine());

            System.out.print("Altura: ");
            double altura = Double.parseDouble(entrada.nextLine().replace(",", "."));

            if (nome.trim().isEmpty() || idade <= 0 || altura <= 0) {
                throw new IllegalArgumentException("Dados inválidos!");
            }

            Pessoa pessoa = new Pessoa(id, nome, idade, altura);

            controller.incluir(pessoa);

            System.out.println("Pessoa cadastrada!");

        } catch (NumberFormatException e) {
            System.out.println("Digite valores numéricos válidos!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void listar() {

        for (Pessoa p : controller.listar()) {

            System.out.println("\nID: " + p.getId());
            System.out.println("Nome: " + p.getNome());
            System.out.println("Idade: " + p.getIdade());
            System.out.println("Altura: " + p.getAltura());
        }

        if (controller.listar().isEmpty()) {
            System.out.println("Nenhuma pessoa cadastrada.");
        }
    }

    private void alterar() {

        try {
            System.out.print("Digite o ID da pessoa: ");
            int id = Integer.parseInt(entrada.nextLine());

            System.out.print("Novo nome: ");
            String nome = entrada.nextLine();

            System.out.print("Nova idade: ");
            int idade = Integer.parseInt(entrada.nextLine());

            System.out.print("Nova altura: ");
            double altura = Double.parseDouble(entrada.nextLine().replace(",", "."));

            if (nome.trim().isEmpty() || idade <= 0 || altura <= 0) {
                throw new IllegalArgumentException("Dados inválidos!");
            }
            if (controller.alterar(id, nome, idade, altura)) {
                System.out.println("Pessoa alterada!");
            } else {
                System.out.println("Pessoa não encontrada!");
            }

        } catch (NumberFormatException e) {
            System.out.println("Digite valores numéricos válidos!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    private void excluir() {

        try {
            System.out.print("Digite o ID da pessoa: ");
            int id = Integer.parseInt(entrada.nextLine());

            if (controller.excluir(id)) {
                System.out.println("Pessoa excluída!");
            } else {
                System.out.println("Pessoa não encontrada!");
            }
        } catch (NumberFormatException e) {
            System.out.println("ID inválido!");
  }
  }
}
