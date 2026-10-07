
public class Tarefa {

    private String nome;
    public Tarefa(String nome) {

    if (nome == null || nome.trim().isEmpty()) {
        throw new IllegalArgumentException("O nome da tarefa não pode ser vazio.");
  }

        this.nome = nome.trim();
  }
    public String getNome() {
        return nome;
 }

    @Override
    public String toString() {
        return nome;
    }
}
