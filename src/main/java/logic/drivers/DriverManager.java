package logic.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverManager {

    private static DriverManager driverManager;
    private final WebDriver driver;

    private DriverManager(String type) {
        System.setProperty("webdriver.edge.driver","src/main/resources/drivers/chromedriver.exe");
        System.setProperty("webdriver.edge.driver","src/main/resources/drivers/msedgedriver92.exe");
        System.setProperty("webdriver.firefox.driver","src/main/resources/drivers/geckodriver.exe");

        switch (type){

            case "FF":{
                this.driver = new WebDriverBuilder(new FirefoxDriver())
                        .setScriptTimeout(4)
                        .setFullscreenView()
                        .setPageLoadTimeout(26)
                        .getWebDriver();
                break;
            }
            case "EDGE":{
                this.driver = new WebDriverBuilder(new EdgeDriver())
                        .setScriptTimeout(24)
                        .setFullscreenView()
                        .setPageLoadTimeout(26)
                        .getWebDriver();
                break;
            }

            case "CHROME":{
                this.driver = new WebDriverBuilder(new ChromeDriver())
                        .setScriptTimeout(4)
                        .setFullscreenView()
                        .setPageLoadTimeout(6)
                        .getWebDriver();
                break;
            }
            default:
                throw new IllegalArgumentException("The driver type has not been found.");
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public static DriverManager getInstance(String driverType) {
        if (driverManager == null) {
            driverManager = new DriverManager(driverType);
        }
        return driverManager;
    }
}
