package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.UtilityTutorialsNinja;

public class TopMenuTest extends UtilityTutorialsNinja {
    @Before
    public void setUp(){
        openBrowser("http://tutorialsninja.com/demo/index.php?");
    }

    public void selectMenu(String menu){
        //This method should click on the options whatever name is passed as parameter.
        if (menu.equalsIgnoreCase("Show All Desktops")){
            clickOnElement(By.xpath("//a[contains(text(),'Show All Desktops')]"));
        }else if(menu.equalsIgnoreCase("Show All Laptops & Notebooks")){
            clickOnElement(By.xpath("//a[contains(text(),'Show All Laptops & Notebooks')]"));
        }else if(menu.equalsIgnoreCase("Show All Components")){
            clickOnElement(By.xpath("//a[contains(text(),'Show All Components')]"));
        }
    }
    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully(){
        mouseHoverToElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));
        selectMenu("Show All Desktops");
        //define expected text
        String expectedText = "Desktops";
        //get actual text
        String actualText = getTextFromElement(By.xpath("//h2[contains(text(),'Desktops')]"));
        //verify if expected is equal to actual
        Assert.assertEquals("Not on desktop page",expectedText,actualText);
    }
    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully(){
        mouseHoverToElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
        selectMenu("Show All Laptops & Notebooks");
        //define expected text
        String expectedText = "Laptops & Notebooks";
        //get actual text
        String actualText = getTextFromElement(By.xpath("//h2[contains(text(),'Laptops & Notebooks')]"));
        //verify if expected is equal to actual
        Assert.assertEquals("Not on desktop page",expectedText,actualText);
    }
    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully(){
        mouseHoverToElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[3]/a[1]"));
        selectMenu("Show All Components");
        //define expected text
        String expectedText = "Components";
        //get actual text
        String actualText = getTextFromElement(By.xpath("//h2[contains(text(),'Components')]"));
        //verify if expected is equal to actual
        Assert.assertEquals("Not on desktop page",expectedText,actualText);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }


}
