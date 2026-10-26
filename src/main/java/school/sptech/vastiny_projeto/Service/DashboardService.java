package school.sptech.vastiny_projeto.Service;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import school.sptech.vastiny_projeto.DTO.Dashboard.DashboardDTO;
import school.sptech.vastiny_projeto.Mapper.DashboardMapper;
import school.sptech.vastiny_projeto.Repository.ItemVendaRepository;
import school.sptech.vastiny_projeto.Repository.PecaRepository;
import school.sptech.vastiny_projeto.Repository.VendaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class DashboardService {

    private final VendaRepository vendaRepository;
    private final ItemVendaRepository itemVendaRepository;
    private final PecaRepository pecaRepository;
    private final DashboardMapper mapper;

    public DashboardService(VendaRepository vendaRepository, ItemVendaRepository itemVendaRepository, PecaRepository pecaRepository, DashboardMapper mapper) {
        this.vendaRepository = vendaRepository;
        this.itemVendaRepository = itemVendaRepository;
        this.pecaRepository = pecaRepository;
        this.mapper = mapper;
    }

    @Transactional(readOnly = true)
    public DashboardDTO montar(LocalDate inicio, LocalDate fim) {
        LocalDateTime i = inicio.atStartOfDay();
        LocalDateTime f = fim.plusDays(1).atStartOfDay(); // inclui o dia inteiro

        return new DashboardDTO(
                mapper.toKpi(vendaRepository.resumo(i, f)),
                mapper.toCategorias(itemVendaRepository.categorias(i, f, PageRequest.of(0, 5))),
                mapper.toTopProdutos(itemVendaRepository.topProdutos(i, f, PageRequest.of(0, 10))),
                mapper.toEstoque(pecaRepository.estoqueResumo())
        );
    }
}
