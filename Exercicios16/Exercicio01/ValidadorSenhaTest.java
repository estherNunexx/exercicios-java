
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ValidadorSenhaTest {

    ValidadorSenha validador = new ValidadorSenha();

    @ParameterizedTest
    @ValueSource(strings = {
        "Senha123",
        "Abcdefg1",
        "Teste2026",
        "Java1234"
    })
    public void testarSenhasValidas(String senha) {
        assertTrue(validador.isForte(senha));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {
        "Ab1",
        "senhaforte",
        "SenhaForte",
        "senha123"
    })
    public void testarSenhasInvalidas(String senha) {
        assertFalse(validador.isForte(senha));
    }
}
