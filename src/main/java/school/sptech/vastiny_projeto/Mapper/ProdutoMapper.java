package school.sptech.vastiny_projeto.Mapper;

import school.sptech.vastiny_projeto.DTO.Produto.ProdutoResponseDto;
import school.sptech.vastiny_projeto.entity.Produto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProdutoMapper {

    public static ProdutoResponseDto toResponse(Produto produto) {
        return new ProdutoResponseDto(
                produto.getId(),
                new ArrayList<>(Arrays.asList(
                        produto.getCodigo1() != null ? produto.getCodigo1() : "",
                        produto.getCodigo2() != null ? produto.getCodigo2() : "",
                        produto.getCodigo3() != null ? produto.getCodigo3() : "",
                        produto.getCodigo4() != null ? produto.getCodigo4() : "")),
                produto.getDescricao(),
                produto.getCategoria().getId(),
                produto.getFoto(),
                produto.getValorCompra(),
                produto.getPrecoEmpresa(),
                produto.getPrecoConsumidor(),
                produto.getQtdEstoque(),
                null
        );
    }

    public static List<ProdutoResponseDto> toResponseList(List<Produto> produtos) {
        List<ProdutoResponseDto> dtoList = new ArrayList<>();
        for (Produto produto : produtos) {
            dtoList.add(toResponse(produto));
        }
        return dtoList;
    }
}
