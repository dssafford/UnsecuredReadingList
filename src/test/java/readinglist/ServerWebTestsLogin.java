package readinglist;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=ReadingListApplication.class)
@WebIntegrationTest(randomPort=true)
public class ServerWebTestsLogin {

    private static FirefoxDriver browser;

    @Value("${local.server.port}")
    private int port;

    @BeforeClass
    public static void openBrowser() {
        browser = new FirefoxDriver();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void addInfoToLogin() {
        String baseUrl = "http://localhost:" + port;
        browser.get(baseUrl);

        String currentUrl = browser.getCurrentUrl();
        assertEquals(baseUrl +"/login", currentUrl);

        assertEquals("eat doodoo",
					 browser.findElementByTagName("div").getText());

			browser.findElementByName("name").sendKeys("Doug");
        browser.findElementByName("password").sendKeys("BOOK AUTHOR");
        browser.findElementByName("description").sendKeys("DESCRIPTION");
        //browser.findElementByTagName("form").submit();

        WebElement dl =
                browser.findElementByCssSelector("dt.doug");
        assertEquals("Name:\n" +
                        "Password:\n" +
                        "Description:",
                dl.getText());

		 WebElement dt =
                browser.findElementByCssSelector("dd.doug1");
        assertEquals("DESCRIPTION", dt.getText());
    }

    @AfterClass
    public static void closeBrowser() {
        browser.quit();
    }

}
