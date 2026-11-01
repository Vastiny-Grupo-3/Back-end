package school.sptech.vastiny_projeto.DTO.Produto;

import school.sptech.vastiny_projeto.DTO.Categoria.CriteriosDto;

import java.math.BigDecimal;
import java.util.List;

public class ProdutoResponseDto {

    private Integer id;
    private List<String> codigos;
    private String descricao;
    private Integer categoriaId;
    private String imagem;
    private BigDecimal valorCompra;
    private BigDecimal precoEmpresa;
    private BigDecimal precoConsumidor;
    private Integer quantidade;
    private CriteriosDto faixaPropria;

    public ProdutoResponseDto() {
    }

    public ProdutoResponseDto(Integer id, List<String> codigos, String descricao, Integer categoriaId, String imagem, BigDecimal valorCompra, BigDecimal precoEmpresa, BigDecimal precoConsumidor, Integer quantidade, CriteriosDto faixaPropria) {
        this.id = id;
        this.codigos = codigos;
        this.descricao = descricao;
        this.categoriaId = categoriaId;
        this.imagem = imagem;
        this.valorCompra = valorCompra;
        this.precoEmpresa = precoEmpresa;
        this.precoConsumidor = precoConsumidor;
        this.quantidade = quantidade;
        this.faixaPropria = faixaPropria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<String> getCodigos() {
        return codigos;
    }

    public void setCodigos(List<String> codigos) {
        this.codigos = codigos;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
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

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public CriteriosDto getFaixaPropria() {
        return faixaPropria;
    }

    public void setFaixaPropria(CriteriosDto faixaPropria) {
        this.faixaPropria = faixaPropria;
    }
}
