package Test;



import java.net.MalformedURLException;
import org.junit.Test;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FinalWorikingDockerSeleniumJUnit5 {

    static WebDriver driver;
    static URL url;

    @Before
    public void getFF() throws MalformedURLException {
        url = new URL("http://3.235.140.171:4444/wd/hub");
        DesiredCapabilities capFirefox = DesiredCapabilities.firefox();
        capFirefox.setBrowserName("firefox");
        capFirefox.setPlatform(Platform.LINUX);
        driver = new RemoteWebDriver(url, capFirefox);
    }

    @After
    public void closeFF() {
        driver.quit();
    }

    @Test
    public void JUnitTest() {
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com");
        driver.findElement(By.linkText("Today's Deals")).click();

    }
}