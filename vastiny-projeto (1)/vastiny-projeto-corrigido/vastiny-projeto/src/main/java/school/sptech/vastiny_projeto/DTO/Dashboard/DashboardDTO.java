package school.sptech.vastiny_projeto.DTO.Dashboard;

import java.util.List;

public record DashboardDTO(KpiVendasDTO kpis,
                           List<CategoriaVendidaDTO> categorias,
                           List<TopProdutoDTO> topProdutos,
                           EstoqueDTO estoque) {
}
