package org.example.widgets;

import org.example.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class TooltipTest extends BaseTest {

    @Test
    @DisplayName("Tooltip test")
    void tooltipTest () {
        driver.get("http://www.seleniumui.moderntester.pl/tooltip.php");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("#age")).click();
        System.out.println(driver.findElement(By.cssSelector(".ui-tooltip-content")).getText());
    }
}
