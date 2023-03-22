package org.example.interactions;

import org.example.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortableTest extends BaseTest {

    @Test
    public void sortableTest() {
        List<Integer> intList = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            intList.add(i + 1);
        }
        Collections.shuffle(intList);

        driver.get("http://www.seleniumui.moderntester.pl/sortable.php");
        driver.manage().window().maximize();
        List<WebElement> elementsList = driver.findElements(By.cssSelector("#sortable li"));
        Actions actions = new Actions(driver);

        for (int i = 0; i < elementsList.size(); i++) {
            Integer integer = intList.get(i);

            System.out.println(driver.findElement(By.xpath("//li[contains(text(),'" + (integer) + "')]")).getText());
            WebElement elementToMove = driver.findElement(By.xpath("//li[contains(text(),'" + (integer) + "')]"));
            WebElement elementToHover = driver.findElement(By.xpath("//li[contains(text(),'" + (i + 1) + "')]"));
            actions.clickAndHold(elementToMove)
                    .moveToElement(elementToHover)
                    .release()
                    .perform();
        }
    }
}
