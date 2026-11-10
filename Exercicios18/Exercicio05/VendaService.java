import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class VendaService {

    private PedidoDAO pedidoDAO;
    private ItemPedidoDAO itemPedidoDAO;

    public VendaService(PedidoDAO pedidoDAO, ItemPedidoDAO itemPedidoDAO) {
        this.pedidoDAO = pedidoDAO;
        this.itemPedidoDAO = itemPedidoDAO;
    }

    public void registrarVenda(Pedido pedido, List<ItemPedido> itens) {

        try (Connection conn = ConnectionFactory.getConnection()) {

            boolean autoCommitOriginal = conn.getAutoCommit();

            conn.setAutoCommit(false);

            try {

                long pedidoId = pedidoDAO.criarPedido(conn, pedido);

                itemPedidoDAO.salvarItens(conn, pedidoId, itens);

                conn.commit();

                System.out.println("Venda registrada com sucesso!");

            } catch (SQLException | RuntimeException erro) {

                conn.rollback();

                throw new RuntimeException("Erro ao registrar venda!", erro);

            } finally {

                conn.setAutoCommit(autoCommitOriginal);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro na conexão ou transação!", e);
        }
    }
}
