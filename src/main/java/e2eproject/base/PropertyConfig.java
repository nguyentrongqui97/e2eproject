package e2eproject.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyConfig {

    private static Properties prop = new Properties();

    static {
        try {
            FileInputStream data = new FileInputStream("src\\main\\java\\e2eproject\\resources\\config.properties");
            prop.load(data);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public static String getProperty(String key) {
        return prop.getProperty(key);
    }
}
