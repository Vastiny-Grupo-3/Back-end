package school.sptech.vastiny_projeto.DTO.Dashboard;

import java.math.BigDecimal;

public record KpiVendasDTO(long vendasNoPeriodo,
                           BigDecimal faturamento,
                           BigDecimal lucro,
                           BigDecimal precoMedio) {
}
