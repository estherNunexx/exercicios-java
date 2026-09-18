public class Main {
    public static void main(String[] args) {

        Eleitor eleitor = new Eleitor();

        try {
            eleitor.cadastrar("João", 25);
            eleitor.cadastrar("Maria", 150);
            eleitor.cadastrar("Pedro", 30);
        }
        catch (IdadeInvalidaException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
