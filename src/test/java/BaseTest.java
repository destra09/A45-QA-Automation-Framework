import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.UUID;

public class BaseTest {

    public static WebDriver driver = null;

    public static WebDriverWait wait = null;

    public static String url = null;

    public static Actions actions = null;

    public ThreadLocal<WebDriver> threadDriver = null;


    public static WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.55.101:4444";
        switch (browser){
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case "MicrosoftEdge":
                WebDriverManager.edgedriver().setup();
                return driver = new EdgeDriver();
            case "grid-edge":
                caps.setCapability("browserName", "MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            case "grid-firefox":
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            case "cloud":
                return lambdaTest();
            default:
                WebDriverManager.chromedriver().setup();
                //      Added ChromeOptions argument below to fix websocket error
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(options);
        }
    }

    // LambdaTest trial expired
    public static WebDriver lambdaTest() throws MalformedURLException {
        String username = "denise.estrada";
        String accessKey = "xMOUltrDVzj2Oli5eqinDHrHkwd9XXxwn1CRq40BsFJHt5fmDv";
        String hubURL = "https://hub.lambdatest.com/wd/hub";

        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("114.0");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", username);
        ltOptions.put("accessKey", accessKey);
        ltOptions.put("project", "Untitled");
        ltOptions.put("w3c", true);
        ltOptions.put("plugin", "java-testNG");
        browserOptions.setCapability("LT:Options", ltOptions);

        return new RemoteWebDriver(new URL(hubURL), browserOptions);
    }

    @BeforeMethod
    @Parameters ({"baseURL"})
    public void launchBrowser(String baseURL) throws MalformedURLException {
        threadDriver = new ThreadLocal<>();
        driver = pickBrowser(System.getProperty("browser"));
        threadDriver.set(driver);

        url = baseURL;
        getDriver().get(url);

        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        actions = new Actions(getDriver());
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void closeBrowser() {
        getDriver().quit();
        threadDriver.remove();
    }

    public WebDriver getDriver(){
        return threadDriver.get();
    }
}