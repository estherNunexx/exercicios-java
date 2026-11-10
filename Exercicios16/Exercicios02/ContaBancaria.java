
public class ContaBancaria {
private double saldo;

    public ContaBancaria(double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double valor) {

        if (valor <= 0) {
            throw new IllegalArgumentException("Valor de depósito inválido!");
        }

        saldo = saldo + valor;
    }

    public void sacar(double valor) {

        if (valor <= 0) {
            throw new IllegalArgumentException("Valor de saque inválido!");
        }

        if (valor > saldo) {
            throw new SaldoInsuficienteException(
                "Saldo insuficiente para realizar o saque!"
            );
        }

        saldo = saldo - valor;
    }

    public double getSaldo() {
        return saldo;
    }
}
