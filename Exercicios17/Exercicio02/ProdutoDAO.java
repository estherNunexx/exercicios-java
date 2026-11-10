
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class ProdutoDAO {
public List<Produto> buscarPorFaixaPreco(
            Connection conn, double min, double max) throws SQLException {

        List<Produto> produtos = new ArrayList<>();

        String sql = "SELECT id, nome, preco, estoque FROM produtos "
                   + "WHERE preco BETWEEN ? AND ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDouble(1, min);
            pstmt.setDouble(2, max);

            try (ResultSet rs = pstmt.executeQuery()) {

                while (rs.next()) {

                    Produto produto = new Produto(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getDouble("preco"),
                        rs.getInt("estoque")
                    );

            produtos.add(produto);
  }
   }
  }

return produtos;
}
}
