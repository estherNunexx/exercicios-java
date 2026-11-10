import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContaDAO {
    public void transferirFundos(
            Connection conn, Long idOrigem, Long idDestino, double valor)
            throws SQLException {

        if (valor <= 0) {
            throw new IllegalArgumentException("Valor inválido!");
        }

        boolean autoCommitOriginal = conn.getAutoCommit();

        conn.setAutoCommit(false);

        try {

            String sqlDebito = "UPDATE contas SET saldo = saldo - ? "
                             + "WHERE id = ? AND saldo >= ?";

            try (PreparedStatement pstmt = conn.prepareStatement(sqlDebito)) {

                pstmt.setDouble(1, valor);
                pstmt.setLong(2, idOrigem);
                pstmt.setDouble(3, valor);

                int linhas = pstmt.executeUpdate();

                if (linhas == 0) {
                    throw new SQLException(
                        "Saldo insuficiente ou conta de origem não encontrada!"
                    );
                }
            }

            String sqlCredito = "UPDATE contas SET saldo = saldo + ? "
                              + "WHERE id = ?";

            try (PreparedStatement pstmt = conn.prepareStatement(sqlCredito)) {

                pstmt.setDouble(1, valor);
                pstmt.setLong(2, idDestino);

                int linhas = pstmt.executeUpdate();

                if (linhas == 0) {
                    throw new SQLException(
                        "Conta de destino não encontrada!"
                    );
                }
            }

            conn.commit();

            System.out.println("Transferência realizada com sucesso!");

        } catch (SQLException | RuntimeException erro) {

        conn.rollback();

        throw erro;

    } finally {

    conn.setAutoCommit(autoCommitOriginal);

    }
}
