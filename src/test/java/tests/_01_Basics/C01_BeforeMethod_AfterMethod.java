package tests._01_Basics;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C01_BeforeMethod_AfterMethod extends TestBase {

    // Works before and after all test methods

    @Test
    public void amazonTest() {
        driver.get("https://www.amazon.com");
    }

    @BeforeMethod
    public void test01() {
        driver.get("https://www.bestbuy.com");
    }

    @AfterMethod
    public void test02() {
        driver.get("https://www.bestbuy.com");
    }

}
