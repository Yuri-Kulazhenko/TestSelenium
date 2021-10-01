package logic.steps;
import logic.annotations.Step;
import logic.pages.HeaderPage;
import logic.setup.BasePage;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;



public class HeaderPageSteps extends BasePage {


    private final HeaderPage headerPage;

    public HeaderPageSteps(WebDriver driver) {
        driver.manage().window().maximize();
        headerPage = new HeaderPage();
    }

    @Step
    public HeaderPageSteps checkLogo(){
        assertThat(waitElement(headerPage.logo).isDisplayed(), is(true));
        return this;
    }

}