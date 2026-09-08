class ContaBancaria {
    String titular;
    String numeroConta;
    double saldo = 0;

    void depositar(double valor) {
        if (valor > 0) {
            saldo = saldo + valor;
            System.out.println("Depósito realizado.");
        }
    }

    void sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo = saldo - valor;
            System.out.println("Saque realizado.");
        } else {
            System.out.println("Saldo insuficiente ou valor inválido");
        }
    }

    void consultarSaldo() {
        System.out.println("Saldo atual: R$ " + saldo);
    }
}

public class Main {
    public static void main(String[] args) {

        ContaBancaria conta = new ContaBancaria();

        conta.titular = "João";
        conta.numeroConta = "12345";

        conta.consultarSaldo();

        conta.depositar(1000);
        conta.consultarSaldo();

        conta.sacar(200);
        conta.consultarSaldo();

        conta.sacar(2000);
        conta.consultarSaldo();

        conta.depositar(-50);
        conta.consultarSaldo();
    }
}
