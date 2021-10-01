package logic.pages;

import org.openqa.selenium.By;

public class RandomPage {

    public By link_random_page = By.xpath("//ul[@class='pagination__list']//a");
    public By price_item = By.xpath("//span[contains(@class, 'price-value')]");
    public By link_item = By.xpath("//span[contains(@class, 'price-value')]//ancestor::div/a/span");

}
