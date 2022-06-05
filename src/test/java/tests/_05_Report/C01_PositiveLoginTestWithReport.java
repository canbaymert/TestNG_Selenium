package tests._05_Report;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;
public class C01_PositiveLoginTestWithReport extends TestBaseRapor {
    BrcPage brcPage;
    @Test
    public void positiveLoginTest() {
        brcPage=new BrcPage();
        extentTest=extentReports.createTest("Positive Login","Login preocess should be completed with a valid username and password");
        // Navigate to https://www.bluerentalcars.com/
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        extentTest.info("BRC Homepage was displayed.");
        // Click login button
        brcPage.firstLoginButton.click();
        extentTest.info("Login button was clicked.");
        // Enter a valid e-mail address
        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcValidEmail"));
        extentTest.info("A valid e-mail address was entered.");
        // Enter a valid password
        brcPage.passwordTextBox.sendKeys(ConfigReader.getProperty("brcValidPassword"));
        extentTest.info("A valid password was entered.");
        // Click second login button
        brcPage.secondLoginButton.click();
        extentTest.info("Second login button was clicked.");
        // Assert that login is successful.

        String actualUsername= brcPage.userProfileName.getText();
        String expectedUsername=ConfigReader.getProperty("brcValidUsername");
        Assert.assertEquals(actualUsername,expectedUsername);
        extentTest.pass("Login process was completed successfully");
        Driver.closeDriver();

    }
}
