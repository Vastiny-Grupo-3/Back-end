package school.sptech.vastiny_projeto.DTO.Dashboard;

import java.util.List;

/**
 * Dados da aba "Vendas" do dashboard:
 * cards de KPI, gráfico de categorias mais vendidas e Top 10 produtos.
 */
public record VendasDTO(KpiVendasDTO kpis,
                        List<CategoriaVendidaDTO> categorias,
                        List<TopProdutoDTO> topProdutos) {
}
