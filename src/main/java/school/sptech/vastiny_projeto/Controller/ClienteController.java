package school.sptech.vastiny_projeto.Controller;


import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.vastiny_projeto.DTO.Clientes.ClienteRequestDto;
import school.sptech.vastiny_projeto.DTO.Clientes.ClienteResponseDto;
import school.sptech.vastiny_projeto.Mapper.ClienteMapper;
import school.sptech.vastiny_projeto.Service.ClienteService;
import school.sptech.vastiny_projeto.entity.Cliente;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    public final ClienteService clienteService;


    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }


    @GetMapping
    public ResponseEntity<List<ClienteResponseDto>> listar(){
        List<Cliente> clienteList = clienteService.listar();

        return ResponseEntity.status(200).body(ClienteMapper.toResponse(clienteList));
    }


    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDto> buscarPorId(@PathVariable Integer id){

        Cliente clienteId = clienteService.buscarPorId(id);

        return ResponseEntity.status(200).body(ClienteMapper.toResponse(clienteId));

    }

    @PostMapping
    public ResponseEntity<ClienteResponseDto> criar(@RequestBody @Valid ClienteRequestDto request){
        Cliente clienteRequest = ClienteMapper.toEntity(request);

        Cliente salvo = clienteService.criar(clienteRequest);

        return ResponseEntity.status(201).body(ClienteMapper.toResponse(salvo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponseDto> atualizar(@PathVariable Integer id, @RequestBody @Valid ClienteRequestDto request){
        Cliente clienteRequest = ClienteMapper.toEntity(request);

        Cliente clienteAtualizar = clienteService.atualizar(id, clienteRequest);

        return ResponseEntity.status(200).body(ClienteMapper.toResponse(clienteAtualizar));
    }

   @DeleteMapping("/{id}")
   public ResponseEntity<Void> excluir(@PathVariable Integer id){
        clienteService.excluir(id);

        return ResponseEntity.status(204).build();
   }


}
