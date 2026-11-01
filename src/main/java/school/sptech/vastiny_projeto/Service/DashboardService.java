package school.sptech.vastiny_projeto.Service;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import school.sptech.vastiny_projeto.DTO.Dashboard.DashboardDTO;
import school.sptech.vastiny_projeto.Mapper.DashboardMapper;
import school.sptech.vastiny_projeto.Repository.ItemVendaRepository;
import school.sptech.vastiny_projeto.Repository.ProdutoRepository;
import school.sptech.vastiny_projeto.Repository.VendaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DashboardService {

    private final ItemVendaRepository itemVendaRepository;
    private final ProdutoRepository produtoRepository;
    private final DashboardMapper mapper;

    public DashboardService(ItemVendaRepository itemVendaRepository, ProdutoRepository produtoRepository, DashboardMapper mapper) {
        this.itemVendaRepository = itemVendaRepository;
        this.produtoRepository = produtoRepository;
        this.mapper = mapper;
    }

    @Transactional(readOnly = true)
    public DashboardDTO montar(LocalDate inicio, LocalDate fim, List<Integer> categorias) {
        LocalDateTime i = inicio.atStartOfDay();
        LocalDateTime f = fim.plusDays(1).atStartOfDay(); // inclui o dia inteiro

        boolean filtrar = categorias != null && !categorias.isEmpty();
        List<Integer> ids = filtrar ? categorias : List.of(-1);

        return new DashboardDTO(
                mapper.toKpi(itemVendaRepository.resumo(i, f, filtrar, ids)),
                mapper.toCategorias(itemVendaRepository.categorias(i, f, PageRequest.of(0, 6))),
                mapper.toTopProdutos(itemVendaRepository.topProdutos(i, f, filtrar, ids, PageRequest.of(0, 10))),
                mapper.toEstoque(produtoRepository.estoqueResumo())
        );
    }
}
