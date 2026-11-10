import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProdutoDAOImpl implements GenericDAO<Produto, Long> {

    private Connection conn;

    public ProdutoDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void salvar(Produto produto) {

        String sql = "INSERT INTO produtos "
                   + "(descricao, precoUnitario, quantidadeEstoque) "
                   + "VALUES (?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(
                sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, produto.getDescricao());
            pstmt.setDouble(2, produto.getPrecoUnitario());
            pstmt.setInt(3, produto.getQuantidadeEstoque());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar produto!", e);
        }
    }

    @Override
    public Optional<Produto> buscarPorId(Long id) {

        String sql = "SELECT * FROM produtos WHERE id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {

                if (rs.next()) {
                    return Optional.of(new Produto(
                        rs.getLong("id"),
                        rs.getString("descricao"),
                        rs.getDouble("precoUnitario"),
                        rs.getInt("quantidadeEstoque")
                    ));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar produto!", e);
        }

        return Optional.empty();
    }

    @Override
    public List<Produto> listarTodos() {

        List<Produto> produtos = new ArrayList<>();

        String sql = "SELECT * FROM produtos";

        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                produtos.add(new Produto(
                    rs.getLong("id"),
                    rs.getString("descricao"),
                    rs.getDouble("precoUnitario"),
                    rs.getInt("quantidadeEstoque")
                ));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar produtos!", e);
        }

        return produtos;
    }

    @Override
    public void atualizar(Produto produto) {

        String sql = "UPDATE produtos SET descricao = ?, "
                   + "precoUnitario = ?, quantidadeEstoque = ? "
                   + "WHERE id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, produto.getDescricao());
            pstmt.setDouble(2, produto.getPrecoUnitario());
            pstmt.setInt(3, produto.getQuantidadeEstoque());
            pstmt.setLong(4, produto.getId());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar produto!", e);
        }
    }

    @Override
    public void deletarPorId(Long id) {

        String sql = "DELETE FROM produtos WHERE id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, id);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar produto!", e);
        }
    }
}
