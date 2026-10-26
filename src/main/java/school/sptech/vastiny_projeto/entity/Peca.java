package school.sptech.vastiny_projeto.entity;

import jakarta.persistence.*;

@Entity
public class Peca {

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

    public Peca() {
    }

    public Peca(Integer id, String descricao, String foto, Integer qtdEstoque, String codigo1, String codigo2, String codigo3, String codigo4, Categoria categoria) {
        this.id = id;
        this.descricao = descricao;
        this.foto = foto;
        this.qtdEstoque = qtdEstoque;
        this.codigo1 = codigo1;
        this.codigo2 = codigo2;
        this.codigo3 = codigo3;
        this.codigo4 = codigo4;
        this.categoria = categoria;
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
}
