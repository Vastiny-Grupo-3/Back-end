package school.sptech.vastiny_projeto.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ItemCarrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime dataHora;

    private Integer quantidade;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fkCarrinho", nullable = false)
    private Carrinho carrinho;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fkProduto", nullable = false)
    private Produto produto;

    public ItemCarrinho() {
    }

    public ItemCarrinho(Integer id, LocalDateTime dataHora, Integer quantidade, Carrinho carrinho, Produto produto) {
        this.id = id;
        this.dataHora = dataHora;
        this.quantidade = quantidade;
        this.carrinho = carrinho;
        this.produto = produto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
