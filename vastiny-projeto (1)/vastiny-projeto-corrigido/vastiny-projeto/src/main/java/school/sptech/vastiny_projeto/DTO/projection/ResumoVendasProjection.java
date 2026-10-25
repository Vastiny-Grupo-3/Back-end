package school.sptech.vastiny_projeto.DTO.projection;import java.math.BigDecimal;

import java.math.BigDecimal;

public interface ResumoVendasProjection {
    Long getTotalVendas();
    BigDecimal getFaturamento();
    BigDecimal getLucro();
}
