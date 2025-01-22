package codes.shawlas.http.exception.header;

public class InvalidHeaderException extends HttpHeaderException {
    public InvalidHeaderException(String message) {
        super(message);
    }

    public InvalidHeaderException(String message, Throwable cause) {
        super(message, cause);
    }
}
