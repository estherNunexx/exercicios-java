
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContaBancariaTest {

    ContaBancaria conta;

    @BeforeEach
    public void configurarConta() {
        conta = new ContaBancaria(1000.00);
    }

    @Test
    public void testarDeposito() {

        conta.depositar(200.00);

        assertEquals(1200.00, conta.getSaldo(), 0.001);
    }

    @Test
    public void testarSaque() {

        conta.sacar(300.00);

        assertEquals(700.00, conta.getSaldo(), 0.001);
    }

    @Test
    public void testarSaqueInvalido() {

        assertThrows(
            IllegalArgumentException.class,
            () -> conta.sacar(0)
        );
    }

    @Test
    public void testarSaldoInsuficiente() {

        SaldoInsuficienteException erro = assertThrows(
            SaldoInsuficienteException.class,
            () -> conta.sacar(1500.00)
        );

        assertEquals(
            "Saldo insuficiente para realizar o saque!",
            erro.getMessage()
        );
    }
}
