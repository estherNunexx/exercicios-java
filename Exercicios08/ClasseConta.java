class Conta {
    private String numero;
    private double saldo;

    public Conta(String numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }
    public String getNumero() {
        return numero;
    }
    public double getSaldo() {
        return saldo;
    }
    public void depositar(double valor) {
        if (valor > 0) {
            saldo = saldo + valor;
        }
    }
    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo = saldo - valor;
            System.out.println("Saque realizado.");
        } else {
            System.out.println("Saque não permitido.");
        }
    }
}
class ContaPoupanca extends Conta {
    private double taxaRendimento;

    public ContaPoupanca(String numero, double saldo, double taxaRendimento) {
        super(numero, saldo);
        this.taxaRendimento = taxaRendimento;
    }
    public void aplicarRendimento() {
        double rendimento = getSaldo() * taxaRendimento / 100;
        depositar(rendimento);
    }
}
class ContaCorrente extends Conta {
    private double limiteChequeEspecial;

    public ContaCorrente(String numero, double saldo, double limiteChequeEspecial) {
        super(numero, saldo);
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    @Override
    public void sacar(double valor) {
        double valorTotal = valor + 2.00;

        if (valor > 0 && getSaldo() - valorTotal >= -limiteChequeEspecial) {
            super.sacar(valor);
            
            if (getSaldo() >= 0) {
              
            }

            super.sacar(2.00);
            System.out.println("Saque realizado com taxa de R$ 2,00.");
        } else {
            System.out.println("Saque não permitido. Limite do cheque especial excedido.");
        }
    }
}

public class ClasseConta {
    public static void main(String[] args) {

        ContaPoupanca poupanca = new ContaPoupanca("001", 1000, 5);

        System.out.println("CONTA POUPANÇA");
        System.out.println("Saldo: R$ " + poupanca.getSaldo());

        poupanca.aplicarRendimento();

        System.out.println("Saldo após rendimento: R$ " + poupanca.getSaldo());

        System.out.println();

        ContaCorrente corrente = new ContaCorrente("002", 500, 1000);

        System.out.println("CONTA CORRENTE");
        System.out.println("Saldo: R$ " + corrente.getSaldo());

        corrente.sacar(400);

        System.out.println("Saldo após saque: R$ " + corrente.getSaldo());

        corrente.sacar(1000);

        System.out.println("Saldo após segundo saque: R$ " + corrente.getSaldo());
    }
}
