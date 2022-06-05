package tests._04_ReusableMethods;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_WindowHandle {

    @Test
    public void windowHandle() {
        // Navigate to https://the-internet.herokuapp.com/windows
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        // Click 'Click Here' button.
        Driver.getDriver().findElement(By.linkText("Click Here")).click();
        // Assert that the title of the new window is "New window".
        ReusableMethods.switchToWindow("New Window");

        String expectedTitle="New Window";
        String actualTitle=Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);
        Driver.closeDriver();
    }

}
