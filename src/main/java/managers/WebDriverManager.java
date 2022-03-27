package managers;

import enums.DriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;

import java.time.Duration;

public class WebDriverManager {
    private WebDriver driver;
    private static DriverType driverType;

    public WebDriverManager() {
        driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
    }

    public WebDriver getDriver() {
        if (driver == null) driver = createDriver();
        return driver;
    }

    private WebDriver createDriver() {
        switch (driverType) {
            case FIREFOX:
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setHeadless(true);
                firefoxOptions.addArguments("--width=1600");
                firefoxOptions.addArguments("--height=1200");
                io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case CHROME:
                ChromeOptions options = new ChromeOptions();
//                options.addArguments("--headless");
                options.addArguments("--disable-infobars");
                options.addArguments("--disable-extensions");
                options.addArguments("--ignore-certificate-errors");
                options.addArguments("--disable-notifications");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-http2");
                options.addArguments("--incognito");
                options.addArguments("--disable-gpu");
                options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
                options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
                options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, false);
                io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(options);
                break;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait()));
        return driver;
    }

    public void closeDriver() {
        driver.close();
        driver.quit();
    }

}
