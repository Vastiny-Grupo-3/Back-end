package school.sptech.vastiny_projeto.Service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import school.sptech.vastiny_projeto.Exception.NaoEncontradoException;
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

        usuario.setDataCadastro(LocalDateTime.now());
        usuario.setSenha(this.passwordEncoder.encode(usuario.getSenha()));
        return usuarioRepository.save(usuario);

    }

    //Put
    public Usuario atualizar(Integer id, Usuario usuario){
        if(!usuarioRepository.existsById(id)){
            throw new NaoEncontradoException("Usuário não encontrado");
        }

        usuario.setId(id);
        usuario.setSenha(this.passwordEncoder.encode(usuario.getSenha()));
        return usuarioRepository.save(usuario);
    }

    //delete
    public void excluir(Integer id){
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new NaoEncontradoException("Usuário não encontrado"));

        usuarioRepository.delete(usuario);
    }

}
