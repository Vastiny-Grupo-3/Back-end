package school.sptech.vastiny_projeto.Service;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import school.sptech.vastiny_projeto.DTO.Dashboard.DashboardDTO;
import school.sptech.vastiny_projeto.DTO.Dashboard.EstoqueDTO;
import school.sptech.vastiny_projeto.DTO.Dashboard.VendasDTO;
import school.sptech.vastiny_projeto.Exception.ValidacaoException;
import school.sptech.vastiny_projeto.Mapper.DashboardMapper;
import school.sptech.vastiny_projeto.Repository.ItemVendaRepository;
import school.sptech.vastiny_projeto.Repository.ProdutoRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DashboardService {

    private static final int LIMITE_CATEGORIAS = 6;
    private static final int LIMITE_TOP_PRODUTOS = 10;

    private final ItemVendaRepository itemVendaRepository;
    private final ProdutoRepository produtoRepository;
    private final DashboardMapper mapper;

    public DashboardService(ItemVendaRepository itemVendaRepository, ProdutoRepository produtoRepository, DashboardMapper mapper) {
        this.itemVendaRepository = itemVendaRepository;
        this.produtoRepository = produtoRepository;
        this.mapper = mapper;
    }

    /** Dashboard completo (aba Vendas + aba Estoque) em uma única chamada. */
    @Transactional(readOnly = true)
    public DashboardDTO montar(LocalDate inicio, LocalDate fim, List<Integer> categorias) {
        VendasDTO vendas = montarVendas(inicio, fim, categorias);
        return new DashboardDTO(vendas.kpis(), vendas.categorias(), vendas.topProdutos(), montarEstoque());
    }

    /** Aba "Vendas": KPIs, categorias mais vendidas e Top 10 produtos no período. */
    @Transactional(readOnly = true)
    public VendasDTO montarVendas(LocalDate inicio, LocalDate fim, List<Integer> categorias) {
        if (inicio.isAfter(fim)) {
            throw new ValidacaoException("A data inicial não pode ser maior que a data final.", "inicio");
        }

        LocalDateTime i = inicio.atStartOfDay();
        LocalDateTime f = fim.plusDays(1).atStartOfDay(); // inclui o dia inteiro

        boolean filtrar = categorias != null && !categorias.isEmpty();
        List<Integer> ids = filtrar ? categorias : List.of(-1);

        return mapper.toVendas(
                itemVendaRepository.resumo(i, f, filtrar, ids),
                itemVendaRepository.categorias(i, f, PageRequest.of(0, LIMITE_CATEGORIAS)),
                itemVendaRepository.topProdutos(i, f, filtrar, ids, PageRequest.of(0, LIMITE_TOP_PRODUTOS))
        );
    }

    /** Aba "Estoque": quantidade de produtos ativos por nível de estoque. */
    @Transactional(readOnly = true)
    public EstoqueDTO montarEstoque() {
        return mapper.toEstoque(produtoRepository.estoqueResumo());
    }
}
