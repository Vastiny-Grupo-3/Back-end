package school.sptech.vastiny_projeto.Controller;

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

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(
            @Valid @RequestBody AuthRequestDto dto
    ) {
        Usuario usuario = AuthMapper.toEntity(dto);
        AuthResponseDto dtoResponse = this.authService.login(usuario);
        return ResponseEntity.status(200).body(dtoResponse);
    }
}
