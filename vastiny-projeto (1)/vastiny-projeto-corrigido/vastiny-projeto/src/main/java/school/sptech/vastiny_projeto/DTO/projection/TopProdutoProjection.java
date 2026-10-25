package school.sptech.vastiny_projeto.DTO.projection;

import java.math.BigDecimal;

    public interface TopProdutoProjection {
        String getCodigo();
        String getNome();
        String getCategoria();
        Long getQtdVendida();
        BigDecimal getFaturado();
        BigDecimal getLucro();
    }

