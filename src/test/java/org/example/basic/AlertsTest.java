package org.example.basic;

import org.assertj.core.api.Assertions;
import org.example.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertsTest extends BaseTest {

String url = "http://www.seleniumui.moderntester.pl/alerts.php";

    @Test
    @DisplayName("Simple alert Pop up test")
    void simpleAlertPopUpTest() {
        //GIVEN
        String expectedMsg = "OK button pressed";
        driver.get(url);
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("#simple-alert")).click();
        driver.switchTo().alert().accept();

        //WHEN
        String actualMsg = driver.findElement(By.cssSelector("p[id='simple-alert-label']")).getText();

        //THEN
        Assertions.assertThat(actualMsg).isEqualTo(expectedMsg);
    }

    @Test
    @DisplayName("Prompt Alert Box test")
    void promptAlertBoxTest() {
        //GIVEN
        String expectedMsg = "Hello Lord Vader! How are you today?";
        driver.get(url);
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("#prompt-alert")).click();
        driver.switchTo().alert().sendKeys("Lord Vader");
        driver.switchTo().alert().accept();
        //WHEN
        String actualMsg = driver.findElement(By.cssSelector("p[id='prompt-label']")).getText();

        //THEN
        Assertions.assertThat(actualMsg).isEqualTo(expectedMsg);

    }

    @Test
    @DisplayName("Confirm Alert Box test")
    void confirmAlertBoxTest() {
        String expectedPositiveMsg = "You pressed OK!";
        String expectedNegativeMsg = "You pressed Cancel!";
        driver.get(url);
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("#confirm-alert")).click();
        driver.switchTo().alert().accept();
        String actualPositiveMsg = driver.findElement(By.cssSelector("#confirm-label")).getText();
        Assertions.assertThat(actualPositiveMsg).isEqualTo(expectedPositiveMsg);
        driver.findElement(By.cssSelector("#confirm-alert")).click();
        driver.switchTo().alert().dismiss();
        String actualNegativeMsg = driver.findElement(By.cssSelector("#confirm-label")).getText();
        Assertions.assertThat(actualNegativeMsg).isEqualTo(expectedNegativeMsg);
    }

    @Test
    @DisplayName("Delayed alert")
    void delayedAlertTest () {
        String expectedMsg = "OK button pressed";
        driver.get(url);
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("#delayed-alert")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        String actualMsg = driver.findElement(By.cssSelector("#delayed-alert-label")).getText();
        Assertions.assertThat(actualMsg).isEqualTo(expectedMsg);
    }
}
