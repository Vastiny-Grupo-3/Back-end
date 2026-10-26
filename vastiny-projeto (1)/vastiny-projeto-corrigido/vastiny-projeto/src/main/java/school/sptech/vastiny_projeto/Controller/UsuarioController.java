package school.sptech.vastiny_projeto.Controller;


import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.vastiny_projeto.DTO.Usuario.UsuarioRequestDto;
import school.sptech.vastiny_projeto.DTO.Usuario.UsuarioResponseDto;
import school.sptech.vastiny_projeto.Mapper.UsuarioMapper;
import school.sptech.vastiny_projeto.Service.UsuarioService;
import school.sptech.vastiny_projeto.entity.Usuario;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDto>> listar(){
        List<Usuario> usuarioList = usuarioService.listar();

        return ResponseEntity.status(200).body(UsuarioMapper.toResponse(usuarioList));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto> buscarPorId(@PathVariable Integer id){
        Usuario usuarioId = usuarioService.buscarPorId(id);
        return ResponseEntity.status(200).body(UsuarioMapper.toResponse(usuarioId));
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDto> criar(@RequestBody @Valid UsuarioRequestDto request){
        Usuario usuarioRequest = UsuarioMapper.toEntity(request);

        Usuario salvo = usuarioService.criar(usuarioRequest);

        return ResponseEntity.status(201).body(UsuarioMapper.toResponse(salvo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto> atualizar(@PathVariable Integer id, @RequestBody @Valid UsuarioRequestDto request){
        Usuario usuarioAtual = UsuarioMapper.toEntity(request);

        Usuario atualizado = usuarioService.atualizar(id, usuarioAtual);

        return ResponseEntity.status(200).body(UsuarioMapper.toResponse(atualizado));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id){
        usuarioService.excluir(id);

        return ResponseEntity.status(204).build();
    }




}
