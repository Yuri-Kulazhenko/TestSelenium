package logic.steps;

import logic.annotations.Step;
import logic.pages.MinItemPage;
import logic.setup.BasePage;
import org.openqa.selenium.WebElement;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MinItemPageSteps extends BasePage {
    private final MinItemPage minItemPage;

    public MinItemPageSteps() {
        driver.manage().window().maximize();
        this.minItemPage = new MinItemPage();
    }
    private WebElement getSectionCharacteristics(String section){
        return  waitElements(minItemPage.link_tabs)
                .stream()
                .filter(o->o.getText().contains(section))
                .findFirst()
                .get();
    }
    @Step
    public MinItemPageSteps checkSectionCharacteristics(String section){
        WebElement element = getSectionCharacteristics(section);
        assertThat(element.isEnabled(), is(true));
        return this;
    }

    @Step
    public MinItemPageSteps openSectionCharacteristics(String section){
        getSectionCharacteristics(section)
                .click();
        return new MinItemPageSteps();
    }
}
