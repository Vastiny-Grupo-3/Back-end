package school.sptech.vastiny_projeto.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import school.sptech.vastiny_projeto.DTO.Auth.AuthRequestDto;
import school.sptech.vastiny_projeto.DTO.Auth.AuthResponseDto;
import school.sptech.vastiny_projeto.Mapper.AuthMapper;
import school.sptech.vastiny_projeto.Service.AuthService;
import school.sptech.vastiny_projeto.entity.Usuario;

@Tag(name = "Autenticação", description = "Login e geração do token JWT")
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @Operation(summary = "Realizar login", description = "Autentica o usuário com e-mail e senha e retorna o token JWT usado no cabeçalho Authorization (Bearer). Endpoint público.")
    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(
            @Valid @RequestBody AuthRequestDto dto
    ) {
        Usuario usuario = AuthMapper.toEntity(dto);
        AuthResponseDto dtoResponse = this.authService.login(usuario);
        return ResponseEntity.status(200).body(dtoResponse);
    }
}
