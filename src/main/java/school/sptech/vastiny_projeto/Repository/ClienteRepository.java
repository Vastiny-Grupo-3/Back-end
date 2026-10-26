package school.sptech.vastiny_projeto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.sptech.vastiny_projeto.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
