package ghostface.dev;

import ghostface.dev.message.HttpName;

import java.io.IOException;

public final class Main {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        // Load Providers
        Class.forName(HttpName.class.getName());

    }
}
