public class ContadorRegressivo implements Runnable {
    @Override
    public void run() {

        for (int i = 10; i >= 1; i--) {

            System.out.println("Regressivo: " + i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {

                System.out.println(
                        "Contador regressivo interrompido"
                );
                Thread.currentThread().interrupt();
      }
    }
  }
}
