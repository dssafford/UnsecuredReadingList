package readinglist;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by Doug on 9/2/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=ReadingListApplication.class)
@TestPropertySource("classpath:test.properties")
public class SimpleConfigurationClassTests {

	@Autowired
	Environment env;

	@Autowired
	ConfigurationReader configurationReader;

	@Value("${app.doug}")
	private String doug;

	@Test
	public void loadConfigurationTestProperties() throws Exception {
		assertEquals("Go Fuck Yourself", configurationReader.getDoug());

	}


}
