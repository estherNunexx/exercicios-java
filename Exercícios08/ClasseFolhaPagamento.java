class Funcionario {
    String nome;
    double salarioBase;

    public Funcionario(String nome, double salarioBase) {
        this.nome= nome;
        this.salarioBase= salarioBase;
    }

    public double calcularSalario() {
        return salarioBase;
    }
}

class Gerente extends Funcionario {
    double bonusFixo;

    public Gerente(String nome, double salarioBase, double bonusFixo) {
        super(nome, salarioBase);
        this.bonusFixo= bonusFixo;
    }

    @Override
    public double calcularSalario() {
        return salarioBase +bonusFixo;
    }
}

class Vendedor extends Funcionario {
    double totalVendas;
    double comissaoPercentual;

    public Vendedor(String nome, double salarioBase, double totalVendas, double comissaoPercentual) {
        super(nome, salarioBase);
        this.totalVendas= totalVendas;
        this.comissaoPercentual= comissaoPercentual;
    }

    @Override
    public double calcularSalario() {
        return salarioBase+(totalVendas*comissaoPercentual/100);
    }
}

public class ClasseFolhaPagamento {
    public static void main(String[] args) {

        Funcionario[] funcionarios= {
            new Funcionario("Esther", 2000),
            new Gerente("Josué", 5000, 1000),
            new Vendedor("Maria", 2000, 10000, 5)
        };

        double totalFolha= 0;

        for (Funcionario funcionario: funcionarios) {
            double salario= funcionario.calcularSalario();

            System.out.println("Funcionário: " +funcionario.nome);
            System.out.println("Salário: R$ " +salario);
            System.out.println();

            totalFolha= totalFolha+salario;
        }

        System.out.println("Total da folha: R$ " +totalFolha);
    }
}
