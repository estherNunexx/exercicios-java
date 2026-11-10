
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProcessadorPagamentoServiceTest {

    @Mock
    GatewayPagamento gateway;

    @Mock
    PedidoRepository pedidoRepository;

    @InjectMocks
    ProcessadorPagamentoService service;

    @Test
    public void testarPagamentoComSucesso() {

        Pedido pedido = new Pedido(200.00);

        service.processar(pedido);

        assertEquals("PAGO", pedido.getStatus());

        verify(gateway, times(1)).cobrar(200.00);

        verify(pedidoRepository, times(1)).atualizar(pedido);
    }

    @Test
    public void testarPagamentoRecusado() {

        Pedido pedido = new Pedido(200.00);

        doThrow(new PagamentoRecusadoException())
            .when(gateway).cobrar(anyDouble());

        assertThrows(
            PagamentoRecusadoException.class,
            () -> service.processar(pedido)
        );

        assertEquals("PENDENTE", pedido.getStatus());

        verify(pedidoRepository, never()).atualizar(any());
    }
}
