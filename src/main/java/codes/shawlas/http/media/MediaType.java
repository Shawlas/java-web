package codes.shawlas.http.media;

import codes.shawlas.http.body.HttpBody;
import codes.shawlas.http.exception.media.MediaParserException;
import codes.shawlas.http.header.HttpHeader;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.InputStream;
import java.util.Objects;

public interface MediaType<T> {

    @NotNull Type getTypes();

    @NotNull Parameter @NotNull [] getParameters();

    @NotNull HttpHeader<@NotNull MediaType<T>> getHeader();

    @NotNull T parse(@NotNull InputStream stream) throws MediaParserException;

    @NotNull HttpBody getBody(@NotNull T data, @NotNull Parameter @NotNull ... parameters) throws MediaParserException;

    // Classes

    interface Type {

        // Static providers

        @NotNull Type APPLICATION_JSON = new Type() {
            @Override
            public @NotNull String getType() {
                return "application";
            }

            @Override
            public @NotNull String getSubType() {
                return "json";
            }

            @Override
            public boolean equals(@Nullable Object o) {
                if (o instanceof Type) {
                    final @NotNull Type that = (Type) o;
                    return Objects.equals(getType().toLowerCase(), that.getType().toLowerCase()) &&
                           Objects.equals(getSubType().toLowerCase(), that.getSubType().toLowerCase());
                }
                return false;
            }

            @Override
            public int hashCode() {
                return Objects.hash(getType().toLowerCase(), getSubType().toLowerCase());
            }
        };
        @NotNull Type TEXT_HTML = new Type() {
            @Override
            public @NotNull String getType() {
                return "text";
            }

            @Override
            public @NotNull String getSubType() {
                return "html";
            }

            @Override
            public boolean equals(@Nullable Object o) {
                if (o instanceof Type) {
                    final @NotNull Type that = (Type) o;
                    return Objects.equals(getType().toLowerCase(), that.getType().toLowerCase()) &&
                           Objects.equals(getSubType().toLowerCase(), that.getSubType().toLowerCase());
                }
                return false;
            }

            @Override
            public int hashCode() {
                return Objects.hash(getType().toLowerCase(), getSubType().toLowerCase());
            }
        };

        // Objects

        @NotNull String getType();

        @NotNull String getSubType();

        default @NotNull String getFull() {
            return getType() + "/" + getSubType();
        }


    }

    interface Parameter {

        // Static providers

        @NotNull Parameter UTF_8 = new Parameter() {
            @Override
            public @NotNull String getKey() {
                return "charset";
            }

            @Override
            public @NotNull String getValue() {
                return "UTF-8";
            }

            @Override
            public boolean equals(@Nullable Object o) {
                if (o instanceof Parameter) {
                    final @NotNull Parameter that = (Parameter) o;
                    return  Objects.equals(getKey().toLowerCase(), that.getKey().toLowerCase()) &&
                            Objects.equals(getValue().toLowerCase(), that.getValue().toLowerCase());
                }
                return false;
            }

            @Override
            public int hashCode() {
                return Objects.hash(getKey().toLowerCase(), getValue().toLowerCase());
            }
        };
        @NotNull Parameter UTF_16 = new Parameter() {
            @Override
            public @NotNull String getKey() {
                return "charset";
            }

            @Override
            public @NotNull String getValue() {
                return "UTF-16";
            }

            @Override
            public boolean equals(@Nullable Object o) {
                if (o instanceof Parameter) {
                    final @NotNull Parameter that = (Parameter) o;
                    return  Objects.equals(getKey().toLowerCase(), that.getKey().toLowerCase()) &&
                            Objects.equals(getValue().toLowerCase(), that.getValue().toLowerCase());
                }
                return false;
            }

            @Override
            public int hashCode() {
                return Objects.hash(getKey().toLowerCase(), getValue().toLowerCase());
            }
        };
        @NotNull Parameter NULL = new Parameter() {
            @Override
            public @NotNull String getKey() {
                return "";
            }

            @Override
            public @NotNull String getValue() {
                return "";
            }

            @Override
            public boolean equals(@Nullable Object o) {
                if (o instanceof Parameter) {
                    final @NotNull Parameter that = (Parameter) o;
                    return  Objects.equals(getKey().toLowerCase(), that.getKey().toLowerCase()) &&
                            Objects.equals(getValue().toLowerCase(), that.getValue().toLowerCase());
                }
                return false;
            }

            @Override
            public int hashCode() {
                return Objects.hash(getKey().toLowerCase(), getValue().toLowerCase());
            }
        };

        // Objects

        @NotNull String getKey();

        @NotNull String getValue();

        default @NotNull String getFull() {
            return getKey() + "=" + getValue();
        }

        @Override
        boolean equals(@Nullable Object o);

        @Override
        int hashCode();
    }
}