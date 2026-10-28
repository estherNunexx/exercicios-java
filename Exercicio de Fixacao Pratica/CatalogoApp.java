import dominio.Produto;
import service.CatalogoService;

public class CatalogoApp {
    public static void main(String[] args) {
        CatalogoService catalogo = new CatalogoService();

        try {
            catalogo.cadastrar(
                    new Produto(
                            "P001",
                            "Notebook",
                            3000.00,
                            5
                    )
            );
            catalogo.cadastrar(
                    new Produto(
                            "P002",
                            "Mouse",
                            80.00,
                            20
                    )
            );
            catalogo.cadastrar(
                    new Produto(
                            "P003",
                            "Monitor",
                            1200.00,
                            8
                    )
            );
            catalogo.cadastrar(
                    new Produto(
                            "P004",
                            "Teclado",
                            150.00,
                            15
                    )
            );

            System.out.println("CATÁLOGO INICIAL");
            for (Produto produto : catalogo.listarTodos()) {
                System.out.println(produto);
            }

            System.out.println("EXCLUINDO P003");
            if (catalogo.excluirPorCodigo("P003")) {
                System.out.println(
                        "Produto P003 excluído com sucesso"
                );
            } else {
                System.out.println(
                        "Produto P003 não foi encontrado"
                );
            }

            System.out.println("APÓS A EXCLUSÃO");

            for (Produto produto : catalogo.listarTodos()) {
                System.out.println(produto);
            }
            catalogo.ordenarPorPreco();
            System.out.println("CATÁLOGO ORDENADO POR PREÇO");

            for (int i = 0; i < catalogo.getTotalProdutos(); i++) {

                Produto produto = catalogo.obterPorPosicao(i);

                System.out.println(
                        "Índice " + i + " → " + produto
                );
            }
        } catch (IllegalArgumentException e) {

            System.out.println(
                    "Erro de cadastro: " + e.getMessage()
            );

        } catch (IllegalStateException e) {

            System.out.println(
                    "Erro de operação: " + e.getMessage()
            );

        } catch (IndexOutOfBoundsException e) {

            System.out.println(
                    "Erro de posição: " + e.getMessage()
            );

        } finally {

            System.out.println("\nOperação finalizada.");
        }
    }
}
