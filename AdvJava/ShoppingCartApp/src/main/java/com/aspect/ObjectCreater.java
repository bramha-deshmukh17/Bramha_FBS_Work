package com.aspect;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import java.util.Properties;

public final class ObjectCreater {
    private static final Properties props = new Properties();

    static {
        try (InputStream in = openInfoProperties()) {
            if (in == null) {
                throw new IllegalStateException(
                        "Missing resource: /info.properties (expected under project resources folder and on classpath)");
            }
            props.load(in);
        } catch (IOException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    private static InputStream openInfoProperties() {
        return ObjectCreater.class.getClassLoader().getResourceAsStream("info.properties");
    }

    public static <T> T createObject(String key, Class<T> expectedType) {
        Objects.requireNonNull(key, "key");
        Objects.requireNonNull(expectedType, "expectedType");

        String className = props.getProperty(key);
        if (className == null || className.isBlank()) {
            throw new IllegalStateException("No implementation configured for key: " + key);
        }

        try {
            Object instance = Class.forName(className.trim()).getDeclaredConstructor().newInstance();
            return expectedType.cast(instance);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException
                | InvocationTargetException e) {
            throw new IllegalStateException("Failed to create instance for key '" + key + "' -> " + className, e);
        }
    }
}
