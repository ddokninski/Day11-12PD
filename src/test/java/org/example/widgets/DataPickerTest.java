package org.example.widgets;

import org.assertj.core.api.Assertions;
import org.example.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

public class DataPickerTest extends BaseTest {

    @Test
    public void dataPickerTest() throws InterruptedException {
        LocalDate date = LocalDate.now();
        LocalDate firstDayOfNextMonth = LocalDate.of(date.getYear(), date.getMonthValue() + 1, 1);
        Random random = new Random();


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        driver.get("http://www.seleniumui.moderntester.pl/datepicker.php");
        driver.manage().window().maximize();

        setTodayDate();
        Assertions.assertThat(driver.findElement(By.id("datepicker")).getAttribute("value")).isEqualTo(formatter.format(date));

        setFirstDayOfNextMonth();
        Assertions.assertThat(driver.findElement(By.id("datepicker")).getAttribute("value")).isEqualTo(formatter.format(firstDayOfNextMonth));

        setCurrentDate(LocalDate.of(LocalDate.now().getYear() + 1, Month.JANUARY, 31));
        Assertions.assertThat(driver.findElement(By.id("datepicker")).getAttribute("value")).isEqualTo(formatter.format(LocalDate.of(LocalDate.now().getYear() + 1, Month.JANUARY, 31)));

        setCurrentDate(LocalDate.of(LocalDate.now().getYear() + 1, Month.JANUARY, 31));
        Assertions.assertThat(driver.findElement(By.id("datepicker")).getAttribute("value")).isEqualTo(formatter.format(LocalDate.of(LocalDate.now().getYear() + 1, Month.JANUARY, 31)));

        clickToPreviousMonth();
        clickOnRandomDay();

        setCurrentDate(LocalDate.of(LocalDate.now().getYear() - 1, random.nextInt(12) + 1, random.nextInt(31) + 1));
    }


    private void setTodayDate() {
        driver.findElement(By.id("datepicker")).click();
        driver.findElement(By.cssSelector("td[class=' ui-datepicker-days-cell-over  ui-datepicker-today']")).click();
    }

    private void setFirstDayOfNextMonth() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.id("datepicker")).click();
        clickToNextMonth();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[.='1'][1]")));
        driver.findElement(By.xpath("//a[.='1'][1]")).click();
    }

    private void setCurrentDate(LocalDate date) {
        Actions actions = new Actions(driver);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String dateToSet = formatter.format(date);

        driver.findElement(By.cssSelector("#datepicker")).clear();
        driver.findElement(By.cssSelector("#datepicker")).sendKeys(dateToSet);
        actions.sendKeys(Keys.RETURN);

    }

    private void clickOnRandomDay() {
        Random random = new Random();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-handler='next']")));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate actualdate = LocalDate.parse(driver.findElement(By.id("datepicker")).getAttribute("value"), formatter);
        int monthValue = actualdate.getMonthValue() - 1;
        if (monthValue <= 0) {
            monthValue = monthValue + 11;
        }
        List<WebElement> daysList = driver.findElements(By.xpath("//td[@data-month='" + monthValue + "']//a"));
        int randomDay = random.nextInt(daysList.size()) + 1;

        for (WebElement webElement : daysList) {
            if (Integer.parseInt(webElement.getText()) == randomDay)
                webElement.click();
        }
    }

    private void clickToNextMonth() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-handler='next']")));
        driver.findElement(By.cssSelector("a[data-handler='next']")).click();
    }

    private void clickToPreviousMonth() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-handler='prev']")));
        driver.findElement(By.cssSelector("a[data-handler='prev']")).click();
    }
}
