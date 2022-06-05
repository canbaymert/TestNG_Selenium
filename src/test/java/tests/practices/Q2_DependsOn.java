package tests.practices;

import org.testng.annotations.Test;
import utilities.TestBase;

public class Q2_DependsOn extends TestBase {


    @Test
    public void facebookTest(){
        driver.get("http://www.facebook.com");
    }

    @Test(dependsOnMethods="facebookTest")
    public void googleTest(){
        driver.get("http://www.google.com");
    }

    @Test(dependsOnMethods="googleTest")
    public void amazonTest(){
        driver.get("http://www.amazon.com");
    }
}
