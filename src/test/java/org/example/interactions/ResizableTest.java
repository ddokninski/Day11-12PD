package org.example.interactions;

import org.example.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ResizableTest extends BaseTest {

    @Test
    public void resizableTest() {
        Actions actions = new Actions(driver);
        driver.get("http://www.seleniumui.moderntester.pl/resizable.php");
        driver.manage().window().maximize();
        WebElement elementToClick = driver.findElement(By.cssSelector("div[class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));
        actions.clickAndHold(elementToClick);
        actions.moveByOffset(10, 0).release().perform();

        actions.clickAndHold(elementToClick);
        actions.moveByOffset(0, 10).release().perform();

        actions.clickAndHold(elementToClick);
        actions.moveByOffset(10, -10).release().perform();
    }
}
