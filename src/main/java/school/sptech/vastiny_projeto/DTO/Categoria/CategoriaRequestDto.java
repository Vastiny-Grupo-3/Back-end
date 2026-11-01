package school.sptech.vastiny_projeto.DTO.Categoria;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CategoriaRequestDto {

    @NotBlank(message = "Informe um nome da categoria.")
    private String nome;

    @NotNull(message = "Informe os critérios de estoque.")
    @Valid
    private CriteriosDto criterios;

    public CategoriaRequestDto(String nome, CriteriosDto criterios) {
        this.nome = nome;
        this.criterios = criterios;
    }

    public CategoriaRequestDto() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CriteriosDto getCriterios() {
        return criterios;
    }

    public void setCriterios(CriteriosDto criterios) {
        this.criterios = criterios;
    }
}
