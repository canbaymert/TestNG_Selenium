package tests.practices;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Q6_RegisterTwitter extends TestBase {

    // Register to twitter
    @Test
    public void register() throws InterruptedException {

        Faker faker = new Faker();
        driver.get("https://www.twitter.com");
        WebElement register = driver.findElement(By.xpath("//a[@data-testid='signupButton']"));
        register.click();

        WebElement emailInstead = driver.findElement(By.xpath("//span[.='Use email instead']"));
        emailInstead.click();
        WebElement name = driver.findElement(By.name("name"));
        name.sendKeys(faker.funnyName().name());
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys(faker.internet().emailAddress());

        Thread.sleep(2000);

        WebElement month = driver.findElement(By.xpath("//select[@id='SELECTOR_1']"));  //ay
        WebElement day = driver.findElement(By.xpath("//select[@id='SELECTOR_2']"));  //gun
        WebElement year = driver.findElement(By.xpath("//select[@id='SELECTOR_3']"));  //yil

        Select select = new Select(month);
        select.selectByIndex(faker.number().numberBetween(1,13));
        Select select1 = new Select(day);
        select1.selectByIndex(faker.random().nextInt(1, 30));
        Select select2= new Select(year);
        select2.selectByIndex(faker.random().nextInt(1, 120));

        WebElement nextButton = driver.findElement(By.xpath("//span[text()='Next']"));
        nextButton.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ignored) {

        }
        driver.findElement(By.xpath("(//span[.='Next'])[2]")).click();
    }
}
