package org.uva.sea.ql;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class QLPropertiesUtil {

    private static final String PROPERTY_FILE_NAME = "qlang.properties";

    public static String getProperty(String name) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(PROPERTY_FILE_NAME));
        return properties.getProperty(name);
    }

    /**
     * Utility class, do not instantiate.
     */
    private QLPropertiesUtil() {
    }
}
