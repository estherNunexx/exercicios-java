public class Eleitor {

    public void cadastrar(String nome, int idade) {

        if (idade < 0 || idade > 130) {
            throw new IdadeInvalidaException("Idade inválida: " + idade);
        }

        System.out.println("Eleitor cadastrado: " + nome);
    }
}
