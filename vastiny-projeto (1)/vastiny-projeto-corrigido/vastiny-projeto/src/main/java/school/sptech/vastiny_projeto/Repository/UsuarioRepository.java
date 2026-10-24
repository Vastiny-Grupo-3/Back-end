package school.sptech.vastiny_projeto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.sptech.vastiny_projeto.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

}
