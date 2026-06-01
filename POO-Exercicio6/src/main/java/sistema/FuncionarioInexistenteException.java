package sistema;

public class FuncionarioInexistenteException extends RuntimeException {
    public FuncionarioInexistenteException(String message) {
        super(message);
    }
}
