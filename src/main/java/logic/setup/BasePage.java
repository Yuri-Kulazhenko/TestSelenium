package logic.setup;

import logic.DriverTypes;
import logic.drivers.DriverManager;
import logic.drivers.WebDriverBuilder;
import org.apache.commons.lang3.math.NumberUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class BasePage {
    protected static WebDriver driver;
    protected final WebDriverWait wait;
    public BasePage() {
        driver = DriverManager.getInstance(DriverTypes.EDGE.name()).getDriver();
        wait = new WebDriverWait(driver, 10, 500L);
        new WebDriverBuilder(driver)
                .setScriptTimeout(4)
                .setFullscreenView()
                .setPageLoadTimeout(6)
                .setMaximize()
                .getWebDriver();
    }

    protected WebElement getElement(By by){
        return driver.findElement(by);
    }
    protected void useScript(String script){
        JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;
        javaScriptExecutor.executeScript(script);
    }

    private void waitForJSToLoad(){
        wait.until(WebElement->((JavascriptExecutor)driver)
                .executeScript("return document.readyState")
                .equals("complete"));
    }


    protected WebElement waitForVisible(By by){
        waitForJSToLoad();
        WebElement element = driver.findElement(by);
        wait.until(ExpectedConditions.visibilityOf(element));
        waitForEnabled(element);
        highligthElement(element);
        return element;
    }

    protected List<WebElement> waitElements(By by){
        waitForJSToLoad();
        try {
        List<WebElement> list = driver.findElements(by);
        wait.until(ExpectedConditions.visibilityOfAllElements(list));
        Collections.shuffle(list);
        return list; }
                catch (StaleElementReferenceException ex){
            List<WebElement> list = driver.findElements(by);
            wait.until(ExpectedConditions.visibilityOfAllElements(list));
            Collections.shuffle(list);
            return list;
        }
    }

    public String getXpath(WebElement element){
        Matcher m = Pattern.compile("xpath: (.+?)]").matcher(element.toString());
        m.find();
        return m.group().replaceAll("xpath: ", "");

    }



    protected WebElement waitElement(By by) {
        waitForJSToLoad();
        WebElement element;
        try {
            element = driver.findElement(by);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            highligthElement(element);
        } catch (StaleElementReferenceException ex) {
            element = driver.findElement(by);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            highligthElement(element);
        }
        return element;
    }

    protected List<WebElement> waitForVisible(List<WebElement> elements){
        waitForJSToLoad();
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
        return elements;
    }

    protected WebElement waitForEnabled(WebElement element){
        waitForJSToLoad();
        wait.until(WebElement->(element.isEnabled())).equals(true);
        return element;
    }

    private void highligthElement(WebElement element){
        if(driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor) driver).executeScript("element = arguments[0];" +
                    "original_style = element.getAttribute('style');" +
                    "element.setAttribute('style', original_style + \"; " +
                    "background: yellow; border: 4px dashed blue;\");" +
                    "setTimeout(function(){ " +
                    "element.setAttribute('style', original_style);" +
                    "}, 400);", element);
        }
    }




    protected WebElement waitForElement(By by){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element =
                wait.until(ExpectedConditions.elementToBeClickable(by));
        return element;
    }


    protected List<WebElement> getElements(By by){
        return driver.findElements(by);
    }


}
