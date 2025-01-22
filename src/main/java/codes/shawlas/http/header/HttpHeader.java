package codes.shawlas.http.header;

import codes.shawlas.http.exception.header.HttpHeaderException;
import codes.shawlas.http.exception.header.InvalidHeaderException;
import codes.shawlas.http.information.HttpTarget;
import codes.shawlas.http.main.Main;
import codes.shawlas.http.media.MediaType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public interface HttpHeader<T> {

    // todo static crate

    // Objects

    @NotNull HttpHeader.Name<T> getName();

    @Nullable T getValue();

    @NotNull String getValueAsString();

    void setValue(@Nullable T value);

    @NotNull HttpTarget getTarget();

    // Classes

    interface Name<T> extends CharSequence {

        // Objects

        @NotNull String getName();

        @NotNull String @NotNull [] getSplit();

        @NotNull HttpHeader<T> parse(@NotNull String string) throws HttpHeaderException;

        @NotNull String serialize(@NotNull HttpHeader<T> header);

        @Override
        default int length() {
            return getName().length();
        }

        @Override
        default char charAt(int i) {
            return getName().charAt(i);
        }

        @Override
        default @NotNull CharSequence subSequence(int i, int i1) {
            return getName().subSequence(i, i1);
        }
    }
}
