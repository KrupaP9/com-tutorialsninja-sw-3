package myaccounts;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import utilities.UtilityTutorialsNinja;

import java.util.List;

public class MyAccountsTest extends UtilityTutorialsNinja {
    @Before
    public void setUp() {
        openBrowser("http://tutorialsninja.com/demo/index.php?");
    }

    public void selectMyAccountOptions(String option) {
        //This method should click on the options whatever name is passed as parameter.
        List<WebElement> registerList = driver.findElements(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li"));//list with two options(do multi select)
        try {
            for (WebElement option1 : registerList) {
                System.out.println(option1.getText());
                if (option1.getText().equals(option)) {
                    option1.click();
                    //break;
                }
            }

        } catch (StaleElementReferenceException e) {
            registerList = driver.findElements(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li"));//same as line21
        }
    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));//myaccount
        selectMyAccountOptions("Register");//to click on register button
        String expectedTextRegister = "Register Account";
        String actualTextRegister = getTextFromElement(By.xpath("//div[@id='content']/h1"));
        //verify if expected equals actual
        Assert.assertEquals("not on register page", expectedTextRegister, actualTextRegister);
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));//myaccount
        selectMyAccountOptions("Login");//to click on login button
        String expectedTextLogin = "Returning Customer";
        String actualTextLogin = getTextFromElement(By.xpath("//div[@class='well']/h2[text()='Returning Customer']"));
        //verify if expected equals actual
        Assert.assertEquals("not on login page", expectedTextLogin, actualTextLogin);
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() {
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));//myaccount
        selectMyAccountOptions("Register");//to click on register button
        //3.3 Enter First Name
        sendTextToElement(By.name("firstname"), "Kiera");
        //3.4 Enter Last Name
        sendTextToElement(By.name("lastname"), "Smithson");
        //3.5 Enter Email
        sendTextToElement(By.name("email"), "SmithsonKieranK@gmail.com");
        //3.6 Enter Telephone
        sendTextToElement(By.name("telephone"), "07612345678");
        //3.7 Enter Password
        sendTextToElement(By.name("password"), "Passwordnum1");
        //3.8 Enter Password Confirm
        sendTextToElement(By.name("confirm"), "Passwordnum1");
        //3.9 Select Subscribe Yes radio button
        clickOnElement(By.name("newsletter"));
        //3.10 Click on Privacy Policy check box
        clickOnElement(By.name("agree"));
        //3.11 Click on Continue button
        clickOnElement(By.xpath("//input[@type='submit']"));
        //expected text
        String expectedCreation = "Your Account Has Been Created!";
        //actual text
        String actualCreation = getTextFromElement(By.xpath("//div[@id='content']/h1"));
        //3.12 Verify the message “Your Account Has Been Created!”
        Assert.assertEquals("account not created", expectedCreation, actualCreation);
        //3.13 Click on Continue button
        clickOnElement(By.xpath("//a[text()='Continue']"));
        //3.14 Click on My Account Link.
        clickOnElement(By.xpath("//a[@title='My Account']"));
        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountOptions("Logout");
        String expectedTextLogout = "Account Logout";
        String actualTextLogout = getTextFromElement(By.xpath("//h1[contains(text(),'Account Logout')]"));
        //3.16 Verify the text “Account Logout”
        Assert.assertEquals("not logged out", expectedTextLogout, actualTextLogout);
        //3.17 Click on Continue button
        clickOnElement(By.xpath("//a[@class='btn btn-primary']"));
    }
    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully(){
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));//myaccount
        selectMyAccountOptions("Login");//to click on register button
        //enter email
        sendTextToElement(By.name("email"),"SmithsonKieranK@gmail.com");
        //enter password
        sendTextToElement(By.name("password"),"Passwordnum1");
        //click login
        clickOnElement(By.xpath("//input[@value='Login']"));
        String expectedTextMyAccount = "My Account";
        String actualTextMyAccount = getTextFromElement(By.xpath("//div[@id='content']/h2[text()='My Account']"));
        //verify if expected equals actual
        Assert.assertEquals("Not on my account",expectedTextMyAccount,actualTextMyAccount);
        //click my account
        clickOnElement(By.xpath("//a[@title='My Account']"));
        //choose logout
        selectMyAccountOptions("Logout");
        String expectedTextLogout = "Account Logout";
        String actualTextLogout = getTextFromElement(By.xpath("//div[@id='content']/h1"));
        //verify if expected equals actual
        Assert.assertEquals("Not logged out",expectedTextLogout,actualTextLogout);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
