
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Captor;
import org.mockito.ArgumentCaptor;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class NotificacaoServiceTest {

    @Mock
    EmailSender emailSender;

    @InjectMocks
    NotificacaoService service;

    @Captor
    ArgumentCaptor<String> destinatarioCaptor;

    @Captor
    ArgumentCaptor<String> assuntoCaptor;

    @Captor
    ArgumentCaptor<String> corpoCaptor;

    @Test
    public void testarNotificacaoBoasVindas() {

        Usuario usuario = new Usuario(
            "Ana Silva",
            "ana@gmail.com"
    );

      service.notificarBoasVindas(usuario);

        verify(emailSender).enviar(
        destinatarioCaptor.capture(),
        assuntoCaptor.capture(),
        corpoCaptor.capture()
    );

    assertTrue(assuntoCaptor.getValue().contains("Bem-vindo"));
    assertTrue(corpoCaptor.getValue().contains("Ana"));
    }
}
