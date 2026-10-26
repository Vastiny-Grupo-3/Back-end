package school.sptech.vastiny_projeto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import school.sptech.vastiny_projeto.DTO.projection.EstoqueResumoProjection;
import school.sptech.vastiny_projeto.entity.Peca;

public interface PecaRepository extends JpaRepository<Peca,Integer> {
    @Query("""
SELECT
  COALESCE(SUM (CASE WHEN p.qtdEstoque >= c.nivelBom  THEN 1 ELSE 0 END), 0L) AS bom,
   COALESCE(SUM(CASE WHEN p.qtdEstoque <  c.nivelBom
                               AND p.qtdEstoque >= c.nivelMedio THEN 1 ELSE 0 END), 0L) AS medio,
            COALESCE(SUM(CASE WHEN p.qtdEstoque <  c.nivelMedio
                               AND p.qtdEstoque >= c.nivelRuim THEN 1 ELSE 0 END), 0L) AS ruim,
            COALESCE(SUM(CASE WHEN p.qtdEstoque <  c.nivelRuim THEN 1 ELSE 0 END), 0L) AS critico
          FROM Peca p JOIN p.categoria c
          
""")
    EstoqueResumoProjection estoqueResumo();
}
