package school.sptech.vastiny_projeto.DTO.Auth;

import school.sptech.vastiny_projeto.DTO.Usuario.UsuarioResponseDto;

public class AuthResponseDto {

    private String token;
    private UsuarioResponseDto usuario;

    public AuthResponseDto() {
    }

    public AuthResponseDto(String token, UsuarioResponseDto usuarioResponseDto) {
        this.token = token;
        this.usuario = usuarioResponseDto;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UsuarioResponseDto getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioResponseDto usuario) {
        this.usuario = usuario;
    }
}
