package codes.shawlas.http.header;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public interface HttpHeaders extends Collection<@NotNull HttpHeader<?>> {

    @Override
    default boolean remove(@NotNull Object o) {
        if (!(o instanceof HttpHeader)) return false;
        else return remove((HttpHeader<?>) o);
    }

    @Override
    default boolean contains(@NotNull Object o) {
        if (!(o instanceof HttpHeader)) return false;
        return contains((HttpHeader<?>) o);
    }

    boolean contains(@NotNull HttpHeader<?> header);

    boolean remove(@NotNull HttpHeader<?> header);

    @Override
    @NotNull HttpHeader<?> @NotNull [] toArray();

    @Override
    int size();

    @Override
    default boolean isEmpty() {
        return size() == 0;
    }

}
