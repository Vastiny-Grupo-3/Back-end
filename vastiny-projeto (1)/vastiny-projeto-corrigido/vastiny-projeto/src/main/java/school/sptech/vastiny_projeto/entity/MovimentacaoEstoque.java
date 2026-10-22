package school.sptech.vastiny_projeto.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class MovimentacaoEstoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String tipoMovimentacao;

    private Integer quantidade;

    private String justificativa;

    private LocalDateTime dataHora;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fkPeca", nullable = false)
    private Peca peca;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fkUsuario", nullable = false)
    private Usuario usuario;

    public MovimentacaoEstoque() {
    }

    public MovimentacaoEstoque(Integer id, String tipoMovimentacao, Integer quantidade, String justificativa, LocalDateTime dataHora, Peca peca, Usuario usuario) {
        this.id = id;
        this.tipoMovimentacao = tipoMovimentacao;
        this.quantidade = quantidade;
        this.justificativa = justificativa;
        this.dataHora = dataHora;
        this.peca = peca;
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(String tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Peca getPeca() {
        return peca;
    }

    public void setPeca(Peca peca) {
        this.peca = peca;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
