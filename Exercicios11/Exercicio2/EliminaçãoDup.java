import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class EliminaçãoDup {
public static void main(String[] args) {

  Scanner entrada = new Scanner(System.in);

  Set<Integer> turmaA = new HashSet<>();
  Set<Integer> turmaB = new HashSet<>();

        try {
            System.out.println("Digite 5 códigos da Turma A:");

            for (int i = 0; i < 5; i++) {

                System.out.print("Código: ");
                int codigo = Integer.parseInt(entrada.nextLine());

                if (codigo <= 0) {
                throw new IllegalArgumentException(
                "O código deve ser maior que zero."
);
}

    turmaA.add(codigo);
}
        System.out.println("\nDigite 5 códigos da Turma B:");
            for (int i = 0; i < 5; i++) {

        System.out.print("Código: ");
        int codigo = Integer.parseInt(entrada.nextLine());

            if (codigo <= 0) {
            throw new IllegalArgumentException(
            "O código deve ser maior que zero."
);
}

      turmaB.add(codigo);
}

            if (turmaA.isEmpty() || turmaB.isEmpty()) {
            throw new IllegalStateException(
            "Uma das turmas está vazia."
);
}

            Set<Integer> uniao = new HashSet<>(turmaA);
            uniao.addAll(turmaB);

            Set<Integer> intersecao = new HashSet<>(turmaA);
            intersecao.retainAll(turmaB);

            System.out.println("\nTurma A:");
            System.out.println(turmaA);

            System.out.println("\nTurma B:");
            System.out.println(turmaB);

            System.out.println("\nUnião das turmas:");
            System.out.println(uniao);

            System.out.println("\nAlunos nas duas turmas:");
            System.out.println(intersecao);

        } catch (NumberFormatException e) {

            System.out.println("Digite somente números inteiros.");

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
