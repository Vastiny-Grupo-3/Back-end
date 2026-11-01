package school.sptech.vastiny_projeto.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String descricao;

    private String foto;

    private Integer qtdEstoque;

    private String codigo1;

    private String codigo2;

    private String codigo3;

    private String codigo4;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fkCategoria", nullable = false)
    private Categoria categoria;

    private BigDecimal valorCompra;
    private BigDecimal precoEmpresa;
    private BigDecimal precoConsumidor;
    private Boolean ativo = true;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime dataCadastro;

    public Produto() {
    }

    public Produto(Integer id, String descricao, String foto, Integer qtdEstoque, String codigo1, String codigo2, String codigo3, String codigo4, Categoria categoria, BigDecimal valorCompra, BigDecimal precoEmpresa, BigDecimal precoConsumidor) {
        this.id = id;
        this.descricao = descricao;
        this.foto = foto;
        this.qtdEstoque = qtdEstoque;
        this.codigo1 = codigo1;
        this.codigo2 = codigo2;
        this.codigo3 = codigo3;
        this.codigo4 = codigo4;
        this.categoria = categoria;
        this.valorCompra = valorCompra;
        this.precoEmpresa = precoEmpresa;
        this.precoConsumidor = precoConsumidor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Integer getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(Integer qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public String getCodigo1() {
        return codigo1;
    }

    public void setCodigo1(String codigo1) {
        this.codigo1 = codigo1;
    }

    public String getCodigo2() {
        return codigo2;
    }

    public void setCodigo2(String codigo2) {
        this.codigo2 = codigo2;
    }

    public String getCodigo3() {
        return codigo3;
    }

    public void setCodigo3(String codigo3) {
        this.codigo3 = codigo3;
    }

    public String getCodigo4() {
        return codigo4;
    }

    public void setCodigo4(String codigo4) {
        this.codigo4 = codigo4;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public BigDecimal getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(BigDecimal valorCompra) {
        this.valorCompra = valorCompra;
    }

    public BigDecimal getPrecoEmpresa() {
        return precoEmpresa;
    }

    public void setPrecoEmpresa(BigDecimal precoEmpresa) {
        this.precoEmpresa = precoEmpresa;
    }

    public BigDecimal getPrecoConsumidor() {
        return precoConsumidor;
    }

    public void setPrecoConsumidor(BigDecimal precoConsumidor) {
        this.precoConsumidor = precoConsumidor;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
