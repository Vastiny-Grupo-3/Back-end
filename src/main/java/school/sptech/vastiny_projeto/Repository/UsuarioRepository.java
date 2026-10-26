package school.sptech.vastiny_projeto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.sptech.vastiny_projeto.entity.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

    Optional<Usuario> findByEmail (String email);

}
