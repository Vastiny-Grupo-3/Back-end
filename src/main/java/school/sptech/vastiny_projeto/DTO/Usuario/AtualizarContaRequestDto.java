package school.sptech.vastiny_projeto.DTO.Usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class AtualizarContaRequestDto {

    @NotBlank(message = "Informe o nome de usuário.")
    private String nome;

    @NotBlank(message = "Informe o e-mail")
    @Email(message = "Informe um e-mail válido")
    private String email;

    private String senhaAtual;

    @Pattern(regexp = "^(?=.*[A-Za-zÀ-ÿ])(?=.*\\d).{8,}$", message = "A senha não atende aos requesitos de segurança.")
    private String novaSenha;

    public AtualizarContaRequestDto(String nome, String email, String senhaAtual, String novaSenha) {
        this.nome = nome;
        this.email = email;
        this.senhaAtual = senhaAtual;
        this.novaSenha = novaSenha;
    }

    public AtualizarContaRequestDto() {
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

    public String getSenhaAtual() {
        return senhaAtual;
    }

    public void setSenhaAtual(String senhaAtual) {
        this.senhaAtual = senhaAtual;
    }

    public String getNovaSenha() {
        return novaSenha;
    }

    public void setNovaSenha(String novaSenha) {
        this.novaSenha = novaSenha;
    }
}
