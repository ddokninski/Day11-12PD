package org.example.widgets;

import org.example.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccordionTest extends BaseTest {

    @Test
    @DisplayName("Accordion test")
    void accordionTest() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://www.seleniumui.moderntester.pl/accordion.php");
        driver.manage().window().maximize();

        System.out.println(driver.findElement(By.cssSelector("#ui-id-2")).getText());

        driver.findElement(By.cssSelector("#ui-id-3")).click();
        wait.until(ExpectedConditions.attributeContains(By.cssSelector("#ui-id-3"), "aria-expanded", "true"));
        System.out.println(driver.findElement(By.cssSelector("#ui-id-4")).getText());

        driver.findElement(By.cssSelector("#ui-id-5")).click();
//        wait.until(ExpectedConditions.attributeContains(By.cssSelector("#ui-id-5"),"aria-expanded", "true"));
        Thread.sleep(500);
        System.out.println(driver.findElement(By.cssSelector("#ui-id-6")).getText());

        driver.findElement(By.cssSelector("#ui-id-7")).click();
//        wait.until(ExpectedConditions.attributeContains(By.cssSelector("#ui-id-7"),"aria-expanded", "true"));
        Thread.sleep(500);
        System.out.println(driver.findElement(By.cssSelector("#ui-id-8")).getText());
    }
}
