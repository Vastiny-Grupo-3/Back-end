package school.sptech.vastiny_projeto.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import school.sptech.vastiny_projeto.DTO.Produto.ProdutoResponseDto;
import school.sptech.vastiny_projeto.Mapper.ProdutoMapper;
import school.sptech.vastiny_projeto.Service.ProdutoService;
import school.sptech.vastiny_projeto.entity.Produto;

import java.util.List;

@Tag(name = "Produtos", description = "Consulta de produtos")
@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @Operation(summary = "Listar produtos", description = "Retorna a lista de todos os produtos cadastrados.")
    @GetMapping
    public ResponseEntity<List<ProdutoResponseDto>> getAll() {
        List<Produto> produtos = this.produtoService.getAll();
        List<ProdutoResponseDto> dtoResponseList = ProdutoMapper.toResponseList(produtos);
        return ResponseEntity.status(200).body(dtoResponseList);
    }

    @Operation(summary = "Buscar produto por ID", description = "Retorna os dados de um produto específico. Retorna 404 se não existir.")
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDto> getById(@PathVariable Integer id) {
        Produto produto = this.produtoService.getById(id);
        ProdutoResponseDto dtoResponse = ProdutoMapper.toResponse(produto);
        return ResponseEntity.status(200).body(dtoResponse);
    }
}
