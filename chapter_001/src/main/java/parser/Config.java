package parser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.InputStream;
import java.util.Properties;
public class Config {
    private static final Logger LOG = LogManager.getLogger(Config.class.getName());

    public Properties getConfig(String name) throws IllegalStateException {
        try (InputStream in = StartFind.class.getClassLoader()
                .getResourceAsStream(name)) {
            Properties config = new Properties();
            config.load(in);
            return config;
        }
        catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}

