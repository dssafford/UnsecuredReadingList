package readinglist;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by mcurx on 8/30/16.
 */
@Component
@PropertySource("classpath:config.properties")
public class ConfigurationReader {

    @Value("${app.release}")
    private String release;

    @Value("${app.environment}")
    private String environment;


    @Value("${app.doug}")
    private String doug;

    public String getDoug() { return doug;}

    public void setDoug(String doug) {this.doug=doug;}




    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    @Override
    public String toString() {
        return "release = " + release + "\nenvironment = " + environment;
    }
}
