package codes.shawlas.http.exception.header;

public class HttpHeaderException extends Exception {
    public HttpHeaderException(String message) {
        super(message);
    }

    public HttpHeaderException(String message, Throwable cause) {
        super(message, cause);
    }
}
