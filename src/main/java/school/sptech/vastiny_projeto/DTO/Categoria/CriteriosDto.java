package school.sptech.vastiny_projeto.DTO.Categoria;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class CriteriosDto {

    @NotNull(message = "Informe um nível bom.")
    @Min(value = 0, message = "O nível não pode ser negativo.")
    private Integer bom;

    @NotNull(message = "Informe um nível medio.")
    @Min(value = 0, message = "O nível não pode ser negativo.")
    private Integer medio;

    @NotNull(message = "Informe um nível ruim.")
    @Min(value = 0, message = "O nível não pode ser negativo.")
    private Integer ruim;

    @NotNull(message = "Informe um nível critico.")
    @Min(value = 0, message = "O nível não pode ser negativo.")
    private Integer critico;

    public CriteriosDto() {
    }

    public CriteriosDto(Integer bom, Integer medio, Integer ruim, Integer critico) {
        this.bom = bom;
        this.medio = medio;
        this.ruim = ruim;
        this.critico = critico;
    }

    public Integer getBom() {
        return bom;
    }

    public void setBom(Integer bom) {
        this.bom = bom;
    }

    public Integer getMedio() {
        return medio;
    }

    public void setMedio(Integer medio) {
        this.medio = medio;
    }

    public Integer getRuim() {
        return ruim;
    }

    public void setRuim(Integer ruim) {
        this.ruim = ruim;
    }

    public Integer getCritico() {
        return critico;
    }

    public void setCritico(Integer critico) {
        this.critico = critico;
    }
}
