package school.sptech.vastiny_projeto.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer numeroVenda;

    private LocalDateTime dataHora;

    private BigDecimal valorTotal;

    private BigDecimal valorLucro;

    @ManyToOne
    @JoinColumn(name = "fkCliente")
    private Cliente cliente;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fkUsuario", nullable = false)
    private Usuario usuario;

    public Venda() {
    }

    public Venda(Integer id, Integer numeroVenda, LocalDateTime dataHora, BigDecimal valorTotal, BigDecimal valorLucro, Cliente cliente, Usuario usuario) {
        this.id = id;
        this.numeroVenda = numeroVenda;
        this.dataHora = dataHora;
        this.valorTotal = valorTotal;
        this.valorLucro = valorLucro;
        this.cliente = cliente;
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumeroVenda() {
        return numeroVenda;
    }

    public void setNumeroVenda(Integer numeroVenda) {
        this.numeroVenda = numeroVenda;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public BigDecimal getValorLucro() {
        return valorLucro;
    }

    public void setValorLucro(BigDecimal valorLucro) {
        this.valorLucro = valorLucro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
