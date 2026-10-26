package school.sptech.vastiny_projeto.DTO.Clientes;

import java.time.LocalDateTime;

public class ClienteResponseDto {


    private Integer id;

    private String nome;

    private String telefone;

    private String descricao;

    private LocalDateTime dataCadastro;


    public ClienteResponseDto() {
    }

    public ClienteResponseDto(Integer id, String nome, String telefone, String descricao, LocalDateTime dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.descricao = descricao;
        this.dataCadastro = dataCadastro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }


}
