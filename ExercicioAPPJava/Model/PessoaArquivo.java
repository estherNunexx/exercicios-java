
package Model;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class PessoaArquivo {

    public ArrayList<Pessoa> lerArquivo() {

        ArrayList<Pessoa> pessoas = new ArrayList<>();

        try {
            Scanner leitor = new Scanner(new File("pessoas.csv"));
          
            if (leitor.hasNextLine()) {
                leitor.nextLine();
            }

            while (leitor.hasNextLine()) {

                String linha = leitor.nextLine();
                String[] dados = linha.split(",");

                int id = Integer.parseInt(dados[0]);
                String nome = dados[1];
                int idade = Integer.parseInt(dados[2]);
                double altura = Double.parseDouble(dados[3]);

                Pessoa pessoa = new Pessoa(id, nome, idade, altura);

                pessoas.add(pessoa);
            }

            leitor.close();

        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo.");
        }

        return pessoas;
    }

    public void salvarArquivo(ArrayList<Pessoa> pessoas) {

        try {
            PrintWriter escrever = new PrintWriter(new FileWriter("pessoas.csv"));

            escrever.println("id,nome,idade,altura");

            for (Pessoa pessoa : pessoas) {

                escrever.println(
                    pessoa.getId() + "," +
                    pessoa.getNome() + "," +
                    pessoa.getIdade() + "," +
                    pessoa.getAltura()
                );
            }

            escrever.close();

        } catch (Exception e) {
            System.out.println("Erro ao salvar o arquivo.");
        }
    }
}
