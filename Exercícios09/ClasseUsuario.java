interface Autenticavel {
    boolean autenticar(String senha);
}

interface ExportavelJSON {
    String exportarJSON();
}

class Usuario implements Autenticavel {
    String login;
    String senha;

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public boolean autenticar(String senha) {
        return this.senha.equals(senha);
    }
}

class Administrador implements Autenticavel, ExportavelJSON {
    String login;
    String senha;
    int nivelAcesso;

    public Administrador(String login, String senha, int nivelAcesso) {
        this.login = login;
        this.senha = senha;
        this.nivelAcesso = nivelAcesso;
    }

    public boolean autenticar(String senha) {
        return this.senha.equals(senha);
    }

    public String exportarJSON() {
        return "{\"login\":\"" + login + "\",\"nivelAcesso\":" + nivelAcesso + "}";
    }
}

public class ClasseUsuario {
    public static void main(String[] args) {

        Usuario usuario = new Usuario("josué", "1234");

        System.out.println("Usuário autenticado: " + usuario.autenticar("1234"));

        System.out.println();

        Administrador administrador = new Administrador("admin", "abcd", 1);

        System.out.println("Administrador autenticado: " + administrador.autenticar("abcd"));
        System.out.println(administrador.exportarJSON());
    }
}
