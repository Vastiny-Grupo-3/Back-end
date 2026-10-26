package school.sptech.vastiny_projeto.DTO.Clientes;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ClienteRequestDto {

    @NotBlank
    private String nome;

    @NotNull
    private String telefone;

    @NotNull
    private String descricao;


    public ClienteRequestDto() {
    }

    public ClienteRequestDto(String nome, String telefone, String descricao) {
        this.nome = nome;
        this.telefone = telefone;
        this.descricao = descricao;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
