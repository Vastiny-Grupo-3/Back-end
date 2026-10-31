package school.sptech.vastiny_projeto.DTO.Usuario;

import jakarta.validation.constraints.*;

public class UsuarioRequestDto {

    @NotBlank(message = "Informe o nome de usuário.")
    private String nome;

    @NotBlank(message = "Informe o e-mail")
    @Email(message = "Informe um e-mail válido")
    private String email;


    @Pattern(regexp = "^(?=.*[A-Za-zÀ-ÿ])(?=.*\\d).{8,}$", message = "A senha não atende aos requesitos de segurança.")
    private String senha;

    public UsuarioRequestDto() {
    }

    public UsuarioRequestDto(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
