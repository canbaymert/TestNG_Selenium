package tests._06_CrossBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBaseCross;

public class C02_SoftAssertCross extends TestBaseCross {

    @Test
    public void test01() {

        SoftAssert softAssert=new SoftAssert();

        // Navigate to amazon
        driver.get("https://www.amazon.com");
        // Assert that title includes "Amazon" keyword
        String expectedTitle="Amazon";
        String actualTitle= driver.getTitle();
        softAssert.assertTrue(actualTitle.contains(expectedTitle),"Title doesn't include 'Amazon' keyword");
        // Assert that the searchBox is enabled
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        softAssert.assertTrue(searchBox.isEnabled(),"Search Box is not available");
        // Search for Java
        searchBox.sendKeys("Java" + Keys.ENTER);
        // Assert that search is successful
        WebElement resultElement= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        softAssert.assertTrue(resultElement.isDisplayed(),"Search failed");
        // Assert that result includes "Java" keyword
        softAssert.assertTrue(resultElement.getText().contains("Java"),"Result text doesn't include 'Java' keyword");

        softAssert.assertAll();

    }
}
