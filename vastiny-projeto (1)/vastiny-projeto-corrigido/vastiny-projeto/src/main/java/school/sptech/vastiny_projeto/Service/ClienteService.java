package school.sptech.vastiny_projeto.Service;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Service;
import school.sptech.vastiny_projeto.Exception.NaoEncontradoException;
import school.sptech.vastiny_projeto.Repository.ClienteRepository;
import school.sptech.vastiny_projeto.entity.Cliente;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClienteService {


    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
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
    public Cliente criar(Cliente cliente){
        cliente.setDataCadastro(LocalDateTime.now());
        return clienteRepository.save(cliente);
    }

    //Put
    public Cliente atualizar(Integer id, Cliente cliente){
        if(!clienteRepository.existsById(id)){
            throw new NaoEncontradoException("Cliente não encontrado");
        }

        cliente.setId(id);
        return clienteRepository.save(cliente);
    }

    //delete
    public void excluir(Integer id){
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new NaoEncontradoException("Cliente não encontrado"));

        clienteRepository.delete(cliente);
    }




}
