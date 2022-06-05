package tests._01_Basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.time.Duration;

public class C04_DependsOnMethods extends TestBase {

    // Doesn't affect priority.
    // If a method has a dependency to another method, it won't work unless this method works.

    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
    }
    @Test (dependsOnMethods ="test01" , priority = 0)
    public void test02(){
        // If test01 doesn't work, test02 will fail automatically and won't even start.
        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Java" + Keys.ENTER);
    }
    @Test (dependsOnMethods ="test02")
    public void test03(){
        // If test02 doesn't work, test03 will fail automatically and won't even start.
        WebElement resultElement= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(resultElement.getText().contains("Java"));
    }
    @Test(groups = {"group1", "group2"})
    public void test04(){
        System.out.println("Method works.");
    }
}
