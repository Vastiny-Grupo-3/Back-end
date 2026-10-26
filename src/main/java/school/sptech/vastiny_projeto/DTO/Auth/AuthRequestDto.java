package school.sptech.vastiny_projeto.DTO.Auth;

import jakarta.validation.constraints.NotBlank;

public class AuthRequestDto {

    @NotBlank
    private String email;

    @NotBlank
    private String senha;

    public AuthRequestDto(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public AuthRequestDto() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
