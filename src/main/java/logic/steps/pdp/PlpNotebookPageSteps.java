package logic.steps.pdp;
import logic.annotations.Step;
import logic.pages.plp.PlpNotebookPage;
import logic.setup.BasePage;
import logic.steps.RandomPageSteps;
import org.openqa.selenium.support.ui.Select;


public class PlpNotebookPageSteps extends BasePage {
    private final PlpNotebookPage plpPage;

    public PlpNotebookPageSteps() {
        driver.manage().window().maximize();
        this.plpPage = new PlpNotebookPage();
    }

    @Step
    public RandomPageSteps selectFilter(String type, String value){

        Select select = new Select( waitElement(plpPage.slct_filter));
        switch (type){
            case "byIndex":{
                select.selectByIndex(Integer.parseInt(value));
                break;
            }
            case "byValue":{
                select.selectByValue(value);
                break;
            }
            case "byVisibleText":{
                select.selectByVisibleText(value);
                break;
            }
            default:
                throw new IllegalArgumentException("Invalid type of selection.");
        }

        try {
            Thread.sleep(8*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new  RandomPageSteps();
    }
}
