package codes.shawlas.http.information;

import codes.shawlas.http.exception.InvalidHttpVersionException;
import org.jetbrains.annotations.NotNull;

public enum HttpMethod {
    DELETE,
    GET,
    HEAD,
    OPTIONS,
    PATCH,
    POST,
    PUT,
    TRACE;

    HttpMethod() {
    }

    public @NotNull HttpMethod get(@NotNull String http) throws InvalidHttpVersionException {
        if (http.isEmpty() || http.trim().isEmpty()) {
            throw new InvalidHttpVersionException("Cannot find the method cause the string is null");
        }

        final @NotNull String @NotNull [] parts = http.split("\\s");
        if (parts.length != 3) throw new InvalidHttpVersionException("The first line string has illegal http format");

        try {
            return HttpMethod.valueOf(parts[0].toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new InvalidHttpVersionException("Cannot parse the http method", e);
        }
    }
}
