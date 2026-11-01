package school.sptech.vastiny_projeto.Service;

import org.springframework.stereotype.Service;
import school.sptech.vastiny_projeto.Exception.NaoEncontradoException;
import school.sptech.vastiny_projeto.Repository.ProdutoRepository;
import school.sptech.vastiny_projeto.entity.Produto;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> getAll() {
        return this.produtoRepository.listarAtivos();
    }

    public Produto getById(Integer id) {
        Optional<Produto> produtoOptional = this.produtoRepository.findById(id);

        if (produtoOptional.isEmpty()) {
            throw new NaoEncontradoException("Produto não encontrado");
        }

        return produtoOptional.get();
    }
}
