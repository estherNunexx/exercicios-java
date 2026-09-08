class Livro {
    String titulo;
    String autor;
    int numeroPaginas;

    void exibirInformacoes() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Número de páginas: " + numeroPaginas);
        System.out.println();
    }
}

public class ClasseLivro {
    public static void main(String[] args) {

        Livro livro1 = new Livro();

        livro1.titulo = "Dom Casmurro";
        livro1.autor = "Machado de Assis";
        livro1.numeroPaginas = 256;

        Livro livro2 = new Livro();

        livro2.titulo = "O Pequeno Príncipe";
        livro2.autor = "Antoine de Saint-Exupéry";
        livro2.numeroPaginas = 96;

        livro1.exibirInformacoes();
        livro2.exibirInformacoes();
    }
}
