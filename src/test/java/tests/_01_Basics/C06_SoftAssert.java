package tests._01_Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.util.List;

public class C06_SoftAssert extends TestBase {

    @Test(groups = "group2")
    public void test01() {

        // Difference: Even if one soft assertion task fails, test method keeps running and run all assertions.


        SoftAssert softAssert = new SoftAssert();
        driver.get("https://www.amazon.com");
        String expectedTitle = "Amazon";
        String actualTitle = driver.getTitle();

        softAssert.assertTrue(actualTitle.contains(expectedTitle), "Title doesn't includes 'Amazon' word.");

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        softAssert.assertTrue(searchBox.isEnabled(), "Search Box cannot be reached.");

        searchBox.sendKeys("Java" + Keys.ENTER);
        WebElement resultElement = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        softAssert.assertTrue(resultElement.isDisplayed(), "Search failed");

        softAssert.assertTrue(resultElement.getText().contains("Java"), "Result text doesn't include 'Java' word.");

        softAssert.assertAll(); // If assertion fails here, next line of the code will not run.
        System.out.println("All tests passed.");

    }

    @Test
    public void test02() {
        driver.get("http://zero.webappsecurity.com/");
        driver.findElement(By.id("signin_button")).click();
        WebElement loginBox = driver.findElement(By.xpath("//input[@name='user_login']"));
        loginBox.sendKeys("username");
        WebElement passwordBox = driver.findElement(By.xpath("//input[@id='user_password']"));
        passwordBox.sendKeys("password");
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        driver.navigate().back();

        // Navigate to 'Pay Bills' page
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();
        // Click “Purchase Foreign Currency” button
        driver.findElement(By.xpath("//*[text()='Purchase Foreign Currency']")).click();
        // Choose Eurozone as “Currency”
        WebElement ddm = driver.findElement(By.xpath("//select[@name='currency']"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Eurozone (euro)");

        // Use soft assert to test that Eurozone is chosen as currency.
        SoftAssert softAssert = new SoftAssert();
        String chosenOption = select.getFirstSelectedOption().getText();
        String expectedOption = "Eurozone (euro)";
        softAssert.assertEquals(chosenOption, expectedOption, "Wrong currency option was chosen.");
        // Soft assert that first three elements of optionList are : "Select One", "Australia (dollar)", "Canada (dollar)"
        List<WebElement> optionsList = select.getOptions();
        softAssert.assertEquals(optionsList.get(0).getText(), "Select One", "Unexpected element on Drop Down Menu");
        softAssert.assertEquals(optionsList.get(1).getText(), "Australia (dollar)", "Unexpected element on Drop Down Menu");
        softAssert.assertEquals(optionsList.get(2).getText(), "Canada (dollar)", "Unexpected element on Drop Down Menu");

        softAssert.assertAll(); // If assertion fails here, next line of the code will not run.
        System.out.println("All tests passed.");
    }
}
