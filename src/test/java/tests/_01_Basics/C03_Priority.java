package tests._01_Basics;

import org.testng.annotations.Test;
import utilities.TestBase;

public class C03_Priority extends TestBase {
     /*
     Test methods works according to alphabetical order if they have same priority.
     Default priority is 0 (if not assigned)
     Method with the smallest priority value starts working first.
     */

    @Test (priority = -5)
    public void amazonTest() {
        driver.get("https://www.amazon.com");
        System.out.println(driver.getCurrentUrl());
    }

    @Test (priority = -2)
    public void bestbuyTest() {
        driver.get("https://www.bestbuy.com");
        System.out.println(driver.getCurrentUrl());
    }

    @Test(groups = "group1")
    public void facebookTest() {
        driver.get("https://www.facebook.com");
        System.out.println(driver.getCurrentUrl());
    }
}
