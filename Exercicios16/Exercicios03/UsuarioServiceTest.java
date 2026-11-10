
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTest {

    @Mock
    UsuarioRepository repository;

    @InjectMocks
    UsuarioService service;

    @Test
    public void testarAtualizacaoEmail() {

        Usuario usuario = new Usuario(
            1L,
            "Ana",
            "ana@gmail.com"
        );

        when(repository.buscarPorId(1L))
            .thenReturn(Optional.of(usuario));

        service.atualizarEmail(1L, "ana@hotmail.com");

        assertEquals("ana@hotmail.com", usuario.getEmail());

        verify(repository, times(1)).salvar(any(Usuario.class));
    }
}
