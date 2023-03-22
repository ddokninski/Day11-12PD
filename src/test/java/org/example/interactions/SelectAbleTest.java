package org.example.interactions;

import org.assertj.core.api.Assertions;
import org.example.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SelectAbleTest extends BaseTest {

    @Test
    @DisplayName("Selectable test")
    void checkTextAfterSelectElements() {
        String expectedText = "You've selected: #1 #3 #4.";
        driver.get("http://www.seleniumui.moderntester.pl/selectable.php");
        driver.manage().window().maximize();
        WebElement element1 = driver.findElement(By.xpath("//li[@class='ui-widget-content ui-selectee'][1]"));
        WebElement element3 = driver.findElement(By.xpath("//li[@class='ui-widget-content ui-selectee'][3]"));
        WebElement element4 = driver.findElement(By.xpath("//li[@class='ui-widget-content ui-selectee'][4]"));

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).click(element1).click(element3).click(element4).keyUp(Keys.CONTROL).build().perform();

        String actualText = driver.findElement(By.cssSelector("#feedback")).getText();

        Assertions.assertThat(actualText).isEqualTo(expectedText);
    }
}
