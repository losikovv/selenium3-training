package ru.stqa.training.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Task9 extends TestBase {

    @Test
    public void countriesOrder() {
        authAdmin();
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        checkElementsOrder(By.xpath("//tr//td[5]//a"));
    }

    @Test
    public void countriesZonesOrder() {
        authAdmin();
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        int countriesSize = driver.findElements(By.xpath("//tr//td[5]//a")).size();

        for (int i = 0; i < countriesSize; i++) {
            int zonesNumber = Integer.parseInt(driver.findElements(By.xpath("//tr//td[6]")).get(i).getText());
            if (zonesNumber > 0) {
                driver.findElements(By.xpath("//tr//td[5]//a")).get(i).click();
                checkElementsOrder(By.xpath("//td[3]/input[@type='hidden']"));
                driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
            }
        }
    }

    @Test
    public void geoZonesOrder() {

    }

    private void authAdmin() {
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    private void checkElementsOrder(By locator) {
        List<WebElement> elements = driver.findElements(locator);

        for (int i = 0; i < elements.size() - 1; i++) {
            Assert.assertTrue(elements.get(i).getText().compareToIgnoreCase(elements.get(i + 1).getText()) < 1);
        }
    }
}
