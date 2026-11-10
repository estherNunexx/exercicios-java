
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class ClienteDAO {
  public void inserirCliente(Connection conn, String nome, String email)
            throws SQLException {

  String sql = "INSERT INTO clientes (nome, email) VALUES (?, ?)";

try (PreparedStatement pstmt = conn.prepareStatement(
                sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, nome);
            pstmt.setString(2, email);

            pstmt.executeUpdate();

try (ResultSet rs = pstmt.getGeneratedKeys()) {

          if (rs.next()) {
                    System.out.println("ID gerado: " + rs.getLong(1));
      }
      }
  }
}
}
