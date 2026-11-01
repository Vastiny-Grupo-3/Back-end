package school.sptech.vastiny_projeto.Controller;


import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import school.sptech.vastiny_projeto.DTO.Usuario.AtualizarContaRequestDto;
import school.sptech.vastiny_projeto.DTO.Usuario.ExcluirContaRequestDto;
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

//    @GetMapping
//    public ResponseEntity<List<UsuarioResponseDto>> listar(){
//        List<Usuario> usuarioList = usuarioService.listar();
//
//        return ResponseEntity.status(200).body(UsuarioMapper.toResponse(usuarioList));
//    }

//    @GetMapping("/{id}")
//    public ResponseEntity<UsuarioResponseDto> buscarPorId(@PathVariable Integer id){
//        Usuario usuarioId = usuarioService.buscarPorId(id);
//        return ResponseEntity.status(200).body(UsuarioMapper.toResponse(usuarioId));
//    }

    @GetMapping("/me")
    public ResponseEntity<UsuarioResponseDto> minhaConta(Authentication authentication) {
        Integer id = (Integer) authentication.getPrincipal();
        Usuario usuario = this.usuarioService.buscarPorId(id);
        UsuarioResponseDto dtoResponse = UsuarioMapper.toResponse(usuario);
        return ResponseEntity.status(200).body(dtoResponse);
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDto> criar(@RequestBody @Valid UsuarioRequestDto request){
        Usuario usuarioRequest = UsuarioMapper.toEntity(request);

        Usuario salvo = usuarioService.criar(usuarioRequest);

        return ResponseEntity.status(201).body(UsuarioMapper.toResponse(salvo));
    }

    @PutMapping("/me")
    public ResponseEntity<UsuarioResponseDto> atualizarMinhaConta(
            Authentication authentication,
            @RequestBody @Valid AtualizarContaRequestDto request
            ) {
        Integer id = (Integer) authentication.getPrincipal();
        Usuario usuario = this.usuarioService.atualizar(id, request);
        UsuarioResponseDto dtoResponse = UsuarioMapper.toResponse(usuario);
        return ResponseEntity.status(200).body(dtoResponse);
    }

    @DeleteMapping("/me")
    public ResponseEntity<Void> excluirMinhaConta(
            Authentication authentication,
            @RequestBody @Valid ExcluirContaRequestDto request
            ) {
        Integer id = (Integer) authentication.getPrincipal();
        this.usuarioService.excluir(id, request.getSenhaAtual());
        return ResponseEntity.status(204).build();
    }



}
