package org.example.widgets;

import org.example.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProgressbarTest extends BaseTest {

    @Test
    public void progressbarTest() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://www.seleniumui.moderntester.pl/progressbar.php");
        driver.manage().window().maximize();
        wait.until(c -> driver.findElement(By.cssSelector("div[class='progress-label']")).getText().equals("Complete!"));

    }

    @Test
    public void progressbarTest2() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://www.seleniumui.moderntester.pl/progressbar.php");
        driver.manage().window().maximize();
        wait.until(ExpectedConditions.attributeContains(By.cssSelector(".ui-progressbar-value"), "class", "ui-progressbar-complete"));

    }
}
