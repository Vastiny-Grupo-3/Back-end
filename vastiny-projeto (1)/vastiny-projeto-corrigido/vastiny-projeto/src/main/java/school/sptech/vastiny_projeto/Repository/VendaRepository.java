package school.sptech.vastiny_projeto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import school.sptech.vastiny_projeto.DTO.projection.ResumoVendasProjection;
import school.sptech.vastiny_projeto.entity.Venda;

import java.time.LocalDateTime;

public interface VendaRepository extends JpaRepository<Venda,Integer> {

    @Query("""
SELECT COUNT(v)   AS totalVendas,
   COALESCE(SUM(v.valortotal), 0) AS faturamento,
   COALESCE(SUM(v.valorlucro), 0) AS lucro
   FROM Venda v
   WHERE v.dataHora >= :inicio AND v.dataHora < :fim
""")
    ResumoVendasProjection resumo(@Param("inicio")LocalDateTime inicio, @Param("fim")LocalDateTime fim);
}
