package org.example.interactions;

import org.assertj.core.api.Assertions;
import org.example.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DroppableTest extends BaseTest {

    @Test
    @DisplayName("Droppalble test")
    void dropElementTest() {
        driver.get("http://www.seleniumui.moderntester.pl/droppable.php");
        driver.manage().window().maximize();
        WebElement drag = driver.findElement(By.cssSelector("#draggable"));
        WebElement drop = driver.findElement(By.cssSelector("#droppable"));

        Actions actions = new Actions(driver);

        actions.clickAndHold(drag)
                .moveToElement(drop)
                .release()
                .perform();

        Assertions.assertThat(driver.findElement(By.cssSelector("#droppable")).getText()).isEqualTo("Dropped!");
    }
}
