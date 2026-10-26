package school.sptech.vastiny_projeto.DTO.Usuario;

public class UsuarioResponseDto {

    private Integer id;

    private String nome;

    private String email;

    public UsuarioResponseDto() {
    }

    public UsuarioResponseDto(Integer id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
