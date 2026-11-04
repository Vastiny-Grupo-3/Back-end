package school.sptech.vastiny_projeto.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import school.sptech.vastiny_projeto.DTO.Dashboard.DashboardDTO;
import school.sptech.vastiny_projeto.DTO.Dashboard.EstoqueDTO;
import school.sptech.vastiny_projeto.DTO.Dashboard.VendasDTO;
import school.sptech.vastiny_projeto.Service.DashboardService;

import java.time.LocalDate;
import java.util.List;

@Tag(name = "Dashboard", description = "Indicadores de vendas e estoque")
@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    private final DashboardService service;

    public DashboardController(DashboardService service) {
        this.service = service;
    }

    @Operation(summary = "Obter dashboard completo", description = "Retorna os indicadores (KPIs de vendas, categorias mais vendidas, top produtos e resumo de estoque) no período informado (inicio e fim, formato AAAA-MM-DD). O filtro de categorias é opcional.")
    @GetMapping
    public ResponseEntity<DashboardDTO> getDashboard(
            @Parameter(description = "Data inicial do período (AAAA-MM-DD)", example = "2026-08-07")
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
            @Parameter(description = "Data final do período, inclusive (AAAA-MM-DD)", example = "2026-11-04")
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fim,
            @Parameter(description = "IDs das categorias para filtrar KPIs e Top 10 (opcional)")
            @RequestParam(required = false) List<Integer> categorias) {
        return ResponseEntity.ok(service.montar(inicio, fim, categorias));
    }

    @Operation(summary = "Obter aba Vendas do dashboard", description = "Retorna os dados da aba Vendas no período: KPIs (vendas, faturamento, lucro e preço médio), categorias mais vendidas e Top 10 produtos. O filtro de categorias é opcional e se aplica aos KPIs e ao Top 10.")
    @GetMapping("/vendas")
    public ResponseEntity<VendasDTO> getVendas(
            @Parameter(description = "Data inicial do período (AAAA-MM-DD)", example = "2026-08-07")
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
            @Parameter(description = "Data final do período, inclusive (AAAA-MM-DD)", example = "2026-11-04")
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fim,
            @Parameter(description = "IDs das categorias para filtrar KPIs e Top 10 (opcional)")
            @RequestParam(required = false) List<Integer> categorias) {
        return ResponseEntity.ok(service.montarVendas(inicio, fim, categorias));
    }

    @Operation(summary = "Obter aba Estoque do dashboard", description = "Retorna a quantidade de produtos ativos em cada nível de estoque (bom, médio, ruim e crítico) e o total que precisa de reposição. Não depende de período.")
    @GetMapping("/estoque")
    public ResponseEntity<EstoqueDTO> getEstoque() {
        return ResponseEntity.ok(service.montarEstoque());
    }
}
