package school.sptech.vastiny_projeto.Service;

import org.springframework.stereotype.Service;
import school.sptech.vastiny_projeto.Exception.NaoEncontradoException;
import school.sptech.vastiny_projeto.Repository.UsuarioRepository;
import school.sptech.vastiny_projeto.entity.Usuario;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    //Get
    public List<Usuario> listar(){
        return usuarioRepository.findAll();
    }


    //Get id
    public Usuario buscarPorId(Integer id){
        return usuarioRepository.findById(id).orElseThrow(() -> new NaoEncontradoException("Usuário não encontrado"));
    }

    //Post
    public Usuario criar(Usuario usuario){
        return usuarioRepository.save(usuario);

    }

    //Put
    public Usuario atualizar(Integer id, Usuario usuario){
        if(!usuarioRepository.existsById(id)){
            throw new NaoEncontradoException("Usuário não encontrado");
        }

        usuario.setId(id);
        return usuarioRepository.save(usuario);
    }

    //delete
    public void excluir(Integer id){
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new NaoEncontradoException("Usuário não encontrado"));

        usuarioRepository.delete(usuario);
    }

}
