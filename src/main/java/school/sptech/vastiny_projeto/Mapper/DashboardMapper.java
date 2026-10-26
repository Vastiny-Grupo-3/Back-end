package school.sptech.vastiny_projeto.Mapper;

import org.springframework.stereotype.Component;
import school.sptech.vastiny_projeto.DTO.Dashboard.CategoriaVendidaDTO;
import school.sptech.vastiny_projeto.DTO.Dashboard.EstoqueDTO;
import school.sptech.vastiny_projeto.DTO.Dashboard.KpiVendasDTO;
import school.sptech.vastiny_projeto.DTO.Dashboard.TopProdutoDTO;
import school.sptech.vastiny_projeto.DTO.projection.CategoriaVendidaProjection;
import school.sptech.vastiny_projeto.DTO.projection.EstoqueResumoProjection;
import school.sptech.vastiny_projeto.DTO.projection.ResumoVendasProjection;
import school.sptech.vastiny_projeto.DTO.projection.TopProdutoProjection;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Component
public class DashboardMapper {

    public static KpiVendasDTO toKpi(ResumoVendasProjection p) {
        long total = p.getTotalVendas() == null ? 0 : p.getTotalVendas();
        BigDecimal faturamento = p.getFaturamento() == null ? BigDecimal.ZERO : p.getFaturamento();
        BigDecimal lucro = p.getLucro() == null ? BigDecimal.ZERO : p.getLucro();

        BigDecimal media = total == 0
                ? BigDecimal.ZERO
                : faturamento.divide(BigDecimal.valueOf(total), 2, RoundingMode.HALF_UP);
        return new  KpiVendasDTO(total, faturamento, lucro, media);
    }
    public static List<CategoriaVendidaDTO> toCategorias(List<CategoriaVendidaProjection> lista) {
        return lista.stream().map(c -> new CategoriaVendidaDTO(c.getCategoria(), c.getFaturado())).toList();
    }

    public static List<TopProdutoDTO> toTopProdutos(List<TopProdutoProjection> lista) {
        return  lista.stream().map(t -> new TopProdutoDTO(
                t.getCodigo(),
                t.getNome(),
                t.getCategoria(),
                t.getQtdVendida(),
                t.getFaturado(),
                t.getLucro())).toList();
    }

    public static EstoqueDTO toEstoque(EstoqueResumoProjection e) {
        long bom = e.getBom() == null ? 0 : e.getBom();
        long medio = e.getMedio() == null ? 0 : e.getMedio();
        long ruim = e.getRuim() == null ? 0 : e.getRuim();
        long critico = e.getCritico() == null ? 0 : e.getCritico();
         return  new EstoqueDTO(bom, medio, ruim, critico, ruim + critico);
    }
}
