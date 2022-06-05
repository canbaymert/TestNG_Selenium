package tests._02_PageObjectModel;

import org.testng.annotations.Test;
import utilities.Driver;


public class C01_Driver {

    @Test(groups = "group1")
    public void test01() {
        Driver.getDriver().get("https://www.amazon.com");
        Driver.closeDriver();
        Driver.getDriver().get("https://www.bestbuy.com");
        Driver.getDriver().get("https://www.facebook.com");
        Driver.closeDriver();

    }
}
