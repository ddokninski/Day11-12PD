package org.example.widgets;

import org.assertj.core.api.Assertions;
import org.example.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Stream;

public class ModalDialog extends BaseTest {

    public static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of("Jan", "jan@wp.pl", "secretpassword")
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    @DisplayName("Modal Dialog test")
    void modalDialogTest(String name, String email, String password) {
        driver.get("http://www.seleniumui.moderntester.pl/modal-dialog.php");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("#create-user")).click();
        WebElement nameInput = driver.findElement(By.cssSelector("#name"));
        nameInput.clear();
        nameInput.sendKeys(name);
        WebElement emailInput = driver.findElement(By.cssSelector("#email"));
        emailInput.clear();
        emailInput.sendKeys(email);
        WebElement passwordInput = driver.findElement(By.cssSelector("#password"));
        passwordInput.clear();
        passwordInput.sendKeys(password);
        driver.findElement(By.xpath("//button[.='Create an account']")).click();
        List<WebElement> elementsInTable = driver.findElements(By.cssSelector("tbody > tr"));
        WebElement lastElementInTable = elementsInTable.get(elementsInTable.size() - 1);
        String actualName = lastElementInTable.findElement(By.xpath("./td[1]")).getText();
        String actualEmail = lastElementInTable.findElement(By.xpath("./td[2]")).getText();
        String actualPassword = lastElementInTable.findElement(By.xpath("./td[3]")).getText();
        Assertions.assertThat(actualName).isEqualTo(name);
        Assertions.assertThat(actualEmail).isEqualTo(email);
        Assertions.assertThat(actualPassword).isEqualTo(password);
    }
}
