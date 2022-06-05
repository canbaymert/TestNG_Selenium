package tests._06_CrossBrowser;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C04_DataProvider {
    BrcPage brcPage;

    @DataProvider
    public static Object[][] userList() {

        Object[][] userInformation = {{"qsdfgt@news.com", "54678"}, {"xyx@lol.com", "65874"}, {"asfasd@qeırkf.com", "85967"}};
        return userInformation;
    }


    @Test(dataProvider = "userList")
    public void invalidEntry(String userEmail, String password) {
        brcPage = new BrcPage();
        // Navigate to https://www.bluerentalcars.com/
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        // Click login button
        ReusableMethods.waitFor(3);
        brcPage.firstLoginButton.click();
        // Use e-mail data from data provider
        brcPage.emailTextBox.sendKeys(userEmail);
        // Use password data from data provider
        brcPage.passwordTextBox.sendKeys(password);
        ReusableMethods.waitFor(2);
        // Click login button
        brcPage.secondLoginButton.click();
        // Assert that login is failed
        Assert.assertTrue(brcPage.secondLoginButton.isDisplayed());

        Driver.closeDriver();
    }

}
