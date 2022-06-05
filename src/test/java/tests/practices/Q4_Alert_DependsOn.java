package tests.practices;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WebDriverUniversityPage;
import utilities.Driver;

public class Q4_Alert_DependsOn  {

     // Task 1
     // 1. Go to url :"http://webdriveruniversity.com/Popup-Alerts/index.html"
     // 2. Click "JavaScript Alert" button
     // 3. Confirm the java script alert
     // 4. Assert

     // Task 2
     // 1. Go to url : "http://webdriveruniversity.com/Popup-Alerts/index.html"
     // 2. Click "JavaScript Confirm Box" button
     // 3. Cancel the alert
     // 4. Assert
     // 5. dependsOnMethod1

    @Test
    public void alert1(){
        Driver.getDriver().get("http://webdriveruniversity.com/Popup-Alerts/index.html");

        WebDriverUniversityPage wdup = new WebDriverUniversityPage();
        wdup.javaScriptAlert.click();
        String actualMessage = Driver.getDriver().switchTo().alert().getText();
        String expectedMessage ="I am an alert box!";
        Assert.assertEquals(actualMessage, expectedMessage);

        Driver.getDriver().switchTo().alert().accept();
    }

    @Test(dependsOnMethods="alert1")
    public void alert2(){
        Driver.getDriver().get("http://webdriveruniversity.com/Popup-Alerts/index.html");

        WebDriverUniversityPage wdup = new WebDriverUniversityPage();
        wdup.javaScriptConfirmBox.click();
        Alert alert = Driver.getDriver().switchTo().alert();

        String expectedMessage= "Press a button!";
        Assert.assertEquals(alert.getText(),expectedMessage);

        alert.dismiss();
        Assert.assertTrue(wdup.textElement.isDisplayed());
    }

}

