package school.sptech.vastiny_projeto.Repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import school.sptech.vastiny_projeto.DTO.projection.CategoriaVendidaProjection;
import school.sptech.vastiny_projeto.DTO.projection.TopProdutoProjection;
import school.sptech.vastiny_projeto.entity.ItemVenda;

import java.time.LocalDateTime;
import java.util.List;

public interface ItemVendaRepository  extends JpaRepository<ItemVenda, Integer> {
    @Query("""
SELECT c.nome AS categoria,
       SUM(i.quantidade * i.precoUnitario) AS faturado
       FROM ItemVenda i
       JOIN i.peca p
       JOIN p.categoria c 
       WHERE  i.venda.dataHora >= :inicio AND i.venda.dataHora < :fim
       GROUP BY c.nome
       ORDER BY SUM(i.quantidade * i.precoUnitario) DESC """)
    List<CategoriaVendidaProjection> categorias(@Param("inicio") LocalDateTime inicio, @Param("fim")LocalDateTime fim, Pageable pageable);

    @Query("""
        SELECT p.codigo1 AS codigo,
               p.descricao AS nome,
               c.nome AS categoria,
               SUM(i.quantidade) AS qtdVendida,
               SUM(i.quantidade * i.precoUnitario) AS faturado,
               SUM(i.quantidade * (i.precoUnitario - i.custoUnitario)) AS lucro
        FROM ItemVenda i
          JOIN i.peca p
          JOIN p.categoria c
        WHERE i.venda.dataHora >= :inicio AND i.venda.dataHora < :fim
        GROUP BY p.id, p.codigo1, p.descricao, c.nome
        ORDER BY SUM(i.quantidade) DESC
        """)
    List<TopProdutoProjection> topProdutos(@Param("inicio") LocalDateTime inicio,
                                           @Param("fim") LocalDateTime fim,
                                           Pageable pageable
                                           );

}
