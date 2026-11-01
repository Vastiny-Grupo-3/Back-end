package school.sptech.vastiny_projeto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import school.sptech.vastiny_projeto.DTO.projection.EstoqueResumoProjection;
import school.sptech.vastiny_projeto.entity.Produto;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Integer> {
    @Query("""
SELECT
  COALESCE(SUM (CASE WHEN p.qtdEstoque >= c.nivelBom  THEN 1 ELSE 0 END), 0L) AS bom,
   COALESCE(SUM(CASE WHEN p.qtdEstoque <  c.nivelBom
                               AND p.qtdEstoque >= c.nivelMedio THEN 1 ELSE 0 END), 0L) AS medio,
            COALESCE(SUM(CASE WHEN p.qtdEstoque <  c.nivelMedio
                               AND p.qtdEstoque >= c.nivelRuim THEN 1 ELSE 0 END), 0L) AS ruim,
            COALESCE(SUM(CASE WHEN p.qtdEstoque <  c.nivelRuim THEN 1 ELSE 0 END), 0L) AS critico
          FROM Produto p JOIN p.categoria c
          WHERE p.ativo = true
          
""")
    EstoqueResumoProjection estoqueResumo();

    boolean existsByCategoriaId(Integer categoriaId);

    @Query("""
            SELECT p FROM Produto p JOIN FETCH p.categoria
            WHERE p.ativo = true ORDER BY p.descricao
            """)
    List<Produto> listarAtivos();
}
