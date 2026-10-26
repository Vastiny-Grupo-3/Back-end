package school.sptech.vastiny_projeto.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Carrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCarrinho;

    private LocalDateTime dataHora;

    private LocalDateTime dataModificacao;

    private String status;

    @ManyToOne
    @JoinColumn(name = "fkCliente")
    private Cliente cliente;

    public Carrinho() {
    }

    public Carrinho(Integer idCarrinho, LocalDateTime dataHora, LocalDateTime dataModificacao, String status, Cliente cliente) {
        this.idCarrinho = idCarrinho;
        this.dataHora = dataHora;
        this.dataModificacao = dataModificacao;
        this.status = status;
        this.cliente = cliente;
    }

    public Integer getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(Integer idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public LocalDateTime getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(LocalDateTime dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
