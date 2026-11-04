package school.sptech.vastiny_projeto.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.vastiny_projeto.DTO.ClienteVersao.ClienteVersaoResponseDto;
import school.sptech.vastiny_projeto.DTO.Clientes.ClienteRequestDto;
import school.sptech.vastiny_projeto.DTO.Clientes.ClienteResponseDto;
import school.sptech.vastiny_projeto.Mapper.ClienteMapper;
import school.sptech.vastiny_projeto.Service.ClienteService;
import school.sptech.vastiny_projeto.entity.Cliente;
import school.sptech.vastiny_projeto.entity.ClienteVersao;

import java.util.List;

@Tag(name = "Clientes", description = "Gerenciamento de clientes e histórico de versões")
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    public final ClienteService clienteService;


    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }



    @Operation(summary = "Listar versões de clientes", description = "Retorna o histórico de versões (alterações) registradas dos clientes.")
    @GetMapping("/versoes")
    public ResponseEntity<List<ClienteVersaoResponseDto>> GetAllVersoes() {
        List<ClienteVersao> clienteVersaoList = this.clienteService.listarVersoes();
        List<ClienteVersaoResponseDto> dtoResponseList = ClienteMapper.toVersoes(clienteVersaoList);
        return ResponseEntity.status(200).body(dtoResponseList);
    }



    @Operation(summary = "Listar clientes", description = "Retorna a lista de todos os clientes cadastrados.")
    @GetMapping
    public ResponseEntity<List<ClienteResponseDto>> listar(){
        List<Cliente> clienteList = clienteService.listar();

        return ResponseEntity.status(200).body(ClienteMapper.toResponse(clienteList));
    }


    @Operation(summary = "Buscar cliente por ID", description = "Retorna os detalhes de um cliente específico pelo ID. Retorna 404 se não existir.")
    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDto> buscarPorId(@PathVariable Integer id){

        Cliente clienteId = clienteService.buscarPorId(id);

        return ResponseEntity.status(200).body(ClienteMapper.toResponse(clienteId));

    }

    @Operation(summary = "Criar cliente", description = "Cadastra um novo cliente e retorna o cliente criado (201).")
    @PostMapping
    public ResponseEntity<ClienteResponseDto> criar(@RequestBody @Valid ClienteRequestDto request){
        Cliente clienteRequest = ClienteMapper.toEntity(request);

        Cliente salvo = clienteService.criar(clienteRequest);

        return ResponseEntity.status(201).body(ClienteMapper.toResponse(salvo));
    }

    @Operation(summary = "Atualizar cliente", description = "Atualiza os dados de um cliente existente pelo ID.")
    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponseDto> atualizar(@PathVariable Integer id, @RequestBody @Valid ClienteRequestDto request){
        Cliente clienteRequest = ClienteMapper.toEntity(request);

        Cliente clienteAtualizar = clienteService.atualizar(id, clienteRequest);

        return ResponseEntity.status(200).body(ClienteMapper.toResponse(clienteAtualizar));
    }

    @Operation(summary = "Excluir cliente", description = "Remove o cliente pelo ID. Retorna 204 sem corpo.")
   @DeleteMapping("/{id}")
   public ResponseEntity<Void> excluir(@PathVariable Integer id){
        clienteService.excluir(id);

        return ResponseEntity.status(204).build();
   }


}
