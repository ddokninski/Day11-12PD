package org.example.basic;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.example.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;
import java.util.Random;

@Slf4j
public class FormTest extends BaseTest {

    @Test
    @DisplayName("Form test 1")
    void fillForm() {
        //GIVEN
        driver.get("http://www.seleniumui.moderntester.pl/form.php");
        testExecute(driver);
    }

    public void testExecute(WebDriver driver) {
        Random random = new Random();
        String expectedMsg = "Form send with success";
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("#inputFirstName3")).sendKeys("Jan");
        driver.findElement(By.cssSelector("#inputLastName3")).sendKeys("Kowalski");
        driver.findElement(By.cssSelector("#inputEmail3")).sendKeys("jan.kowalski@wp.pl");
        List<WebElement> sexValueCheckBoxList = driver.findElements(By.cssSelector("input[name='gridRadiosSex']"));
        sexValueCheckBoxList.get(random.nextInt(sexValueCheckBoxList.size() - 1)).click();
        driver.findElement(By.cssSelector("#inputAge3")).sendKeys("30");
        List<WebElement> experienceCheckBoxList = driver.findElements(By.cssSelector("input[name='gridRadiosExperience']"));
        experienceCheckBoxList.get(random.nextInt(experienceCheckBoxList.size() - 1)).click();
        driver.findElement(By.cssSelector("label[for='gridCheckAutomationTester']")).click();
        List<WebElement> continentsList = driver.findElements(By.cssSelector("#selectContinents > option"));
        continentsList.get(random.nextInt(continentsList.size() - 2) + 1).click();
        Select commands = new Select(driver.findElement(By.cssSelector("#selectSeleniumCommands")));
        commands.selectByValue("switch-commands");
        commands.selectByValue("wait-commands");
        File file = new File("pom.xml");
        driver.findElement(By.cssSelector("#chooseFile")).sendKeys(file.getAbsolutePath());
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        //WHEN
        String actualMsg = driver.findElement(By.cssSelector("div[class='col-sm-12 success']")).getText();
        log.info("msg = " + actualMsg);

        //THEN
        Assertions.assertThat(actualMsg).isEqualTo(expectedMsg);
    }
}
