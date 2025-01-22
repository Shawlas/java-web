package codes.shawlas.http;

import codes.shawlas.http.body.HttpBody;
import codes.shawlas.http.header.HttpHeaders;
import codes.shawlas.http.information.HttpMethod;
import codes.shawlas.http.information.HttpStatus;
import codes.shawlas.http.information.HttpVersion;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;
import java.net.URI;
import java.net.URISyntaxException;

public interface Http {

    // Static initializers

    static @NotNull URI getUri(@NotNull String http) throws URISyntaxException {
        if (http.isEmpty() || http.trim().isEmpty()) {
            throw new URISyntaxException("Cannot find the uri ", "The string is empty");
        }

        final @NotNull String @NotNull [] parts = http.split("\\s");
        if (parts.length != 3) {
            throw new URISyntaxException("Cannot find the uri ", "The first line string has illegal http format");
        }

        return URI.create(parts[1]);
    }

    // Objects

    @NotNull HttpVersion getVersion();

    @Unmodifiable @NotNull HttpHeaders getHeaders();

    @NotNull HttpBody getBody();

    // Classes

    interface Request extends Http {

        @NotNull HttpMethod getMethod();

        @NotNull URI getPath();

    }

    interface Response extends Http {

        @NotNull HttpStatus getStatus();

    }
}
