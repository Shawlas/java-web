package codes.shawlas.http.exception;

public class InvalidHttpMethodException extends Exception {
    public InvalidHttpMethodException(String message) {
        super(message);
    }

    public InvalidHttpMethodException(String message, Throwable cause) {
        super(message, cause);
    }
}
