package readinglist;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.ConfigFileApplicationContextInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= TestUtilitiesTest.DougConfig.class,
    initializers=ConfigFileApplicationContextInitializer.class)
public class TestUtilitiesTest {

  @Autowired
  Environment env;


	@Value("${app.doug}")
	private String doug;

  @Value("${douglas:test}")
  String dougsafford;


  @Test
  public void loadProperties() {
    
    assertEquals("bar", env.getProperty("foo"));
    assertEquals("123", env.getProperty("bar"));
    assertEquals("Safford", env.getProperty("doug"));
    assertEquals("Bode", env.getProperty("mike"));
  }



  @Configuration
  public static class DougConfig {
  }
}
