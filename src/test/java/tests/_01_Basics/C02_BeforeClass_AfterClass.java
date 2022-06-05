package tests._01_Basics;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_BeforeClass_AfterClass extends TestBase {

    // Works once before and after class

    @BeforeClass
    public void beforeClassMethod() {
        System.out.println("Before Class");
    }

    @AfterClass
    public void afterClassMethod() {
        System.out.println("After Class");
    }

    @Test
    public void amazonTest() {
        driver.get("https://www.amazon.com");
        System.out.println(driver.getCurrentUrl());
    }

    @Test
    public void bestbuyTest() {
        driver.get("https://www.bestbuy.com");
        System.out.println(driver.getCurrentUrl());
    }

}
