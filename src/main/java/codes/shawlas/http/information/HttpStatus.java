package codes.shawlas.http.information;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

public interface HttpStatus {

    // Static providers

    @NotNull HttpStatus CONTINUE = new HttpStatus() {
        @Override
        public @NotNull String getMessage() {
            return "Continue";
        }

        @Override
        public @Range(from = 100, to = 511) int getCode() {
            return 100;
        }

        @Override
        public @NotNull Type getType() {
            return Type.INFORMATION;
        }
    };
    @NotNull HttpStatus SWITCHING_PROTOCOLS = new HttpStatus() {
        @Override
        public @NotNull String getMessage() {
            return "Switching Protocols";
        }

        @Override
        public @Range(from = 100, to = 511) int getCode() {
            return 101;
        }

        @Override
        public @NotNull Type getType() {
            return Type.INFORMATION;
        }
    };
    @NotNull HttpStatus PROCESSING = new HttpStatus() {
        @Override
        public @NotNull String getMessage() {
            return "Processing";
        }

        @Override
        public @Range(from = 100, to = 511) int getCode() {
            return 102;
        }

        @Override
        public @NotNull Type getType() {
            return Type.INFORMATION;
        }
    };
    @NotNull HttpStatus EARLY_HINTS = new HttpStatus() {
        @Override
        public @NotNull String getMessage() {
            return "Early Hints";
        }

        @Override
        public @Range(from = 100, to = 511) int getCode() {
            return 103;
        }

        @Override
        public @NotNull Type getType() {
            return Type.INFORMATION;
        }
    };
    @NotNull HttpStatus OK = new HttpStatus() {
        @Override
        public @NotNull String getMessage() {
            return "OK";
        }

        @Override
        public @Range(from = 100, to = 511) int getCode() {
            return 200;
        }

        @Override
        public @NotNull Type getType() {
            return Type.SUCCESSFUL;
        }
    };
    @NotNull HttpStatus CREATED = new HttpStatus() {
        @Override
        public @NotNull String getMessage() {
            return "Created";
        }

        @Override
        public @Range(from = 100, to = 511) int getCode() {
            return 201;
        }

        @Override
        public @NotNull Type getType() {
            return Type.SUCCESSFUL;
        }
    };
    @NotNull HttpStatus ACCEPTED = new HttpStatus() {
        @Override
        public @NotNull String getMessage() {
            return "Accepted";
        }

        @Override
        public @Range(from = 100, to = 511) int getCode() {
            return 202;
        }

        @Override
        public @NotNull Type getType() {
            return Type.SUCCESSFUL;
        }
    };
    @NotNull HttpStatus NON_AUTHORITATIVE_INFORMATION = new HttpStatus() {
        @Override
        public @NotNull String getMessage() {
            return "Non-Authoritative Information";
        }

        @Override
        public @Range(from = 100, to = 511) int getCode() {
            return 203;
        }

        @Override
        public @NotNull Type getType() {
            return Type.SUCCESSFUL;
        }
    };
    @NotNull HttpStatus NO_CONTENT = new HttpStatus() {
        @Override
        public @NotNull String getMessage() {
            return "No Content";
        }

        @Override
        public @Range(from = 100, to = 511) int getCode() {
            return 204;
        }

        @Override
        public @NotNull Type getType() {
            return Type.SUCCESSFUL;
        }
    };
    @NotNull HttpStatus RESET_CONTENT = new HttpStatus() {
        @Override
        public @NotNull String getMessage() {
            return "Reset Content";
        }

        @Override
        public @Range(from = 100, to = 511) int getCode() {
            return 205;
        }

        @Override
        public @NotNull Type getType() {
            return Type.SUCCESSFUL;
        }
    };
    @NotNull HttpStatus PARTIAL_CONTENT = new HttpStatus() {
        @Override
        public @NotNull String getMessage() {
            return "Partial Content";
        }

        @Override
        public @Range(from = 100, to = 511) int getCode() {
            return 206;
        }

        @Override
        public @NotNull Type getType() {
            return Type.SUCCESSFUL;
        }
    };
    @NotNull HttpStatus MULTI_HTTP_STATUS = new HttpStatus() {
        @Override
        public @NotNull String getMessage() {
            return "Multi-Status";
        }

        @Override
        public @Range(from = 100, to = 511) int getCode() {
            return 207;
        }

        @Override
        public @NotNull Type getType() {
            return Type.SUCCESSFUL;
        }
    };
    @NotNull HttpStatus ALREADY_REPORTED = new HttpStatus() {
        @Override
        public @NotNull String getMessage() {
            return "Already Reported";
        }

        @Override
        public @Range(from = 100, to = 511) int getCode() {
            return 208;
        }

        @Override
        public @NotNull Type getType() {
            return Type.SUCCESSFUL;
        }
    };
    @NotNull HttpStatus IM_USED = new HttpStatus() {
        @Override
        public @NotNull String getMessage() {
            return "IM Used";
        }

        @Override
        public @Range(from = 100, to = 511) int getCode() {
            return 226;
        }

        @Override
        public @NotNull Type getType() {
            return Type.SUCCESSFUL;
        }
    };
    @NotNull HttpStatus MULTIPLE_CHOICES = new HttpStatus() {
        @Override
        public @NotNull String getMessage() {
            return "Multiple Choices";
        }

        @Override
        public @Range(from = 100, to = 511) int getCode() {
            return 300;
        }

        @Override
        public @NotNull Type getType() {
            return Type.REDIRECTION;
        }
    };
    @NotNull HttpStatus MOVED_PERMANENTLY = new HttpStatus() {
        @Override
        public @NotNull String getMessage() {
            return "Moved Permanently";
        }

        @Override
        public @Range(from = 100, to = 511) int getCode() {
            return 301;
        }

        @Override
        public @NotNull Type getType() {
            return Type.REDIRECTION;
        }
    };
    @NotNull HttpStatus FOUND = new HttpStatus() {
        @Override
        public @NotNull String getMessage() {
            return "Found";
        }

        @Override
        public @Range(from = 100, to = 511) int getCode() {
            return 302;
        }

        @Override
        public @NotNull Type getType() {
            return Type.REDIRECTION;
        }
    };
    @NotNull HttpStatus SEE_OTHER = new HttpStatus() {
        @Override
        public @NotNull String getMessage() {
            return "See Other";
        }

        @Override
        public @Range(from = 100, to = 511) int getCode() {
            return 303;
        }

        @Override
        public @NotNull Type getType() {
            return Type.REDIRECTION;
        }
    };
    @NotNull HttpStatus NOT_MODIFIED = new HttpStatus() {
        @Override
        public @NotNull String getMessage() {
            return "Not Modified";
        }

        @Override
        public @Range(from = 100, to = 511) int getCode() {
            return 304;
        }

        @Override
        public @NotNull Type getType() {
            return Type.REDIRECTION;
        }
    };
    @NotNull HttpStatus TEMPORARY_REDIRECT = new HttpStatus() {
        @Override
        public @NotNull String getMessage() {
            return "Temporary Redirect";
        }

        @Override
        public @Range(from = 100, to = 511) int getCode() {
            return 307;
        }

        @Override
        public @NotNull Type getType() {
            return Type.REDIRECTION;
        }
    };
    @NotNull HttpStatus PERMANENT_REDIRECT = new HttpStatus() {
        @Override
        public @NotNull String getMessage() {
            return "Permanent Redirect";
        }

        @Override
        public @Range(from = 100, to = 511) int getCode() {
            return 308;
        }

        @Override
        public @NotNull Type getType() {
            return Type.REDIRECTION;
        }
    };
    @NotNull HttpStatus BAD_REQUEST = new HttpStatus() {
        @Override
        public @NotNull String getMessage() {
            return "Bad Request";
        }

        @Override
        public @Range(from = 100, to = 511) int getCode() {
            return 400;
        }

        @Override
        public @NotNull Type getType() {
            return Type.CLIENT_ERROR;
        }
    };
    @NotNull HttpStatus UNAUTHORIZED = new HttpStatus() {
        @Override
        public @NotNull String getMessage() {
            return "Unauthorized";
        }

        @Override
        public @Range(from = 100, to = 511) int getCode() {
            return 401;
        }

        @Override
        public @NotNull Type getType() {
            return Type.CLIENT_ERROR;
        }
    };
    @NotNull HttpStatus PAYMENT_REQUIRED = new HttpStatus() {
        @Override
        public @NotNull String getMessage() {
            return "Payment Required";
        }

        @Override
        public @Range(from = 100, to = 511) int getCode() {
            return 402;
        }

        @Override
        public @NotNull Type getType() {
            return Type.CLIENT_ERROR;
        }
    };
    @NotNull HttpStatus FORBIDDEN = new HttpStatus() {
        @Override
        public @NotNull String getMessage() {
            return "Forbidden";
        }

        @Override
        public @Range(from = 100, to = 511) int getCode() {
            return 403;
        }

        @Override
        public @NotNull Type getType() {
            return Type.CLIENT_ERROR;
        }
    };
    @NotNull HttpStatus NOT_FOUND = new HttpStatus() {
        @Override
        public @NotNull String getMessage() {
            return "Not Found";
        }

        @Override
        public @Range(from = 100, to = 511) int getCode() {
            return 404;
        }

        @Override
        public @NotNull Type getType() {
            return Type.CLIENT_ERROR;
        }
    };
    @NotNull HttpStatus METHOD_NOT_ALLOWED = new HttpStatus() {
        @Override
        public @NotNull String getMessage() {
            return "Method Not Allowed";
        }

        @Override
        public @Range(from = 100, to = 511) int getCode() {
            return 405;
        }

        @Override
        public @NotNull Type getType() {
            return Type.CLIENT_ERROR;
        }
    };
    @NotNull HttpStatus NOT_ACCEPTABLE = new HttpStatus() {
        @Override
        public @NotNull String getMessage() {
            return "Not Acceptable";
        }

        @Override
        public @Range(from = 100, to = 511) int getCode() {
            return 406;
        }

        @Override
        public @NotNull Type getType() {
            return Type.CLIENT_ERROR;
        }
    };
    @NotNull HttpStatus PROXY_AUTHENTICATION_REQUIRED = new HttpStatus() {
        @Override
        public @NotNull String getMessage() {
            return "Proxy Authentication Required";
        }

        @Override
        public @Range(from = 100, to = 511) int getCode() {
            return 407;
        }

        @Override
        public @NotNull Type getType() {
            return Type.CLIENT_ERROR;
        }
    };
    @NotNull HttpStatus REQUEST_TIMEOUT = new HttpStatus() {
        @Override
        public @NotNull String getMessage() {
            return "Request Timeout";
        }

        @Override
        public @Range(from = 100, to = 511) int getCode() {
            return 408;
        }

        @Override
        public @NotNull Type getType() {
            return Type.CLIENT_ERROR;
        }
    };
    @NotNull HttpStatus CONFLICT = new HttpStatus() {
        @Override
        public @NotNull String getMessage() {
            return "Conflict";
        }

        @Override
        public @Range(from = 100, to = 511) int getCode() {
            return 409;
        }

        @Override
        public @NotNull Type getType() {
            return Type.CLIENT_ERROR;
        }
    };
    @NotNull HttpStatus GONE = new HttpStatus() {
        @Override
        public @NotNull String getMessage() {
            return "Gone";
        }

        @Override
        public @Range(from = 100, to = 511) int getCode() {
            return 410;
        }

        @Override
        public @NotNull Type getType() {
            return Type.CLIENT_ERROR;
        }
    };
    @NotNull HttpStatus LENGTH_REQUIRED = new HttpStatus() {
        @Override
        public @NotNull String getMessage() {
            return "Length Required";
        }

        @Override
        public @Range(from = 100, to = 511) int getCode() {
            return 411;
        }

        @Override
        public @NotNull Type getType() {
            return Type.CLIENT_ERROR;
        }
    };
    @NotNull HttpStatus PRECONDITION_FAILED = new HttpStatus() {
        @Override
        public @NotNull String getMessage() {
            return "Precondition Failed";
        }

        @Override
        public @Range(from = 100, to = 511) int getCode() {
            return 412;
        }

        @Override
        public @NotNull Type getType() {
            return Type.CLIENT_ERROR;
        }
    };
    @NotNull HttpStatus CONTENT_TOO_LARGE = new HttpStatus() {
        @Override
        public @NotNull String getMessage() {
            return "Content Too Large";
        }

        @Override
        public @Range(from = 100, to = 511) int getCode() {
            return 413;
        }

        @Override
        public @NotNull Type getType() {
            return Type.CLIENT_ERROR;
        }
    };
    @NotNull HttpStatus URI_TOO_LONG = new HttpStatus() {
        @Override
        public @NotNull String getMessage() {
            return "URI Too Long";
        }

        @Override
        public @Range(from = 100, to = 511) int getCode() {
            return 414;
        }

        @Override
        public @NotNull Type getType() {
            return Type.CLIENT_ERROR;
        }
    };
    @NotNull HttpStatus UNSUPPORTED_MEDIA_TYPE = new HttpStatus() {
        @Override
        public @NotNull String getMessage() {
            return "Unsupported Media Type";
        }

        @Override
        public @Range(from = 100, to = 511) int getCode() {
            return 415;
        }

        @Override
        public @NotNull Type getType() {
            return Type.CLIENT_ERROR;
        }
    };
    @NotNull HttpStatus RANGE_NOT_SATISFIABLE = new HttpStatus() {
        @Override
        public @NotNull String getMessage() {
            return "Range Not Satisfiable";
        }

        @Override
        public @Range(from = 100, to = 511) int getCode() {
            return 416;
        }

        @Override
        public @NotNull Type getType() {
            return Type.CLIENT_ERROR;
        }
    };
    @NotNull HttpStatus EXPECTATION_FAILED = new HttpStatus() {
        @Override
        public @NotNull String getMessage() {
            return "Expectation Failed";
        }

        @Override
        public @Range(from = 100, to = 511) int getCode() {
            return 417;
        }

        @Override
        public @NotNull Type getType() {
            return Type.CLIENT_ERROR;
        }
    };
    @NotNull HttpStatus IM_A_TEAPOT = new HttpStatus() {
        @Override
        public @NotNull String getMessage() {
            return "I'm a teapot";
        }

        @Override
        public @Range(from = 100, to = 511) int getCode() {
            return 418;
        }

        @Override
        public @NotNull Type getType() {
            return Type.CLIENT_ERROR;
        }
    };
    @NotNull HttpStatus MISDIRECTED_REQUEST = new HttpStatus() {
        @Override
        public @NotNull String getMessage() {
            return "Misdirected Request";
        }

        @Override
        public @Range(from = 100, to = 511) int getCode() {
            return 421;
        }

        @Override
        public @NotNull Type getType() {
            return Type.CLIENT_ERROR;
        }
    };
    @NotNull HttpStatus UNPROCESSABLE_CONTENT = new HttpStatus() {
        @Override
        public @NotNull String getMessage() {
            return "Unprocessable Content";
        }

        @Override
        public @Range(from = 100, to = 511) int getCode() {
            return 422;
        }

        @Override
        public @NotNull Type getType() {
            return Type.CLIENT_ERROR;
        }
    };
    @NotNull HttpStatus LOCKED = new HttpStatus() {
        @Override
        public @NotNull String getMessage() {
            return "Locked";
        }

        @Override
        public @Range(from = 100, to = 511) int getCode() {
            return 423;
        }

        @Override
        public @NotNull Type getType() {
            return Type.CLIENT_ERROR;
        }
    };
    @NotNull HttpStatus FAILED_DEPENDENCY = new HttpStatus() {
        @Override
        public @NotNull String getMessage() {
            return "Failed Dependency";
        }

        @Override
        public @Range(from = 100, to = 511) int getCode() {
            return 424;
        }

        @Override
        public @NotNull Type getType() {
            return Type.CLIENT_ERROR;
        }
    };
    @NotNull HttpStatus TOO_EARLY = new HttpStatus() {
        @Override
        public @NotNull String getMessage() {
            return "Too Early";
        }

        @Override
        public @Range(from = 100, to = 511) int getCode() {
            return 425;
        }

        @Override
        public @NotNull Type getType() {
            return Type.CLIENT_ERROR;
        }
    };
    @NotNull HttpStatus UPGRADE_REQUIRED = new HttpStatus() {
        @Override
        public @NotNull String getMessage() {
            return "Upgrade Required";
        }

        @Override
        public @Range(from = 100, to = 511) int getCode() {
            return 426;
        }

        @Override
        public @NotNull Type getType() {
            return Type.CLIENT_ERROR;
        }
    };
    @NotNull HttpStatus PRECONDITION_REQUIRED = new HttpStatus() {
        @Override
        public @NotNull String getMessage() {
            return "Precondition Required";
        }

        @Override
        public @Range(from = 100, to = 511) int getCode() {
            return 428;
        }

        @Override
        public @NotNull Type getType() {
            return Type.CLIENT_ERROR;
        }
    };
    @NotNull HttpStatus TOO_MANY_REQUESTS = new HttpStatus() {
        @Override
        public @NotNull String getMessage() {
            return "Too Many Requests";
        }

        @Override
        public @Range(from = 100, to = 511) int getCode() {
            return 429;
        }

        @Override
        public @NotNull Type getType() {
            return Type.CLIENT_ERROR;
        }
    };
    @NotNull HttpStatus REQUEST_HEADER_FIELDS_TOO_LARGE = new HttpStatus() {
        @Override
        public @NotNull String getMessage() {
            return "Request Header Fields Too Large";
        }

        @Override
        public @Range(from = 100, to = 511) int getCode() {
            return 431;
        }

        @Override
        public @NotNull Type getType() {
            return Type.CLIENT_ERROR;
        }
    };
    @NotNull HttpStatus UNAVAILABLE_FOR_LEGAL_REASONS = new HttpStatus() {
        @Override
        public @NotNull String getMessage() {
            return "Unavailable For Legal Reasons";
        }

        @Override
        public @Range(from = 100, to = 511) int getCode() {
            return 451;
        }

        @Override
        public @NotNull Type getType() {
            return Type.CLIENT_ERROR;
        }
    };
    @NotNull HttpStatus INTERNAL_SERVER_ERROR = new HttpStatus() {
        @Override
        public @NotNull String getMessage() {
            return "Internal Server Error";
        }

        @Override
        public @Range(from = 100, to = 511) int getCode() {
            return 500;
        }

        @Override
        public @NotNull Type getType() {
            return Type.SERVER_ERROR;
        }
    };
    @NotNull HttpStatus NOT_IMPLEMENTED = new HttpStatus() {
        @Override
        public @NotNull String getMessage() {
            return "Not Implemented";
        }

        @Override
        public @Range(from = 100, to = 511) int getCode() {
            return 501;
        }

        @Override
        public @NotNull Type getType() {
            return Type.SERVER_ERROR;
        }
    };
    @NotNull HttpStatus BAD_GATEWAY = new HttpStatus() {
        @Override
        public @NotNull String getMessage() {
            return "Bad Gateway";
        }

        @Override
        public @Range(from = 100, to = 511) int getCode() {
            return 502;
        }

        @Override
        public @NotNull Type getType() {
            return Type.SERVER_ERROR;
        }
    };
    @NotNull HttpStatus SERVICE_UNAVAILABLE = new HttpStatus() {
        @Override
        public @NotNull String getMessage() {
            return "Service Unavailable";
        }

        @Override
        public @Range(from = 100, to = 511) int getCode() {
            return 503;
        }

        @Override
        public @NotNull Type getType() {
            return Type.SERVER_ERROR;
        }
    };
    @NotNull HttpStatus GATEWAY_TIMEOUT = new HttpStatus() {
        @Override
        public @NotNull String getMessage() {
            return "Gateway Timeout";
        }

        @Override
        public @Range(from = 100, to = 511) int getCode() {
            return 504;
        }

        @Override
        public @NotNull Type getType() {
            return Type.SERVER_ERROR;
        }
    };
    @NotNull HttpStatus HTTP_VERSION_NOT_SUPPORTED = new HttpStatus() {
        @Override
        public @NotNull String getMessage() {
            return "HTTP Version Not Supported";
        }

        @Override
        public @Range(from = 100, to = 511) int getCode() {
            return 505;
        }

        @Override
        public @NotNull Type getType() {
            return Type.SERVER_ERROR;
        }
    };
    @NotNull HttpStatus VARIANT_ALSO_NEGOTIATES = new HttpStatus() {
        @Override
        public @NotNull String getMessage() {
            return "Variant Also Negotiates";
        }

        @Override
        public @Range(from = 100, to = 511) int getCode() {
            return 506;
        }

        @Override
        public @NotNull Type getType() {
            return Type.SERVER_ERROR;
        }
    };
    @NotNull HttpStatus INSUFFICIENT_STORAGE = new HttpStatus() {
        @Override
        public @NotNull String getMessage() {
            return "Insufficient Storage";
        }

        @Override
        public @Range(from = 100, to = 511) int getCode() {
            return 507;
        }

        @Override
        public @NotNull Type getType() {
            return Type.SERVER_ERROR;
        }
    };
    @NotNull HttpStatus LOOP_DETECTED = new HttpStatus() {
        @Override
        public @NotNull String getMessage() {
            return "Loop Detected";
        }

        @Override
        public @Range(from = 100, to = 511) int getCode() {
            return 508;
        }

        @Override
        public @NotNull Type getType() {
            return Type.SERVER_ERROR;
        }
    };
    @NotNull HttpStatus NOT_EXTENDED = new HttpStatus() {
        @Override
        public @NotNull String getMessage() {
            return "Not Extended";
        }

        @Override
        public @Range(from = 100, to = 511) int getCode() {
            return 510;
        }

        @Override
        public @NotNull Type getType() {
            return Type.SERVER_ERROR;
        }
    };
    @NotNull HttpStatus NETWORK_AUTHENTICATION_REQUIRED = new HttpStatus() {
        @Override
        public @NotNull String getMessage() {
            return "Network Authentication Required";
        }

        @Override
        public @Range(from = 100, to = 511) int getCode() {
            return 511;
        }

        @Override
        public @NotNull Type getType() {
            return Type.SERVER_ERROR;
        }
    };


    // Objects

    @NotNull String getMessage();

    @Range(from = 100, to = 511) int getCode();

    @NotNull Type getType();

    // Enum

    enum Type {
        INFORMATION,
        SUCCESSFUL,
        REDIRECTION,
        CLIENT_ERROR,
        SERVER_ERROR,
    }
}
