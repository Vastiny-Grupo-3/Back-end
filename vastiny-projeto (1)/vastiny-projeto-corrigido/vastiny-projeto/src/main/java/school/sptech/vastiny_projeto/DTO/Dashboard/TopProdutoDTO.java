package school.sptech.vastiny_projeto.DTO.Dashboard;

import java.math.BigDecimal;

public record TopProdutoDTO(String codigo,
                            String nome,
                            String categoria,
                            long qtdVendida,
                            BigDecimal faturado,
                            BigDecimal lucro) {
}
