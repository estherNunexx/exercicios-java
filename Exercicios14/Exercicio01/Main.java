public class Main {
public static void main(String[] args) {

        ContadorCrescente crescente =
                new ContadorCrescente();

        ContadorRegressivo regressivo =
                new ContadorRegressivo();

        Thread threadCrescente =
                new Thread(crescente);

        Thread threadRegressivo =
                new Thread(regressivo);

        threadCrescente.start();
        threadRegressivo.start();

        try {
            threadCrescente.join();
            threadRegressivo.join();

        } catch (InterruptedException e) {
            System.out.println(
                    "A thread principal foi interrompida"
            );
            Thread.currentThread().interrupt();
        }
        System.out.println(
                "Contagens finalizadas!"
        );
    }
}
