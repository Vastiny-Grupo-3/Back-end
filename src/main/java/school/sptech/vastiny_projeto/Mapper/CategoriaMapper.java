package school.sptech.vastiny_projeto.Mapper;

import school.sptech.vastiny_projeto.DTO.Categoria.CategoriaRequestDto;
import school.sptech.vastiny_projeto.DTO.Categoria.CategoriaResponseDto;
import school.sptech.vastiny_projeto.DTO.Categoria.CriteriosDto;
import school.sptech.vastiny_projeto.entity.Categoria;

import java.util.ArrayList;
import java.util.List;

public class CategoriaMapper {

    public static Categoria toEntity(CategoriaRequestDto dto) {
        return new Categoria (
                null,
                dto.getNome().trim(),
                dto.getCriterios().getCritico(),
                dto.getCriterios().getRuim(),
                dto.getCriterios().getMedio(),
                dto.getCriterios().getBom()
        );
    }

    public static CategoriaResponseDto toResponse(Categoria entity) {
        return new CategoriaResponseDto(
                entity.getId(),
                entity.getNome(),
                new CriteriosDto(
                        entity.getNivelBom(),
                        entity.getNivelMedio(),
                        entity.getNivelRuim(),
                        entity.getNivelCritico()
                )
        );
    }

    public static List<CategoriaResponseDto> toResponseList(List<Categoria> list) {
        List<CategoriaResponseDto> dtoList = new ArrayList<>();
        for (Categoria categoria : list) {
            dtoList.add(toResponse(categoria));
        }

        return dtoList;
    }
}
