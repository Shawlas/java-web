package ghostface.dev.impl;

import com.google.gson.JsonElement;
import ghostface.dev.body.HttpBody;
import ghostface.dev.headers.HttpHeader;
import ghostface.dev.headers.HttpHeaderName;
import ghostface.dev.headers.Target;
import ghostface.dev.media.MediaType;
import ghostface.dev.media.json.JsonMediaType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.UnknownNullability;

import java.util.Objects;

public class SimpleHttpHeader<T> implements HttpHeader<T> {

    public static @NotNull HttpHeader<@NotNull MediaType<@NotNull JsonElement>> JsonHeader(@NotNull JsonElement element, @NotNull HttpBody body) {
        return new Provider.JsonHeader(element, body);
    }

    private final @NotNull HttpHeaderName<T> key;
    private final @NotNull Target target;
    private @UnknownNullability T value;

    public SimpleHttpHeader(HttpHeaderName<T> key, @UnknownNullability T value, @NotNull Target target) {
        if (key.target() != target) {
            throw new IllegalArgumentException("Header and name target do not match");
        }
        this.key = key;
        this.value = value;
        this.target = target;
    }

    @Override
    public @NotNull HttpHeaderName<T> getKey() {
        return key;
    }

    @Override
    public @UnknownNullability T getValue() {
        return value;
    }

    @Override
    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public @NotNull Target getTarget() {
        return target;
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        @NotNull SimpleHttpHeader<?> that = (SimpleHttpHeader<?>) object;
        return Objects.equals(key, that.key);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(key);
    }

    private static final class Provider {

        private static final class JsonHeader extends SimpleHttpHeader<@NotNull MediaType<@NotNull JsonElement>> {
            public JsonHeader(@NotNull JsonElement json, @NotNull HttpBody body) {
                super(HttpHeaderName.JSON_CONTENT, new JsonMediaType(json, body), Target.BOTH);
            }
        }

    }
}
