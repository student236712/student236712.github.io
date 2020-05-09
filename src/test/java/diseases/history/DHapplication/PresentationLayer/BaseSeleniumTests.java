package diseases.history.DHapplication.PresentationLayer;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

public  class BaseSeleniumTests {

    public WebDriver driver;
    private String URL;
    public Map<String, Object> vars;
    JavascriptExecutor js;

    public void setURL(String URL) {
        this.URL = URL;
    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver1.exe");

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();

        capabilities.setCapability("tunnel", true);
        capabilities.setCapability("console", true);
        capabilities.setCapability("network", true);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("start-maximized");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-dev-shm-usage");
        options.merge(capabilities);
        this.driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        driver.get(URL);
        driver.manage().window().maximize();
    }


    @After
    public void tearDown() {
        driver.quit();
    }


}