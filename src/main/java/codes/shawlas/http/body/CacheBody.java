package codes.shawlas.http.body;

import org.jetbrains.annotations.Blocking;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.nio.file.Files;

final class CacheBody implements HttpBody {

    private final @NotNull File file;
    private final int size;
    private volatile boolean close = false;

    @Blocking
    CacheBody(@NotNull InputStream inputStream) throws IOException {
        long time = System.currentTimeMillis();

        this.file = File.createTempFile("HttpBody", "-cache");
        this.file.deleteOnExit();

        try (@NotNull FileOutputStream output = new FileOutputStream(file)) {
            byte @NotNull [] bytes = new byte[8192];

            int read, total = 0;
            while ((read = inputStream.read(bytes)) != -1) {
                output.write(bytes, 0, read);
                output.flush();
                total += read;
            }

            this.size = total;
        }
        System.out.println("Cache time: " + (System.currentTimeMillis() - time));
    }

    @Override
    public @NotNull InputStream getInputStream() throws IOException {
        return Files.newInputStream(file.toPath());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void close() throws IOException {
        if (isClosed()) {
            throw new IOException("Http Body already been closed");
        } else try {
            Files.delete(file.toPath());
        } finally {
            close = true;
        }
    }

    @Override
    public boolean isClosed() {
        return close;
    }
}
