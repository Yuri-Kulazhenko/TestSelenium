package logic.steps;

import logic.annotations.Step;
import logic.pages.ComputerNotebookPage;
import logic.setup.BasePage;
import logic.steps.pdp.PlpNotebookPageSteps;
import org.openqa.selenium.WebElement;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ComputerNotebookPageSteps extends BasePage {
    private final ComputerNotebookPage computerNotebookPage;

    public ComputerNotebookPageSteps() {
        driver.manage().window().maximize();
        this.computerNotebookPage = new ComputerNotebookPage();
    }

    private    WebElement getSectionComputerNotebook(String section){
        return  waitElements(computerNotebookPage.link_sections)
                .stream()
                .filter(o->o.getAttribute("alt").contains(section))
                .findFirst()
                .get();
    }

    @Step
    public ComputerNotebookPageSteps checkSection(String section){
        WebElement element = getSectionComputerNotebook(section);
        assertThat(element.isEnabled(), is(true));
        return this;
    }

    @Step
    public PlpNotebookPageSteps openSectionNotebook(String section){
                getSectionComputerNotebook(section)
                .click();
        return new PlpNotebookPageSteps();
    }
}
