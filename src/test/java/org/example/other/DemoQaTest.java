package org.example.other;

import org.assertj.core.api.Assertions;
import org.example.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class DemoQaTest extends BaseTest {

    @Test
    void demoQaTest() {
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("#subjectsInput")).sendKeys("m");
        driver.findElement(By.xpath("//div[.='Maths']")).click();
        driver.findElement(By.cssSelector("#subjectsInput")).sendKeys("a");
        driver.findElement(By.xpath("//div[.='Arts']")).click();
        String actualValue = driver.findElement(By.cssSelector("div[class='subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi subjects-auto-complete__value-container--has-value css-1hwfws3']")).getText();
        Assertions.assertThat(actualValue).isEqualTo("Maths\n" + "Arts");
    }
}
