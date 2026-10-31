package school.sptech.vastiny_projeto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import school.sptech.vastiny_projeto.entity.ClienteVersao;

import java.util.List;

@Repository
public interface ClienteVersaoRepository extends JpaRepository<ClienteVersao, Integer> {

    List<ClienteVersao> findAllByOrderByIdAsc();

    void deleteByClienteId(Integer clienteId);
}
