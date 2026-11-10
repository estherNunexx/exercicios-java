
public class ValidadorSenha {

    public boolean isForte(String senha) {

        if (senha == null || senha.length() < 8) {
            return false;
        }

        boolean numero = false;
        boolean maiuscula = false;

        for (int i = 0; i < senha.length(); i++) {

            char letra = senha.charAt(i);

            if (Character.isDigit(letra)) {
                numero = true;
            }

            if (Character.isUpperCase(letra)) {
                maiuscula = true;
            }
        }

        return numero && maiuscula;
    }
}
