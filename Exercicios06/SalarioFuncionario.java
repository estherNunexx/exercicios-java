class Funcionario {
    String nome;
    String cargo;
    double salarioBruto;

    void aplicarAumento(double porcentagem) {
        salarioBruto = salarioBruto + (salarioBruto * porcentagem / 100);
    }

    double calcularSalarioLiquido(double descontoImposto) {
        return salarioBruto - descontoImposto;
    }
}

public class SalarioFuncionario {
    public static void main(String[] args) {

        Funcionario funcionario = new Funcionario();

        funcionario.nome = "Carlos";
        funcionario.cargo = "Analista";
        funcionario.salarioBruto = 3000;

        System.out.println("Nome: " + funcionario.nome);
        System.out.println("Cargo: " + funcionario.cargo);
        System.out.println("Salário antes do aumento: R$ " + funcionario.salarioBruto);

        funcionario.aplicarAumento(10);

        System.out.println("Salário após o aumento: R$ " + funcionario.salarioBruto);
    }
}
