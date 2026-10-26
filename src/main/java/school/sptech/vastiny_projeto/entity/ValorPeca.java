package school.sptech.vastiny_projeto.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class ValorPeca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private BigDecimal custo;

    private BigDecimal custoAE;

    private BigDecimal custoFinal;

    private BigDecimal precoVenda;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fkPeca", nullable = false)
    private Peca peca;

    public ValorPeca() {
    }

    public ValorPeca(Integer id, BigDecimal custo, BigDecimal custoAE, BigDecimal custoFinal, BigDecimal precoVenda, Peca peca) {
        this.id = id;
        this.custo = custo;
        this.custoAE = custoAE;
        this.custoFinal = custoFinal;
        this.precoVenda = precoVenda;
        this.peca = peca;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getCusto() {
        return custo;
    }

    public void setCusto(BigDecimal custo) {
        this.custo = custo;
    }

    public BigDecimal getCustoAE() {
        return custoAE;
    }

    public void setCustoAE(BigDecimal custoAE) {
        this.custoAE = custoAE;
    }

    public BigDecimal getCustoFinal() {
        return custoFinal;
    }

    public void setCustoFinal(BigDecimal custoFinal) {
        this.custoFinal = custoFinal;
    }

    public BigDecimal getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(BigDecimal precoVenda) {
        this.precoVenda = precoVenda;
    }

    public Peca getPeca() {
        return peca;
    }

    public void setPeca(Peca peca) {
        this.peca = peca;
    }
}
