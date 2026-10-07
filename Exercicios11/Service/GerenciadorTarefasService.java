package Service;
import dominio.Tarefa;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GerenciadorTarefasService {

    private final List<Tarefa> tarefas;

    public GerenciadorTarefasService() {
    tarefas = new ArrayList<>();
    }

    public void adicionarTarefa(Tarefa tarefa) {

        if (tarefa == null) {
            throw new IllegalArgumentException("A tarefa não pode ser nula.");
        }

        tarefas.add(tarefa);
    }

    public void removerPorIndice(int indice) {

        if (tarefas.isEmpty()) {
            throw new IllegalStateException("A lista de tarefas está vazia.");
        }

        if (indice < 0 || indice >= tarefas.size()) {
            throw new IndexOutOfBoundsException("Índice inválido.");
        }

        tarefas.remove(indice);
    }
    public void removerPorNome(String nome) {

        if (tarefas.isEmpty()) {
            throw new IllegalStateException("A lista de tarefas está vazia.");
        }

        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome da tarefa não pode ser vazio.");
        }

        boolean removeu = tarefas.removeIf(
            tarefa -> tarefa.getNome().equalsIgnoreCase(nome.trim())
        );

        if (!removeu) {
            throw new IllegalArgumentException("Tarefa não encontrada.");
        }
    }

    public boolean verificarTarefa(String nome) {

        if (tarefas.isEmpty()) {
            throw new IllegalStateException("A lista de tarefas está vazia.");
        }

        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser vazio.");
        }

        return tarefas.stream().anyMatch(
            tarefa -> tarefa.getNome().equalsIgnoreCase(nome.trim())
        );
    }

    public void ordenar() {

        if (tarefas.isEmpty()) {
            throw new IllegalStateException("Não é possível ordenar uma lista vazia.");
        }

        Collections.sort(
            tarefas,
            (t1, t2) -> t1.getNome().compareToIgnoreCase(t2.getNome())
        );
    }
    public List<Tarefa> listarTodas() {
        return new ArrayList<>(tarefas);
    }
    public int getQuantidade() {
        return tarefas.size();
    }
}
