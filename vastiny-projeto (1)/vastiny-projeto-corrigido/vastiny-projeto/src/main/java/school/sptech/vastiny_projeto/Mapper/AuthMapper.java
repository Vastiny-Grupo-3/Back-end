package school.sptech.vastiny_projeto.Mapper;

import school.sptech.vastiny_projeto.DTO.Auth.AuthRequestDto;
import school.sptech.vastiny_projeto.entity.Usuario;

public class AuthMapper {

    public static Usuario toEntity(AuthRequestDto dto) {
        Usuario usuario = new Usuario();
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());
        return usuario;
    }


}
