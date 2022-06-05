package tests._03_SmokeTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_NegativeLoginTest {
    BrcPage brcPage;
    @Test
    public void negativeLoginTest() {
        brcPage=new BrcPage();
        // Navigate to https://www.bluerentalcars.com/
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        // Click login button
        ReusableMethods.waitFor(2);
        brcPage.firstLoginButton.click();
        // Enter a valid e-mail address
        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcValidEmail"));
        // Enter an invalid password
        brcPage.passwordTextBox.sendKeys(ConfigReader.getProperty("brcWrongPassword"));
        // Click login button
        brcPage.secondLoginButton.click();
        // Assert that login is failed
        Assert.assertTrue(brcPage.secondLoginButton.isDisplayed());
        Driver.closeDriver();
    }
}
