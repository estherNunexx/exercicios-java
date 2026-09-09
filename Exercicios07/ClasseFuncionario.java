class Funcionario {
    private String nome;
    private String matricula;
    private double salario;

    public Funcionario(String nome, String matricula, double salario) {
        this.nome = nome;
        this.matricula = matricula;
        this.salario = salario;
    }
    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double novoSalario) {
        if (novoSalario > salario) {
            salario = novoSalario;
        } else {
            System.out.println("Erro: o novo salário deve ser maior que o salário atual.");
        }
    }
    public void exibirDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Matrícula: " + matricula);
        System.out.println("Salário: R$ " + salario);
    }
}

public class ClasseFuncionario {
    public static void main(String[] args) {

        Funcionario funcionario = new Funcionario(
            "Maria Haglair",
            "010203",
            3000.00
        );

        funcionario.exibirDados();
        System.out.println();

        System.out.println("Tentando aumentar o salário...");
        funcionario.setSalario(3500.00);

        funcionario.exibirDados();
        System.out.println();

        System.out.println("Tentando reduzir o salário...");
        funcionario.setSalario(2500.00);
        funcionario.exibirDados();
    }
}
