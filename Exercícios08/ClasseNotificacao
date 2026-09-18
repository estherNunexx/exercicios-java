class Notificacao {
    String destinatario;

    public Notificacao(String destinatario) {
        this.destinatario = destinatario;
    }

    public void enviar(String mensagem) {
        System.out.println("Enviando notificação para " + destinatario + ": " + mensagem);
    }
}

class EmailNotificacao extends Notificacao {

    public EmailNotificacao(String destinatario) {
        super(destinatario);
    }

    @Override
    public void enviar(String mensagem) {
        System.out.println("Enviando E-mail para " + destinatario + ": " + mensagem);
    }
}

class SmsNotificacao extends Notificacao {

    public SmsNotificacao(String destinatario) {
        super(destinatario);
    }

    @Override
    public void enviar(String mensagem) {
        System.out.println("Enviando SMS para o número " + destinatario + ": " + mensagem);
    }
}

class PushNotificacao extends Notificacao {

    public PushNotificacao(String destinatario) {
        super(destinatario);
    }

    @Override
    public void enviar(String mensagem) {
        System.out.println("Enviando Push Notification para o dispositivo " + destinatario + ": " + mensagem);
    }
}

public class ClasseNotificacao {

    public static void processarEnvio(Notificacao notificacao, String texto) {
        notificacao.enviar(texto);
    }

    public static void main(String[] args) {

        Notificacao email = new EmailNotificacao("esther@email.com");
        Notificacao sms = new SmsNotificacao("21999999999");
        Notificacao push = new PushNotificacao("Dispositivo E");

        processarEnvio(email, "Olá! Temos uma novidade");
        processarEnvio(sms, "Seu código de verificação é 1234");
        processarEnvio(push, "Você recebeu uma nova mensagem!");
    }
}
