package codes.shawlas.http.information;

public enum HttpTarget {
    RESPONSE(false, true),
    REQUEST(true, false),
    BOTH(true, true);

    // Objects

    private final boolean request;
    private final boolean response;

    HttpTarget(boolean request, boolean response) {
        this.request = request;
        this.response = response;
    }

    public boolean isRequest() {
        return request;
    }

    public boolean isResponse() {
        return response;
    }

    public boolean isBoth() {
        return isRequest() && isResponse();
    }
}
