package tests._02_PageObjectModel;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_ConfigReader {
    @Test
    public void test01() {

        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        Driver.getDriver().get(ConfigReader.getProperty("facebookUrl"));
        Driver.closeDriver();
    }
    @Test
    public void test02() {
        FacebookPage facebookPage=new FacebookPage();

        Driver.getDriver().get(ConfigReader.getProperty("facebookUrl"));

        facebookPage.cookieButton.click();
        // Enter an invalid mail address
        facebookPage.mailBox.sendKeys(ConfigReader.getProperty("fbWrongUsername"));
        // Enter an invalid password
        facebookPage.passwordBox.sendKeys(ConfigReader.getProperty("fbWrongPassword"));
        // Click login button
        facebookPage.loginButton.click();
        // Assert that login is failed
        Assert.assertTrue(facebookPage.loginFailedText.isDisplayed());
        // Close driver
        Driver.closeDriver();
    }
}
