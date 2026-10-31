package school.sptech.vastiny_projeto.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class TratadorDeExcecoes extends RuntimeException {
    public TratadorDeExcecoes(String message) {
        super(message);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> validacao(MethodArgumentNotValidException ex) {
        Map<String, String> erros = new LinkedHashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(erro -> erros.putIfAbsent(erro.getField(), erro.getDefaultMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("erros", erros));
    }

    @ExceptionHandler(ConflitoException.class)
    public ResponseEntity<Map<String, Object>> conflito(ConflitoException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Map.of("erros", Map.of(ex.getCampo(), ex.getMessage())));
    }

    @ExceptionHandler(NaoEncontradoException.class)
    public ResponseEntity<Map<String, String>> naoEncontrado(NaoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("erro", ex.getMessage()));
    }

    @ExceptionHandler(CredenciaisInvalidasException.class)
    public ResponseEntity<Map<String, String>> credenciais(CredenciaisInvalidasException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("erro", ex.getMessage()));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, String>> corpoInvalido(HttpMessageNotReadableException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("erro", "Corpo da requisição inválido."));
    }

    @ExceptionHandler(ValidacaoException.class)
    public ResponseEntity<Map<String, Object>> validacaoNegocio(ValidacaoException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Map.of("erros", Map.of(ex.getCampo(), ex.getMessage())));
    }
}
