package school.sptech.vastiny_projeto.DTO.Usuario;

import jakarta.validation.constraints.NotBlank;

public class ExcluirContaRequestDto {

    @NotBlank(message = "Informe a senha atual.")
    private String senhaAtual;

    public ExcluirContaRequestDto(String senhaAtual) {
        this.senhaAtual = senhaAtual;
    }

    public ExcluirContaRequestDto() {
    }

    public String getSenhaAtual() {
        return senhaAtual;
    }

    public void setSenhaAtual(String senhaAtual) {
        this.senhaAtual = senhaAtual;
    }
}
