package codes.shawlas.http.information;

import codes.shawlas.http.exception.InvalidHttpVersionException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public interface HttpVersion {

    // Static initializers

    static @NotNull HttpVersion getVersion(@NotNull String http) throws InvalidHttpVersionException {
        if (http.isEmpty() || http.trim().isEmpty()) {
            throw new InvalidHttpVersionException("The string cannot be null");
        }

        final @NotNull String @NotNull [] parts = http.split("\\s");
        if (parts.length != 3) {
            throw new InvalidHttpVersionException("The first line string has illegal format");
        }

        final @NotNull String v = parts[2];
        if (!v.matches("^HTTP/(0\\.9|1\\.0|1\\.1|2\\.0|3\\.0)$")) {
            throw new InvalidHttpVersionException("Cannot find the http version: " + http);
        }

        try {
            final int major = Integer.parseInt(String.valueOf(v.charAt(5)));
            final int minor = Integer.parseInt(String.valueOf(v.charAt(7)));

            return new HttpVersion() {
                @Override
                public int getMajor() {
                    return major;
                }

                @Override
                public int getMinor() {
                    return minor;
                }

                @Override
                public boolean equals(@Nullable Object obj) {
                    if (obj instanceof HttpVersion) {
                        @NotNull HttpVersion that = (HttpVersion) obj;
                        return Objects.equals(getMajor(), that.getMajor()) && Objects.equals(getMinor(), that.getMinor());
                    }
                    return false;
                }

                @Override
                public int hashCode() {
                    return Objects.hash(getMajor(), getMinor(), serialize());
                }
            };
        } catch (NumberFormatException e) {
            throw new InvalidHttpVersionException("Cannot parse the http version", e);
        }
    }

    // Fields providers

    @NotNull HttpVersion HTTP_0_9 = new HttpVersion() {
        @Override
        public int getMajor() {
            return 0;
        }

        @Override
        public int getMinor() {
            return 9;
        }

        @Override
        public int hashCode() {
            return Objects.hash(getMajor(), getMinor(), serialize());
        }

        @Override
        public boolean equals(@Nullable Object obj) {
            if (obj instanceof HttpVersion) {
                @NotNull HttpVersion that = (HttpVersion) obj;
                return Objects.equals(getMajor(), that.getMajor()) && Objects.equals(getMinor(), that.getMinor());
            }
            return false;
        }
    };
    @NotNull HttpVersion HTTP_1_0 = new HttpVersion() {
        @Override
        public int getMajor() {
            return 1;
        }

        @Override
        public int getMinor() {
            return 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(getMajor(), getMinor(), serialize());
        }

        @Override
        public boolean equals(@Nullable Object obj) {
            if (obj instanceof HttpVersion) {
                @NotNull HttpVersion that = (HttpVersion) obj;
                return Objects.equals(getMajor(), that.getMajor()) && Objects.equals(getMinor(), that.getMinor());
            }
            return false;
        }
    };
    @NotNull HttpVersion HTTP_1_1 = new HttpVersion() {
        @Override
        public int getMajor() {
            return 1;
        }

        @Override
        public int getMinor() {
            return 1;
        }

        @Override
        public int hashCode() {
            return Objects.hash(getMajor(), getMinor(), serialize());
        }

        @Override
        public boolean equals(@Nullable Object obj) {
            if (obj instanceof HttpVersion) {
                @NotNull HttpVersion that = (HttpVersion) obj;
                return Objects.equals(getMajor(), that.getMajor()) && Objects.equals(getMinor(), that.getMinor());
            }
            return false;
        }
    };
    @NotNull HttpVersion HTTP_2_0 = new HttpVersion() {
        @Override
        public int getMajor() {
            return 2;
        }

        @Override
        public int getMinor() {
            return 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(getMajor(), getMinor(), serialize());
        }

        @Override
        public boolean equals(@Nullable Object obj) {
            if (obj instanceof HttpVersion) {
                @NotNull HttpVersion that = (HttpVersion) obj;
                return Objects.equals(getMajor(), that.getMajor()) && Objects.equals(getMinor(), that.getMinor());
            }
            return false;
        }
    };
    @NotNull HttpVersion HTTP_3_0 = new HttpVersion() {
        @Override
        public int getMajor() {
            return 3;
        }

        @Override
        public int getMinor() {
            return 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(getMajor(), getMinor(), serialize());
        }

        @Override
        public boolean equals(@Nullable Object obj) {
            if (obj instanceof HttpVersion) {
                @NotNull HttpVersion that = (HttpVersion) obj;
                return Objects.equals(getMajor(), that.getMajor()) && Objects.equals(getMinor(), that.getMinor());
            }
            return false;
        }
    };

    // Objects

    int getMajor();

    int getMinor();

    default @NotNull String serialize() {
        return "HTTP/" + getMajor() + "." + getMinor();
    }

    @Override
    boolean equals(@Nullable Object e);

    int hashCode();
}
