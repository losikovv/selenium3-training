package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class TrainingTests extends TestBase {

    @Test
    public void myFirstTest()
    {
        driver.get("http://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("webdriver");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        wait.until(titleIs("webdriver - Поиск в Google"));
        driver.findElement(By.partialLinkText("Что такое Selenium WebDriver?")).click();
    }

    @Test
    public void authAdmin()
    {
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }
}
