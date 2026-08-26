import java.util.Scanner;

public class ConversorTempo {
    public static void main(String[] args) {
         try (Scanner entrada = new Scanner(System.in)) {

        System.out.print("Digite o total de segundos: ");
        int totalSegundos = entrada.nextInt();

        int horas = totalSegundos / 3600;
        int minutos = (totalSegundos % 3600) / 60;
        int segundos = totalSegundos % 60;

        System.out.println(horas + " hora(s), " + minutos + " minuto(s) e " + segundos + " segundo(s)");

        entrada.close();
    }
}

}
