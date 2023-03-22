package org.example.widgets;

import org.assertj.core.api.Assertions;
import org.example.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class SliderTest extends BaseTest {

    @Test
    @DisplayName("Slider test")
    void moveSlider() {
        driver.get("http://www.seleniumui.moderntester.pl/slider.php");
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.cssSelector("#custom-handle"));
        moveSliderTo(element, 50);
        Assertions.assertThat(element.getText()).isEqualTo("50");
        moveSliderTo(element, 80);
        Assertions.assertThat(element.getText()).isEqualTo("80");
        moveSliderTo(element, 80);
        Assertions.assertThat(element.getText()).isEqualTo("80");
        moveSliderTo(element, 20);
        Assertions.assertThat(element.getText()).isEqualTo("20");
        moveSliderTo(element, 0);
        Assertions.assertThat(element.getText()).isEqualTo("0");
    }

    private void moveSliderTo(WebElement element, int moveTo) {
        int sliderValue = Integer.parseInt((element).getText());
        if (moveTo < sliderValue) {
            for (int i = 0; i < sliderValue - moveTo; i++) {
                element.sendKeys(Keys.ARROW_LEFT);
            }
        } else if (moveTo > sliderValue) {
            for (int i = 0; i < moveTo - sliderValue; i++) {
                element.sendKeys(Keys.ARROW_RIGHT);
            }
        }
    }
}
