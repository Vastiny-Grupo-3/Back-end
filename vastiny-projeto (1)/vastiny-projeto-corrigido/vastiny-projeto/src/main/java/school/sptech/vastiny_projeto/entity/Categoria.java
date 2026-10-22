package school.sptech.vastiny_projeto.entity;

import jakarta.persistence.*;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private Integer nivelCritico;

    private Integer nivelRuim;

    private Integer nivelMedio;

    private Integer nivelBom;

    public Categoria() {
    }

    public Categoria(Integer id, String nome, Integer nivelCritico, Integer nivelRuim, Integer nivelMedio, Integer nivelBom) {
        this.id = id;
        this.nome = nome;
        this.nivelCritico = nivelCritico;
        this.nivelRuim = nivelRuim;
        this.nivelMedio = nivelMedio;
        this.nivelBom = nivelBom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNivelCritico() {
        return nivelCritico;
    }

    public void setNivelCritico(Integer nivelCritico) {
        this.nivelCritico = nivelCritico;
    }

    public Integer getNivelRuim() {
        return nivelRuim;
    }

    public void setNivelRuim(Integer nivelRuim) {
        this.nivelRuim = nivelRuim;
    }

    public Integer getNivelMedio() {
        return nivelMedio;
    }

    public void setNivelMedio(Integer nivelMedio) {
        this.nivelMedio = nivelMedio;
    }

    public Integer getNivelBom() {
        return nivelBom;
    }

    public void setNivelBom(Integer nivelBom) {
        this.nivelBom = nivelBom;
    }
}
