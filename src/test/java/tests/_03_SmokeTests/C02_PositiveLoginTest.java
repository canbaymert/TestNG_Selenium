package tests._03_SmokeTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_PositiveLoginTest {
    BrcPage brcPage = new BrcPage();

    @Test
    public void positiveLoginTest() {
        // Navigate to https://www.bluerentalcars.com/
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        // Click login button
        brcPage.firstLoginButton.click();
        // Enter a valid e-mail address
        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcValidEmail"));
        // Enter a valid password
        brcPage.passwordTextBox.sendKeys(ConfigReader.getProperty("brcValidPassword"));
        // Click second login button
        brcPage.secondLoginButton.click();
        // Assert that login is successful
        String actualUsername = brcPage.userProfileName.getText();
        String expectedUsername = ConfigReader.getProperty("brcValidUsername");
        Assert.assertEquals(actualUsername, expectedUsername);
        Driver.closeDriver();
    }
}
