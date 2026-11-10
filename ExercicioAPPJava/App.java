
import Controller.PessoaController;
import View.PessoaView;

public class App {

    public static void main(String[] args) {

        PessoaController controller = new PessoaController();
        PessoaView view = new PessoaView(controller);

        view.iniciar();
    }
}
