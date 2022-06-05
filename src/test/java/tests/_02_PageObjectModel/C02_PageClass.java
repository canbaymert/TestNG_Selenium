package tests._02_PageObjectModel;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import pages.FacebookPage;
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
    @Test
    public void test02() {
        FacebookPage facebookPage=new FacebookPage();
        Driver.getDriver().get("https://www.facebook.com");
        // facebookPage.cookieButton.click();
        // Enter a fake e-mail address
        Faker faker=new Faker();
        facebookPage.mailBox.sendKeys(faker.internet().emailAddress());
        // Enter a fake password
        facebookPage.passwordBox.sendKeys(faker.internet().password());
        // Click login button
        facebookPage.loginButton.click();
        // Assert that login is failed
        Assert.assertTrue(facebookPage.loginFailedText.isDisplayed());
        Driver.closeDriver();
    }
}
