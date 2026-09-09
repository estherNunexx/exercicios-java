class ContaBancaria {
    private String numeroConta;
    private String titular;
    private double saldo;

    public ContaBancaria(String numeroConta, String titular) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = 0;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo = saldo + valor;
            System.out.println("Depósito realizado.");
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo = saldo - valor;
            System.out.println("Saque realizado.");
        } else {
            System.out.println("Saldo insuficiente ou valor inválido.");
        }
    }
}

public class ClasseContaBancaria {
    public static void main(String[] args) {

        ContaBancaria conta = new ContaBancaria("12345", "Maria");

        System.out.println("Conta: " + conta.getNumeroConta());
        System.out.println("Titular: " + conta.getTitular());
        System.out.println("Saldo inicial: R$ " + conta.getSaldo());

        System.out.println();

        conta.depositar(1000);
        System.out.println("Saldo: R$ " + conta.getSaldo());

        conta.sacar(200);
        System.out.println("Saldo: R$ " + conta.getSaldo());

        conta.sacar(1000);
        System.out.println("Saldo: R$ " + conta.getSaldo());
    }
}
