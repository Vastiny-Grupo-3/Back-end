package school.sptech.vastiny_projeto.Service;

import org.springframework.stereotype.Service;
import school.sptech.vastiny_projeto.Exception.ConflitoException;
import school.sptech.vastiny_projeto.Exception.NaoEncontradoException;
import school.sptech.vastiny_projeto.Exception.ValidacaoException;
import school.sptech.vastiny_projeto.Repository.CategoriaRepository;
import school.sptech.vastiny_projeto.Repository.ProdutoRepository;
import school.sptech.vastiny_projeto.entity.Categoria;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final ProdutoRepository produtoRepository;

    public CategoriaService(CategoriaRepository categoriaRepository, ProdutoRepository produtoRepository) {
        this.categoriaRepository = categoriaRepository;
        this.produtoRepository = produtoRepository;
    }

    public List<Categoria> getAll() {
        return this.categoriaRepository.findAll();
    }

    public Categoria getById(Integer id) {
        Optional<Categoria> categoriaOptional = this.categoriaRepository.findById(id);

        if (categoriaOptional.isEmpty()) {
            throw new NaoEncontradoException("Categoria não encontrada.");
        }

        return categoriaOptional.get();
    }

    public Categoria create(Categoria categoria) {
        validarFaixas(categoria);
        if (this.categoriaRepository.existsByNomeIgnoreCase(categoria.getNome())) {
            throw new ConflitoException("nome", "Categoria com este nome já existe.");
        }

        return this.categoriaRepository.save(categoria);
    }

    public Categoria update(Integer id, Categoria categoria) {
        Categoria categoriaBanco = getById(id);
        validarFaixas(categoria);

        if (this.categoriaRepository.existsByNomeIgnoreCaseAndIdNot(categoria.getNome(), id)) {
            throw new ConflitoException("nome", "Categoria com este nome já existe.");
        }

        categoriaBanco.setNome(categoria.getNome());
        categoriaBanco.setNivelBom(categoria.getNivelBom());
        categoriaBanco.setNivelMedio(categoria.getNivelMedio());
        categoriaBanco.setNivelRuim(categoria.getNivelRuim());
        categoriaBanco.setNivelCritico(categoria.getNivelCritico());

        return this.categoriaRepository.save(categoriaBanco);
    }

    public void delete(Integer id) {
        Categoria categoria = getById(id);

        if (this.produtoRepository.existsByCategoriaId(id)) {
            throw new ConflitoException("categoria", "Esta categoria possui produtos e não pode ser excluída.");
        }

        this.categoriaRepository.delete(categoria);
    }

    public void validarFaixas (Categoria categoria) {
        if (categoria.getNivelBom() < categoria.getNivelMedio()) {
            throw new ValidacaoException("O nível Bom deve ser maior ou igual ao Médio.", "criterios.bom");
        }
        if (categoria.getNivelMedio() < categoria.getNivelRuim()) {
            throw new ValidacaoException("O nível Médio deve ser maior ou igual ao Ruim.", "criterios.medio");
        }
        if (categoria.getNivelRuim() < categoria.getNivelCritico()) {
            throw new ValidacaoException("O nível Ruim deve ser maior ou igual ao Crítico.", "criterios.ruim");
        }
    }
}
