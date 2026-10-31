package school.sptech.vastiny_projeto.Service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import school.sptech.vastiny_projeto.DTO.Usuario.AtualizarContaRequestDto;
import school.sptech.vastiny_projeto.Exception.ConflitoException;
import school.sptech.vastiny_projeto.Exception.NaoEncontradoException;
import school.sptech.vastiny_projeto.Exception.ValidacaoException;
import school.sptech.vastiny_projeto.Repository.UsuarioRepository;
import school.sptech.vastiny_projeto.entity.Usuario;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    //Get
    public List<Usuario> listar(){
        return usuarioRepository.findAll();
    }


    //Get id
    public Usuario buscarPorId(Integer id){
        return usuarioRepository.findById(id).orElseThrow(() -> new NaoEncontradoException("Usuário não encontrado"));
    }

    //Get email
    public Usuario buscarPorEmail(String email) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findByEmail(email);

        if (usuarioOptional.isEmpty()) {
            throw new NaoEncontradoException("Usuário não encontrado!");
        }

        return usuarioOptional.get();
    }

    //Post
    public Usuario criar(Usuario usuario){

        if (this.usuarioRepository.findByEmail(usuario.getEmail()).isPresent()) {
            throw new ConflitoException("email", "Email já cadastrado em outro login");
        }

        usuario.setDataCadastro(LocalDateTime.now());
        usuario.setSenha(this.passwordEncoder.encode(usuario.getSenha()));
        return usuarioRepository.save(usuario);

    }

    //Put
    public Usuario atualizar(Integer id, AtualizarContaRequestDto dados){

        Usuario usuario = this.buscarPorId(id);

        this.usuarioRepository.findByEmail(dados.getEmail().trim())
                .filter(outro -> !outro.getId().equals(id))
                        .ifPresent(outro -> {
                            throw new ConflitoException("email", "Este e-mail já está em uso.");
                        });

        if (dados.getNovaSenha() != null && !dados.getNovaSenha().isBlank()) {
            if (dados.getSenhaAtual() == null || !this.passwordEncoder.matches(dados.getSenhaAtual(), usuario.getSenha())) {
                throw new ValidacaoException("senhaAtual", "A senha atual não confere.");
            }
            usuario.setSenha(passwordEncoder.encode(dados.getNovaSenha()));
        }

        usuario.setNome(dados.getNome().trim());
        usuario.setEmail(dados.getEmail().trim());
        return usuarioRepository.save(usuario);
    }

    //delete
    public void excluir(Integer id, String senhaAtual){
        Usuario usuario = this.buscarPorId(id);

        if (!this.passwordEncoder.matches(senhaAtual, usuario.getSenha())) {
            throw new ValidacaoException("senhaAtual", "A senha atual não confere");
        }

        usuarioRepository.delete(usuario);
    }

}
