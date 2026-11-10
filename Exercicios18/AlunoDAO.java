import java.util.List;

public interface AlunoDAO {

    void inserir(Aluno aluno);

    List<Aluno> listarTodos();
}
