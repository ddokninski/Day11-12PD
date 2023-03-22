package org.example.widgets;

import org.example.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class SelectableTest extends BaseTest {

    @Test
    public void selectAbleTest() {
        Random random = new Random();
        driver.get("http://www.seleniumui.moderntester.pl/selectmenu.php");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("#speed-button")).click();
        List<WebElement> speedOptions = driver.findElements(By.cssSelector("#speed-menu li"));
        WebElement randomSpeedOption = speedOptions.get(random.nextInt(speedOptions.size()));
        randomSpeedOption.click();

        driver.findElement(By.cssSelector("#files-button")).click();
        List<WebElement> selectFileOptions = driver.findElements(By.cssSelector("#files-menu li[class='ui-menu-item']"));
        for (WebElement selectfileoption : selectFileOptions) {
            if (selectfileoption.getText().equals("Some unknown file"))
                selectfileoption.click();
        }

        driver.findElement(By.cssSelector("#number-button")).click();
        List<WebElement> selectNumberOption = driver.findElements(By.cssSelector("#number-menu li"));
        selectNumberOption.get(10).click();

        driver.findElement(By.cssSelector("#salutation-button")).click();
        List<WebElement> titleOptions = driver.findElements(By.cssSelector("#salutation-menu li[class='ui-menu-item']"));
        titleOptions.get(titleOptions.size() - 1).click();
    }
}
