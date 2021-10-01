package logic.drivers;

import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;


public class WebDriverBuilder {
        private final WebDriver driver;

        public WebDriverBuilder(WebDriver driver) {
            this.driver = driver;
        }

        public WebDriverBuilder setFullscreenView() {
            this.driver.manage().window().fullscreen();
            return this;
        }

        public WebDriverBuilder setMaximize() {
            this.driver.manage().window().maximize();
            return this;
        }
        public WebDriverBuilder setScriptTimeout(long seconds) {
            this.driver.manage().timeouts().setScriptTimeout(seconds, TimeUnit.SECONDS);
            return this;
        }

        public WebDriverBuilder setPageLoadTimeout(long seconds) {
            this.driver.manage().timeouts().pageLoadTimeout(seconds, TimeUnit.SECONDS);
            return this;
        }

        public WebDriver getWebDriver() {
            return this.driver;
        }
    }
