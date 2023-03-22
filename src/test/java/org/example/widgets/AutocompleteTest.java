package org.example.widgets;

import org.assertj.core.api.Assertions;
import org.example.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class AutocompleteTest extends BaseTest {

    @Test
    public void autocompleteTest() {
        Random random = new Random();
        driver.get("http://www.seleniumui.moderntester.pl/autocomplete.php");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("#search")).sendKeys("a");
        List<WebElement> optionsList = driver.findElements(By.cssSelector("#ui-id-1 .ui-menu-item"));
        for (WebElement webElement : optionsList) {
            System.out.println(webElement.getText());
        }
        WebElement randomElementToChoose = optionsList.get(optionsList.size() - 1);
        randomElementToChoose.click();
        Assertions.assertThat(randomElementToChoose.getText()).isEqualTo(driver.findElement(By.cssSelector("#search")).getText());
    }
}
