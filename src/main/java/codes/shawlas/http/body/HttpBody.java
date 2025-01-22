package codes.shawlas.http.body;

import org.jetbrains.annotations.Blocking;
import org.jetbrains.annotations.NotNull;

import java.io.*;

public interface HttpBody extends Closeable {

    @Blocking
    static @NotNull HttpBody create(@NotNull InputStream inputStream) throws IOException {
        if (inputStream.available() > 8192) {
            return new CacheBody(inputStream);
        } else {
            return new BufferedBody(inputStream);
        }
    }

    @Blocking
    static @NotNull HttpBody create(byte @NotNull [] bytes) throws IOException {
        if (bytes.length > 8192) {
            return new CacheBody(new ByteArrayInputStream(bytes));
        } else {
            return new BufferedBody(new ByteArrayInputStream(bytes));
        }
    }

    // Objects

    @NotNull InputStream getInputStream() throws IOException;

    int size();

    @Override
    void close() throws IOException;

    boolean isClosed();

}
