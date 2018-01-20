package pos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config { 
    public String getProperties(String propertyName) throws IOException {
        Properties prop = new Properties();
        String propFileName = "config.properties";
        
 
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        prop.load(inputStream);
        if (inputStream == null) {
            throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
        }
        return "pos."+prop.getProperty(propertyName);
    }
}
