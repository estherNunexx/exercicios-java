class SaldoInsuficienteException extends Exception {

    public SaldoInsuficienteException(String mensagem) {
        super(mensagem);
    }
}

class ContaCorrente {

    private String numero;
    private double saldo;

    public ContaCorrente(String numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    public void sacar(double valor) throws SaldoInsuficienteException {

        if (valor > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente para realizar o saque.");
        }

        saldo = saldo - valor;

        System.out.println("Saque realizado.");
        System.out.println("Saldo atual: " + saldo);
    }
}

public class CustomizadaVerificada {
    public static void main(String[] args) {

        ContaCorrente conta = new ContaCorrente("12345", 500.0);

        try {
            conta.sacar(200.0);
            conta.sacar(400.0);
        }
        catch (SaldoInsuficienteException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
