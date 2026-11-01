package school.sptech.vastiny_projeto.Service;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import school.sptech.vastiny_projeto.Enums.TipoCliente;
import school.sptech.vastiny_projeto.Exception.NaoEncontradoException;
import school.sptech.vastiny_projeto.Repository.ClienteRepository;
import school.sptech.vastiny_projeto.Repository.ClienteVersaoRepository;
import school.sptech.vastiny_projeto.Repository.VendaRepository;
import school.sptech.vastiny_projeto.entity.Cliente;
import school.sptech.vastiny_projeto.entity.ClienteVersao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClienteService {


    private final ClienteRepository clienteRepository;
    private final ClienteVersaoRepository clienteVersaoRepository;
    private final VendaRepository vendaRepository;

    public ClienteService(ClienteRepository clienteRepository, ClienteVersaoRepository clienteVersaoRepository, VendaRepository vendaRepository) {
        this.clienteRepository = clienteRepository;
        this.clienteVersaoRepository = clienteVersaoRepository;
        this.vendaRepository = vendaRepository;
    }

    //Get
    public List<Cliente> listar(){
        return clienteRepository.findAll();
    }

    //Get id
    public Cliente buscarPorId(Integer id){
        return clienteRepository.findById(id).orElseThrow(()-> new NaoEncontradoException("Cliente não encontrado"));
    }

    //Post
    @Transactional
    public Cliente criar(Cliente cliente){
        cliente.setDataCadastro(LocalDateTime.now());
        if (cliente.getTipo() == null) cliente.setTipo(TipoCliente.PESSOA_FISICA);
        if (cliente.getDescricao() == null) cliente.setDescricao("");

        Cliente clienteSalvo = this.clienteRepository.save(cliente);
        registrarVersao(clienteSalvo);
        return clienteSalvo;
    }

    //Put
    @Transactional
    public Cliente atualizar(Integer id, Cliente cliente){
        Cliente clienteBanco = this.buscarPorId(id);

        String descricao = cliente.getDescricao() == null ? "" : cliente.getDescricao().trim();

        TipoCliente tipo = cliente.getTipo() == null ? TipoCliente.PESSOA_FISICA : cliente.getTipo();

        boolean mudou = !Objects.equals(clienteBanco.getNome(), cliente.getNome().trim())
                || !Objects.equals(clienteBanco.getTelefone(), cliente.getTelefone().trim())
                || !Objects.equals(clienteBanco.getDescricao(), descricao)
                || cliente.getTipo() != tipo;

        clienteBanco.setNome(cliente.getNome().trim());
        clienteBanco.setTelefone(cliente.getTelefone().trim());
        clienteBanco.setDescricao(descricao);
        clienteBanco.setTipo(tipo);

        Cliente clienteSalvado = this.clienteRepository.save(clienteBanco);
        if (mudou) registrarVersao(clienteSalvado);
        return clienteSalvado;
    }

    //delete
    @Transactional
    public void excluir(Integer id){
        Cliente cliente = this.buscarPorId(id);
        this.vendaRepository.desvincularCliente(id);
        this.clienteVersaoRepository.deleteByClienteId(id);
        clienteRepository.delete(cliente);
    }

    public List<ClienteVersao> listarVersoes() {
        return this.clienteVersaoRepository.findAllByOrderByIdAsc();
    }

    private void registrarVersao(Cliente cliente) {
        ClienteVersao clienteVersao = new ClienteVersao(
                null,
                cliente,
                cliente.getNome(),
                cliente.getTelefone(),
                cliente.getDescricao(),
                cliente.getTipo(),
                LocalDate.now()
        );
        clienteVersaoRepository.save(clienteVersao);
    }
}
