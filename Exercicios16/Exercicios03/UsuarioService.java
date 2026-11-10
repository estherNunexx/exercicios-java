public class UsuarioService {

    private UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public void atualizarEmail(Long id, String novoEmail) {

        Usuario usuario = repository.buscarPorId(id)
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

        usuario.setEmail(novoEmail);

        repository.salvar(usuario);
    }
}
