package school.sptech.vastiny_projeto.DTO.Clientes;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ClienteRequestDto {

    @NotBlank
    private String nome;

    @NotNull
    private String telefone;


    public ClienteRequestDto() {
    }

    public ClienteRequestDto(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
