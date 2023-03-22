package org.example.interactions;

import org.example.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DraggableTest extends BaseTest {

    @Test
    public void draggalbeTest() {
        Actions actions = new Actions(driver);
        driver.get("http://www.seleniumui.moderntester.pl/draggable.php");
        driver.manage().window().maximize();
        Dimension windowSize = driver.manage().window().getSize();

        WebElement elementToDrag = driver.findElement(By.cssSelector("#draggable"));
        Dimension sizeOfElement = elementToDrag.getSize();
        Point locationOfElement = elementToDrag.getLocation();

        actions.clickAndHold(elementToDrag);
        actions.moveByOffset(windowSize.getWidth() - locationOfElement.getX() - sizeOfElement.getWidth(), -locationOfElement.getY());
        actions.perform();
        locationOfElement = elementToDrag.getLocation();
        actions.clickAndHold(elementToDrag);
//        actions.moveByOffset(windowSize.getWidth() - locationOfElement.getX() - sizeOfElement.getWidth(), windowSize.getHeight() - sizeOfElement.getHeight() - locationOfElement.getY() - 200);
        actions.moveByOffset(windowSize.getWidth() - locationOfElement.getX() - sizeOfElement.getWidth(), windowSize.getHeight() - sizeOfElement.getHeight() * 2);
        actions.perform();
        locationOfElement = elementToDrag.getLocation();
        actions.clickAndHold(elementToDrag);
        actions.moveByOffset(-locationOfElement.getX() + windowSize.getWidth() / 2 - sizeOfElement.getWidth(), -windowSize.getHeight() / 2 + sizeOfElement.getHeight());
        actions.perform();
        locationOfElement = elementToDrag.getLocation();
        actions.clickAndHold(elementToDrag);
        actions.moveByOffset(-locationOfElement.getX(), -locationOfElement.getY());
        actions.perform();
    }
}
