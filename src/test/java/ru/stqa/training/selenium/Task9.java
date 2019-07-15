package ru.stqa.training.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Task9 extends TestBase {

    @Test
    public void countries() {
        authAdmin();
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");

        List<WebElement> countries = driver.findElements(By.xpath("//tr//td[5]//a"));

        for (int i = 0; i < countries.size() - 1; i++) {
            Assert.assertTrue(countries.get(i).getText().compareToIgnoreCase(countries.get(i + 1).getText()) < 1);
            System.out.println(countries.get(i).getText());
        }
    }

    private void authAdmin() {
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    @Test
    public void geoZones() {

    }
}
