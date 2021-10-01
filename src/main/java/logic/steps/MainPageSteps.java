package logic.steps;

import logic.annotations.Step;
import logic.pages.HeaderPage;
import logic.pages.MainPage;
import logic.setup.BasePage;
import org.openqa.selenium.WebElement;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MainPageSteps extends BasePage {
    private final MainPage mainPage;
    public HeaderPage headerPage;

    public MainPageSteps() {
        driver.manage().window().maximize();
        this.mainPage = new MainPage();
        this.headerPage = new HeaderPage();
    }

    private WebElement getMainSection(String section){
        return   waitElements(mainPage.link_main_sections)
                .stream()
                .filter(o->o.getText().contains(section))
                .findFirst()
                .get();
    }

    @Step
    public MainPageSteps checkSection(String section){
        WebElement element = getMainSection(section);
        assertThat(element.isEnabled(), is(true));
        return this;
    }

    @Step
    public ComputerNotebookPageSteps openSection(String section){
        getMainSection(section).click();
        return new ComputerNotebookPageSteps();
    }



}
