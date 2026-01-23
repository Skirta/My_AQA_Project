package com.automationexercise.helpers;

import io.github.cdimascio.dotenv.Dotenv;

public class SecretManager {
    private static final Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();

    public static String get(String key) {
        // CICD
        String env = System.getenv(key);
        if (env != null && !env.isBlank()) {
            return env;
        }
        //local
        String localEnv = dotenv.get(key);
        if (localEnv != null && !localEnv.isBlank()) {
            return localEnv;
        }
        throw new RuntimeException("Secret not found: " + key);
    }
}
