package school.sptech.vastiny_projeto.DTO.Categoria;

public class CategoriaResponseDto {

    private Integer id;
    private String nome;
    private CriteriosDto criterios;

    public CategoriaResponseDto(Integer id, String nome, CriteriosDto criterios) {
        this.id = id;
        this.nome = nome;
        this.criterios = criterios;
    }

    public CategoriaResponseDto() {
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

    public CriteriosDto getCriterios() {
        return criterios;
    }

    public void setCriterios(CriteriosDto criterios) {
        this.criterios = criterios;
    }
}
