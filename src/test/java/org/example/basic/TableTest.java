package org.example.basic;

import org.example.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class TableTest extends BaseTest {

    @Test
    void mountainTest() {
        driver.get("http://www.seleniumui.moderntester.pl/table.php");
        testExecute(driver);
    }

    public void testExecute(WebDriver driver) {
        driver.manage().window().maximize();
        List<WebElement> picksList = driver.findElements(By.cssSelector("tbody > tr"));

        List<WebElement> filteredPickList = picksList.stream()
                .filter(webElement -> Integer.parseInt(webElement.findElement(By.xpath("./td[4]")).getText()) > 4000)
                .filter(webElement -> webElement.getText().contains("Switzerland"))
                .toList();

        for (WebElement webElement : filteredPickList) {
            System.out.print(webElement.findElement(By.xpath("./th[1]")).getText() + " ");
            System.out.print(webElement.findElement(By.xpath("./td[1]")).getText() + " ");
            System.out.println(webElement.findElement(By.xpath("./td[2]")).getText());
        }
    }
}
