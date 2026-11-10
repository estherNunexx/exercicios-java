import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivroDAOImpl implements LivroDAO {

    private Connection conn;

    public LivroDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Livro> buscarPaginado(int pagina, int tamanhoPagina) {

        List<Livro> livros = new ArrayList<>();

        if (pagina < 1 || tamanhoPagina < 1) {
            throw new IllegalArgumentException("Página ou tamanho inválido!");
        }

        int offset = (pagina - 1) * tamanhoPagina;

        String sql = "SELECT * FROM livros ORDER BY id LIMIT ? OFFSET ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, tamanhoPagina);
            pstmt.setInt(2, offset);

            try (ResultSet rs = pstmt.executeQuery()) {

                while (rs.next()) {

                    Livro livro = new Livro(
                        rs.getLong("id"),
                        rs.getString("titulo"),
                        rs.getString("autor")
                    );

                    livros.add(livro);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar livros!", e);
        }

        return livros;
    }
}
