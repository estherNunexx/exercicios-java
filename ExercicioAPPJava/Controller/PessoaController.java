
package Controller;

import Model.Pessoa;
import Model.PessoaArquivo;
import java.util.ArrayList;

public class PessoaController {

    private ArrayList<Pessoa> pessoas;
    private PessoaArquivo arquivo;

    public PessoaController() {
        arquivo = new PessoaArquivo();
        pessoas = arquivo.lerArquivo();
    }

    // Incluir pessoa
    public void incluir(Pessoa pessoa) {

        for (Pessoa p : pessoas) {
            if (p.getId() == pessoa.getId()) {
                throw new IllegalArgumentException("Esse ID já está cadastrado!");
            }
        }

        pessoas.add(pessoa);
        arquivo.salvarArquivo(pessoas);
    }

    // Listar pessoas
    public ArrayList<Pessoa> listar() {
        return pessoas;
    }

    // Alterar pessoa
    public boolean alterar(int id, String nome, int idade, double altura) {

        for (Pessoa p : pessoas) {

            if (p.getId() == id) {

                p.setNome(nome);
                p.setIdade(idade);
                p.setAltura(altura);

                arquivo.salvarArquivo(pessoas);
                return true;
            }
        }

        return false;
    }

    // Excluir pessoa
    public boolean excluir(int id) {

        for (int i = 0; i < pessoas.size(); i++) {

            if (pessoas.get(i).getId() == id) {

                pessoas.remove(i);
                arquivo.salvarArquivo(pessoas);
                return true;
            }
        }

        return false;
    }
}
