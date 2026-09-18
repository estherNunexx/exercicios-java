public class Main {
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
