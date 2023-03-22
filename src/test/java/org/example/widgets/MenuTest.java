package org.example.widgets;

import org.example.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.time.Duration;

public class MenuTest extends BaseTest {

    @Test
    @DisplayName("Menu test")
    void menuTest() {
        driver.get("http://www.seleniumui.moderntester.pl/menu-item.php");
        driver.manage().window().maximize();
        //implicitly wait tutaj tylko na potrzeby pracy domowej
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.findElement(By.cssSelector("#ui-id-9")).click();
        driver.findElement(By.cssSelector("#ui-id-13")).click();
        driver.findElement(By.cssSelector("#ui-id-16")).click();
    }
}
