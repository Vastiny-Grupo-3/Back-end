package school.sptech.vastiny_projeto.Mapper;

import school.sptech.vastiny_projeto.DTO.Clientes.ClienteRequestDto;
import school.sptech.vastiny_projeto.DTO.Clientes.ClienteResponseDto;
import school.sptech.vastiny_projeto.entity.Cliente;

import java.util.List;

public class ClienteMapper {



    public static Cliente toEntity(ClienteRequestDto request){
            Cliente cliente = new Cliente();
            cliente.setNome(request.getNome());
            cliente.setTelefone(request.getTelefone());
            cliente.setDescricao(request.getDescricao());

            return cliente;
    }

    public static ClienteResponseDto toResponse(Cliente cliente){

        ClienteResponseDto dto = new ClienteResponseDto();
        dto.setId(cliente.getId());
        dto.setNome(cliente.getNome());
        dto.setTelefone(cliente.getTelefone());
        dto.setDescricao(cliente.getDescricao());
        dto.setDataCadastro(cliente.getDataCadastro());

        return dto;

    }

    public static List<ClienteResponseDto> toResponse(List<Cliente> clientes){
        return clientes.stream().map(ClienteMapper::toResponse).toList();
    }

}
