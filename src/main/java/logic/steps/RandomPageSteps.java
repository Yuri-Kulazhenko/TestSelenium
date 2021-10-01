package logic.steps;

import logic.annotations.Step;
import logic.pages.RandomPage;
import logic.setup.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RandomPageSteps extends BasePage {

    private final RandomPage randomPage;

    public RandomPageSteps() {
        driver.manage().window().maximize();
        this.randomPage = new RandomPage();
        }

    private WebElement getRandomPage(String section){

        return   waitElements(randomPage.link_random_page)
                .stream()
                .findAny()
                .get();
    }

    private WebElement getMinItem(List<WebElement> list) throws NumberFormatException {
        WebElement minPrice = null;
        String suffix = "//ancestor::div/a/span";
        int min = Integer.MAX_VALUE;
        for (WebElement element : list) {
            if (Integer.parseInt(element.getText().replaceAll("[\\D]", "")) < min) {
                min = Integer.parseInt(element.getText().replaceAll("[\\D]", ""));
                minPrice = element;
            }
        }

        assert minPrice != null;
        return minPrice.findElement(By.xpath(getXpath(minPrice).concat(suffix)));
    }

    private WebElement getMaxItem(List<WebElement> list){
        WebElement maxPrice = null;
        String suffix = "//ancestor::div/a";
        int max = 0;
        for (WebElement element : list) {

            if (Integer.parseInt(element.getText().replaceAll("[\\D]", "")) > max) {
                max = Integer.parseInt(element.getText().replaceAll("[\\D]", ""));
                maxPrice = element;
            }
        }
        assert maxPrice != null;
        return maxPrice.findElement(By.xpath(getXpath(maxPrice).concat(suffix)));
    }


   @Step
    public MinItemPageSteps minPriceItem(){

        getMinItem(waitElements(randomPage.price_item))
        .click();
        return new MinItemPageSteps();
    }

    @Step
    public MinItemPageSteps maxPriceItem(){

        getMaxItem(waitElements(randomPage.price_item))
                .click();
        return new MinItemPageSteps();
    }

    @Step
    public RandomPageSteps openRandomPage() {
        String section = null;
        getRandomPage(section)
                .click();
        return new RandomPageSteps();
    }
}
