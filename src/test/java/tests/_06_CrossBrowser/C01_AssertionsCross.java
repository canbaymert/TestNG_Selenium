package tests._06_CrossBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseCross;

public class C01_AssertionsCross extends TestBaseCross {

    @Test
    public void test01() {

        // Navigate to amazon
        driver.get("https://www.amazon.com");
        // Assert that title includes "Amazon" keyword
        String expectedTitle="Amazon";
        String actualTitle= driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle),"Title doesn't include 'Amazon' keyword");
        // Assert that the searchBox is enabled
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertTrue(searchBox.isEnabled(),"Search Box is not available");
        // Search for Java
        searchBox.sendKeys("Java" + Keys.ENTER);
        // Assert that search is successful
        WebElement resultElement= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(resultElement.isDisplayed(),"Search failed");
        // Assert that result includes "Java" keyword
        Assert.assertTrue(resultElement.getText().contains("Java"),"Result text doesn't include 'Java' keyword");

    }
}
