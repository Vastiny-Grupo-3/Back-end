package school.sptech.vastiny_projeto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.sptech.vastiny_projeto.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria,Integer>
{
}
