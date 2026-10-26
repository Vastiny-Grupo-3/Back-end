package school.sptech.vastiny_projeto.Service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import school.sptech.vastiny_projeto.DTO.Auth.AuthResponseDto;
import school.sptech.vastiny_projeto.DTO.Usuario.UsuarioResponseDto;
import school.sptech.vastiny_projeto.Exception.CredenciaisInvalidasException;
import school.sptech.vastiny_projeto.Repository.UsuarioRepository;
import school.sptech.vastiny_projeto.Security.JwtService;
import school.sptech.vastiny_projeto.entity.Usuario;

import java.util.Optional;

@Service
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public AuthResponseDto login (Usuario usuarioLogin) {
//        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        Optional<Usuario> usuarioOptional = usuarioRepository.findByEmail(usuarioLogin.getEmail());

        if (usuarioOptional.isEmpty()) {
            throw new CredenciaisInvalidasException("Credenciais inválidas!");
        }

        Usuario usuario = usuarioOptional.get();

        if (!passwordEncoder.matches(usuarioLogin.getSenha(), usuario.getSenha())) {
            throw new CredenciaisInvalidasException("Credenciais inválidas!");
        }

        String token = jwtService.gerarToken(usuario);
        return new AuthResponseDto (
                token,
                new UsuarioResponseDto(
                        usuario.getId(),
                        usuario.getNome(),
                        usuario.getEmail()
                )
        );
    }
}
