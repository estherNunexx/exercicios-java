public class Main {
public static void main(String[] args) {

        ContadorAcessos contador = new ContadorAcessos();
        Thread[] threads = new Thread[5];

        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    contador.incrementar();
                }
            });
            threads[i].start();
        }
        try {
            for (int i = 0; i < 5; i++) {
                threads[i].join();
            }

        } catch (InterruptedException e) {
            System.out.println(
                    "A thread principal foi interrompida"
            );
          Thread.currentThread().interrupt();
        }
        System.out.println(
                "Total de acessos: "
                        + contador.getContador()
);
}
}
