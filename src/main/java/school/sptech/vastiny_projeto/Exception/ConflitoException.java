package school.sptech.vastiny_projeto.Exception;

public class ConflitoException extends RuntimeException {

  private final String campo;

  public ConflitoException(String campo, String message) {
    super(message);
    this.campo = campo;
  }

  public String getCampo() {
    return campo;
  }
}
