package school.sptech.vastiny_projeto.DTO.Clientes;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import school.sptech.vastiny_projeto.Enums.TipoCliente;

public class ClienteRequestDto {

    @NotBlank
    private String nome;

    @NotBlank
    private String telefone;

    private String descricao;

    private TipoCliente tipo;


    public ClienteRequestDto() {
    }

    public ClienteRequestDto(String nome, String telefone, String descricao, TipoCliente tipo) {
        this.nome = nome;
        this.telefone = telefone;
        this.descricao = descricao;
        this.tipo = tipo;
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

    public TipoCliente getTipo() {
        return tipo;
    }

    public void setTipo(TipoCliente tipo) {
        this.tipo = tipo;
    }
}
