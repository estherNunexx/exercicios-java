
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAOImpl implements AlunoDAO {

    private Connection conn;

    public AlunoDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void inserir(Aluno aluno) {

        String sql = "INSERT INTO alunos (nome, matricula) VALUES (?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(
                sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, aluno.getNome());
            pstmt.setString(2, aluno.getMatricula());

            pstmt.executeUpdate();

            try (ResultSet rs = pstmt.getGeneratedKeys()) {

                if (rs.next()) {
                    aluno.setId(rs.getLong(1));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir aluno!", e);
        }
    }

    @Override
    public List<Aluno> listarTodos() {

        List<Aluno> alunos = new ArrayList<>();

        String sql = "SELECT id, nome, matricula FROM alunos";

        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {

                Aluno aluno = new Aluno(
                    rs.getLong("id"),
                    rs.getString("nome"),
                    rs.getString("matricula")
                );

                alunos.add(aluno);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar alunos!", e);
        }

        return alunos;
    }
}
