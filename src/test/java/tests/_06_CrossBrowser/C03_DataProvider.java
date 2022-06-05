package tests._06_CrossBrowser;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_DataProvider {

    @Test
    public void test01() {
        AmazonPage amazonPage=new AmazonPage();
        // Navigate to amazon
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        // Search for Java
        amazonPage.searchBox.sendKeys("Java" + Keys.ENTER);
        // Assert that result includes the "Java" keyword
        String expectedKeyword="Java";
        String actualResultText=amazonPage.searchResultElement.getText();
        Assert.assertTrue(actualResultText.contains(expectedKeyword));

        Driver.closeDriver();

    }

    @DataProvider
    public static Object[][] keywords() {

      Object[][] keywordsArray= {{"Java"}, {"Mercedes"}, {"Batman"} , {"Laptop"}};
        return keywordsArray;
    }
    @Test(dataProvider = "keywords")
        // dataProvider sends the stored data one by one
    public void test02(String keyword) {
        AmazonPage amazonPage=new AmazonPage();
        // Navigate to amazon
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        // Search for Java, Mercedes, Batman, and Laptop
        amazonPage.searchBox.sendKeys(keyword + Keys.ENTER);
        // Assert that the results includes the expected keywords
        String expectedKeyword=keyword;
        String actualResultText=amazonPage.searchResultElement.getText();
        Assert.assertTrue(actualResultText.contains(expectedKeyword));

        Driver.closeDriver();
    }
}
