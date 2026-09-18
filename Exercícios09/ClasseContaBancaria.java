import java.util.ArrayList;
import java.util.List;

abstract class ContaBancaria {
    private String numero;
    private double saldo;

    public ContaBancaria(String numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo = saldo + valor;
        }
    }

    public double consultarSaldo() {
        return saldo;
    }

    protected void diminuirSaldo(double valor) {
        saldo = saldo - valor;
    }

    public abstract void cobrarTaxaMensal();
}

class ContaCorrente extends ContaBancaria {

    public ContaCorrente(String numero, double saldo) {
        super(numero, saldo);
    }

    @Override
    public void cobrarTaxaMensal() {
        diminuirSaldo(15.00);
    }
}

class ContaEmpresarial extends ContaBancaria {

    public ContaEmpresarial(String numero, double saldo) {
        super(numero, saldo);
    }

    @Override
    public void cobrarTaxaMensal() {
        double taxa = 30.00 + (consultarSaldo() * 0.005);
        diminuirSaldo(taxa);
    }
}

public class ClasseContaBancaria {
    public static void main(String[] args) {

        List<ContaBancaria> contas = new ArrayList<>();

        contas.add(new ContaCorrente("001", 1000));
        contas.add(new ContaEmpresarial("002", 2000));

        System.out.println("Antes da cobrança:");

        for (ContaBancaria conta : contas) {
            System.out.println("Saldo: R$ " + conta.consultarSaldo());
        }

        System.out.println();

        for (ContaBancaria conta : contas) {
            conta.cobrarTaxaMensal();
        }

        System.out.println("Depois da cobrança:");

        for (ContaBancaria conta : contas) {
            System.out.println("Saldo: R$ " + conta.consultarSaldo());
        }
    }
}
