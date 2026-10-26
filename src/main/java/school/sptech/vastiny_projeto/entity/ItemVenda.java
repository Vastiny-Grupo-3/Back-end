package school.sptech.vastiny_projeto.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class ItemVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer quantidade;

    private BigDecimal precoUnitario;

    private BigDecimal custoUnitario;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fkVenda", nullable = false)
    private Venda venda;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fkPeca", nullable = false)
    private Peca peca;

    public ItemVenda() {
    }

    public ItemVenda(Integer id, Integer quantidade, BigDecimal precoUnitario, BigDecimal custoUnitario, Venda venda, Peca peca) {
        this.id = id;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.custoUnitario = custoUnitario;
        this.venda = venda;
        this.peca = peca;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public BigDecimal getCustoUnitario() {
        return custoUnitario;
    }

    public void setCustoUnitario(BigDecimal custoUnitario) {
        this.custoUnitario = custoUnitario;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Peca getPeca() {
        return peca;
    }

    public void setPeca(Peca peca) {
        this.peca = peca;
    }
}
