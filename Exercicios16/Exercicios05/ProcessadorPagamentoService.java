public class ProcessadorPagamentoService {

    private GatewayPagamento gateway;
    private PedidoRepository pedidoRepository;

    public ProcessadorPagamentoService(
        GatewayPagamento gateway,
        PedidoRepository pedidoRepository
    ) {
        this.gateway = gateway;
        this.pedidoRepository = pedidoRepository;
    }

    public void processar(Pedido pedido) {

        gateway.cobrar(pedido.getValor());

        pedido.setStatus("PAGO");

        pedidoRepository.atualizar(pedido);
    }
}
