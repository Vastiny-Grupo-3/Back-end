package school.sptech.vastiny_projeto.Controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.vastiny_projeto.DTO.Categoria.CategoriaRequestDto;
import school.sptech.vastiny_projeto.DTO.Categoria.CategoriaResponseDto;
import school.sptech.vastiny_projeto.Mapper.CategoriaMapper;
import school.sptech.vastiny_projeto.Service.CategoriaService;
import school.sptech.vastiny_projeto.entity.Categoria;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public ResponseEntity<List<CategoriaResponseDto>> getAll() {
        List<Categoria> categorias = this.categoriaService.getAll();
        List<CategoriaResponseDto> dtoResponseList = CategoriaMapper.toResponseList(categorias);
        return ResponseEntity.status(200).body(dtoResponseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResponseDto> getById(@PathVariable Integer id) {
        Categoria categoria = this.categoriaService.getById(id);
        CategoriaResponseDto dtoResponse = CategoriaMapper.toResponse(categoria);
        return ResponseEntity.status(200).body(dtoResponse);
    }

    @PostMapping
    public ResponseEntity<CategoriaResponseDto> create(
            @RequestBody @Valid CategoriaRequestDto request
            ) {
        Categoria categoria = CategoriaMapper.toEntity(request);
        Categoria categoriaSalva = this.categoriaService.create(categoria);
        CategoriaResponseDto dtoResponse = CategoriaMapper.toResponse(categoriaSalva);
        return ResponseEntity.status(201).body(dtoResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaResponseDto> update(
            @PathVariable Integer id,
            @RequestBody @Valid CategoriaRequestDto request
    ) {
        Categoria categoria = CategoriaMapper.toEntity(request);
        Categoria categoriaAlterada = this.categoriaService.update(id, categoria);
        CategoriaResponseDto dtoResponse = CategoriaMapper.toResponse(categoriaAlterada);
        return ResponseEntity.status(200).body(dtoResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Integer id
    ) {
        this.categoriaService.delete(id);
        return ResponseEntity.status(204).build();
    }
}
