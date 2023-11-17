package pe.com.bancom.domain.exceptions;

public class UsuarioNotOwnerPost extends RuntimeException {
    public UsuarioNotOwnerPost(String message) {
        super(message);
    }
}
