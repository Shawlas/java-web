package codes.shawlas.http.body;

import org.jetbrains.annotations.Blocking;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

final class BufferedBody implements HttpBody {

    private byte @Nullable [] bytes;
    private final int size;
    private volatile boolean close = false;

    @Blocking
    BufferedBody(@NotNull InputStream inputStream) throws IOException {
        long time = System.currentTimeMillis();
        try (@NotNull ByteArrayOutputStream output = new ByteArrayOutputStream()) {

            int read, total = 0;
            while ((read = inputStream.read()) != -1) {
                if ((total += read) > 8192) throw new UnsupportedOperationException();
                output.write(read);
            }

            this.bytes = output.toByteArray();
            this.size = bytes.length;
        }
        System.out.println("Buffered time: " + (System.currentTimeMillis() - time));
    }

    @Override
    public @NotNull InputStream getInputStream() throws IOException {
        if (bytes == null) throw new IOException("Http body is close");
        return new ByteArrayInputStream(bytes);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void close() throws IOException {
        if (isClosed()) {
            throw new IOException("Http body already been closed");
        } else try {
            this.bytes = null;
        } finally {
            close = true;
        }
    }

    @Override
    public boolean isClosed() {
        return close;
    }
}
