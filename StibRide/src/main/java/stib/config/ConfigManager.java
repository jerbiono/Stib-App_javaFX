
package stib.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * Represents a Singleton which allows to get a uniq access to the file which
 * contain all properties.
 *
 * @author nadou
 */
public class ConfigManager {

    private static final String FILE = "./config/config.properties";
    private final Properties prop;
    private final String url;

    private ConfigManager() {
        prop = new Properties();
        URL urlToUpdate = getClass().getClassLoader()
                .getResource(FILE);

        Path dest = null;
        try {
            dest = Paths.get(urlToUpdate.toURI());
        } catch (URISyntaxException e) {
            System.out.println("problem when updating url");
        }
        url = dest.toAbsolutePath().toString();
    }

    /**
     * Allows to load properties.
     *
     * @throws IOException if file doesn't exist.
     */
    public void load() throws IOException {
        try (InputStream input = new FileInputStream(url)) {
//            System.out.println(input);
            prop.load(input);
        } catch (IOException ex) {
            throw new IOException("Chargement configuration impossible ", ex);
        }
    }

    /**
     * Simple getter of the value according to the given key.
     *
     * @param name the given key name.
     * @return the value according to the given key name.
     */
    public String getProperties(String name) {
        return prop.getProperty(name);
    }

    /**
     * Simple getter the uniq instance of the file which contain the config
     * properties.
     *
     * @return the instance of the file which contain the config properties.
     */
    public static ConfigManager getInstance() {
        return ConfigManagerHolder.INSTANCE;
    }

    private static class ConfigManagerHolder {
        
        private static final ConfigManager INSTANCE = new ConfigManager();
    }
}

