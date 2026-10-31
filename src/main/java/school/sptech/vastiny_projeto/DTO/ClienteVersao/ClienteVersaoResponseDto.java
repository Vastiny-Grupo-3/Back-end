package school.sptech.vastiny_projeto.DTO.ClienteVersao;

import school.sptech.vastiny_projeto.Enums.TipoCliente;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ClienteVersaoResponseDto {
    private Integer id;
    private Integer clienteId;
    private String nome;
    private String telefone;
    private String descricao;
    private TipoCliente tipo;
    private LocalDateTime dataCadastro;
    private LocalDate data;

    public ClienteVersaoResponseDto(Integer id, Integer clienteId, String nome, String telefone, String descricao, TipoCliente tipo, LocalDateTime dataCadastro, LocalDate data) {
        this.id = id;
        this.clienteId = clienteId;
        this.nome = nome;
        this.telefone = telefone;
        this.descricao = descricao;
        this.tipo = tipo;
        this.dataCadastro = dataCadastro;
        this.data = data;
    }

    public ClienteVersaoResponseDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
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

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
