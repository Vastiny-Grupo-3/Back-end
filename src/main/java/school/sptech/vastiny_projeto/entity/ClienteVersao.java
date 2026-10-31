package school.sptech.vastiny_projeto.entity;

import jakarta.persistence.*;
import school.sptech.vastiny_projeto.Enums.TipoCliente;

import java.time.LocalDate;

@Entity
public class ClienteVersao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fkCliente", nullable = false)
    private Cliente cliente;

    private String nome;
    private String telefone;
    private String descrica;

    @Enumerated(EnumType.STRING)
    private TipoCliente tipo;

    private LocalDate dataAlteracao;

    public ClienteVersao() {
    }

    public ClienteVersao(Integer id, Cliente cliente, String nome, String telefone, String descrica, TipoCliente tipo, LocalDate dataAlteracao) {
        this.id = id;
        this.cliente = cliente;
        this.nome = nome;
        this.telefone = telefone;
        this.descrica = descrica;
        this.tipo = tipo;
        this.dataAlteracao = dataAlteracao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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

    public String getDescrica() {
        return descrica;
    }

    public void setDescrica(String descrica) {
        this.descrica = descrica;
    }

    public TipoCliente getTipo() {
        return tipo;
    }

    public void setTipo(TipoCliente tipo) {
        this.tipo = tipo;
    }

    public LocalDate getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDate dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }
}
