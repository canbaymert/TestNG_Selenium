package tests._02_PageObjectModel;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C02_PageClass {

    @Test
    public void test01() {
        AmazonPage amazonPage=new AmazonPage();
        Driver.getDriver().get("https://www.amazon.com");
        amazonPage.searchBox.sendKeys("Java"+ Keys.ENTER);
        String actualResult=amazonPage.searchResultElement.getText();
        String keyword="Java";
        // Assert that the result includes Java keyword.
        Assert.assertTrue(actualResult.contains(keyword));
    }
}
