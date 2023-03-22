package org.example.basic;

import org.example.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class WindowTabsTest extends BaseTest {

    @Test
    public void windowTabsTest() {
        driver.get("http://www.seleniumui.moderntester.pl/windows-tabs.php");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        TableTest tableTest = new TableTest();
        String originalWindow = driver.getWindowHandle();

        assert driver.getWindowHandles().size() == 1;

        driver.findElement(By.cssSelector("#newBrowserWindow")).click();
        waitAndSwitchToNewWindow(wait, originalWindow);
        tableTest.testExecute(driver);
        driver.close();
        driver.switchTo().window(originalWindow);


        driver.findElement(By.cssSelector("#newMessageWindow")).click();
        waitAndSwitchToNewWindow(wait, originalWindow);
        System.out.println(driver.findElement(By.cssSelector("body")).getText());
        driver.close();
        driver.switchTo().window(originalWindow);

        driver.findElement(By.cssSelector("#newBrowserTab")).click();
        waitAndSwitchToNewWindow(wait, originalWindow);
        tableTest.testExecute(driver);
        driver.close();
        driver.switchTo().window(originalWindow);
    }

    private void waitAndSwitchToNewWindow(WebDriverWait wait, String originalWindow) {
        wait.until(numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
}
