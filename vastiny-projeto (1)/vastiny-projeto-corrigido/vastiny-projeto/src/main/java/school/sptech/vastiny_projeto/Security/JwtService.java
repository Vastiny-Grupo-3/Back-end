package school.sptech.vastiny_projeto.Security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import school.sptech.vastiny_projeto.entity.Usuario;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String segredo;

    @Value("${jwt.expiracao-minutos}")
    private Long expiracaoMinutos;

    private SecretKey chave() {
        return Keys.hmacShaKeyFor(this.segredo.getBytes(StandardCharsets.UTF_8));
    }

    public String gerarToken(Usuario usuario) {
        return Jwts.builder()
                .subject(String.valueOf(usuario.getId()))
                .claim("nome", usuario.getNome())
                .claim("email", usuario.getEmail())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60L * this.expiracaoMinutos))
                .signWith(chave())
                .compact();
    }

    public Claims extrairClaims (String token) {
        return Jwts.parser()
                .verifyWith(chave())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public Integer extrairId (String token) {
        return Integer.parseInt(extrairClaims(token).getSubject());
    }

    public boolean tokenValido (String token) {
        try {
            extrairClaims(token);
            return true;
        } catch (JwtException | IllegalArgumentException ex) {
            return false;
        }
    }
}
