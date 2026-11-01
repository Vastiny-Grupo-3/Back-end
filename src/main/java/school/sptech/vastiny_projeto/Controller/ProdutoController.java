package school.sptech.vastiny_projeto.Controller;

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

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDto>> getAll() {
        List<Produto> produtos = this.produtoService.getAll();
        List<ProdutoResponseDto> dtoResponseList = ProdutoMapper.toResponseList(produtos);
        return ResponseEntity.status(200).body(dtoResponseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDto> getById(@PathVariable Integer id) {
        Produto produto = this.produtoService.getById(id);
        ProdutoResponseDto dtoResponse = ProdutoMapper.toResponse(produto);
        return ResponseEntity.status(200).body(dtoResponse);
    }
}
