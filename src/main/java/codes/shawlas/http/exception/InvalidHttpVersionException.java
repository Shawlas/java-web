package codes.shawlas.http.exception;

public class InvalidHttpVersionException extends Exception {
    public InvalidHttpVersionException(String message) {
        super(message);
    }

    public InvalidHttpVersionException(String message, Throwable cause) {
        super(message, cause);
    }
}
