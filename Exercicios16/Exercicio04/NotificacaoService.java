public class NotificacaoService {
    private EmailSender emailSender;

    public NotificacaoService(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void notificarBoasVindas(Usuario usuario) {

        String primeiroNome = usuario.getNome().split(" ")[0];

        String destinatario = usuario.getEmail();

        String assunto = "Bem-vindo ao nosso sistema!";

        String corpo = "Olá, " + primeiroNome +
                       "! Seja bem-vindo ao nosso sistema.";

        emailSender.enviar(destinatario, assunto, corpo);
    }
}
