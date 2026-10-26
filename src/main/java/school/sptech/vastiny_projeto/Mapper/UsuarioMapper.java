package school.sptech.vastiny_projeto.Mapper;

import school.sptech.vastiny_projeto.DTO.Usuario.UsuarioRequestDto;
import school.sptech.vastiny_projeto.DTO.Usuario.UsuarioResponseDto;
import school.sptech.vastiny_projeto.entity.Usuario;

import java.util.List;

public class UsuarioMapper {

    public static Usuario toEntity(UsuarioRequestDto request){

        Usuario usuario = new Usuario();
        usuario.setNome(request.getNome());
        usuario.setEmail(request.getEmail());
        usuario.setSenha(request.getSenha());

        return usuario;


    }

    public static UsuarioResponseDto toResponse(Usuario usuario){
        UsuarioResponseDto dto = new UsuarioResponseDto();
        dto.setId(usuario.getId());
        dto.setNome(usuario.getNome());
        dto.setEmail(usuario.getEmail());

        return dto;
    }

    public static List<UsuarioResponseDto> toResponse(List<Usuario> usuarios){
        return usuarios.stream().map(UsuarioMapper::toResponse).toList();
    }

}
