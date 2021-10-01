
package tests;

import logic.constants.*;
import logic.setup.BasePage;
import logic.steps.MainPageSteps;
import logic.steps.MinItemPageSteps;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestApplication extends BasePage {



    @BeforeTest
    public void install(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://rozetka.com.ua/");

    }

    @AfterTest
    public void cleanUP(){
        //driver.close();
    }

    @Test(timeOut = 200000 )
    public void test001_OpenRandomPage(){

        MinItemPageSteps randomPageSteps = new MainPageSteps()
                .checkSection(Sections.COMPUTERS_AND_NOTEBOOKS.get())
                .openSection(Sections.COMPUTERS_AND_NOTEBOOKS.get())
                .checkSection(ComputerNotebookSectioons.NOTEBOOKS.get())
                .openSectionNotebook(ComputerNotebookSectioons.NOTEBOOKS.get())
                .selectFilter(SelectingDropdownMods.TEXT.get(), GoodsSelectingMods.NOVELTY.get())
                .openRandomPage()
                .minPriceItem()
                .checkSectionCharacteristics(ItemSection.CHARACTERISTICS.get())
                .openSectionCharacteristics(ItemSection.CHARACTERISTICS.get());

    }




}