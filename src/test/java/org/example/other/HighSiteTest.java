package org.example.other;

import org.apache.commons.io.FileUtils;
import org.example.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;

public class HighSiteTest extends BaseTest {

    @Test
    @DisplayName("High site test using JS")
    void scrollToElementTestUsingJS() throws IOException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("http://www.seleniumui.moderntester.pl/high-site.php");
        driver.manage().window().maximize();

        while (!isDisplayed(By.cssSelector("#scroll-button"))) {
            js.executeScript("window.scrollBy(0,100)");
        }
        takeScreenshot();
    }

    @Test
    @DisplayName("High site test using actions")
    void scrollToElementTestUsingActions() throws IOException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("http://www.seleniumui.moderntester.pl/high-site.php");
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);

        while (!isDisplayed(By.cssSelector("#scroll-button"))) {
            actions.scrollByAmount(0, 100).perform();
        }
        takeScreenshot();
    }

    public boolean isDisplayed(By by) {
        try {
            return driver.findElement(by).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void takeScreenshot() throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File SrcFile = screenshot.getScreenshotAs(OutputType.FILE);
        File file = new File("C:\\screen\\screenshot.png");
        FileUtils.copyFile(SrcFile, file);
    }
}
