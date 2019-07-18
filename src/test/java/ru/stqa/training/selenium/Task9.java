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
        checkElementsOrder(By.xpath("//td[5]//a"));
    }

    @Test
    public void countriesZonesOrder() {
        authAdmin();
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        int countriesSize = driver.findElements(By.xpath("//td[5]//a")).size();

        for (int i = 0; i < countriesSize; i++) {
            int zonesNumber = Integer.parseInt(driver.findElements(By.xpath("//td[6]")).get(i).getText());
            if (zonesNumber > 0) {
                driver.findElements(By.xpath("//td[5]//a")).get(i).click();
                checkElementsOrder(By.xpath("//td[3]/input[@type='hidden']"), "value");
                driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
            }
        }
    }

    @Test
    public void geoZonesOrder() {
        authAdmin();
        driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        int zonesSize = driver.findElements(By.xpath("//td[3]/a")).size();

        for (int i = 0; i < zonesSize; i++) {
                driver.findElements(By.xpath("//td[5]//a")).get(i).click();
                checkElementsOrder(By.xpath("//td[3]/select/option[@selected]"));
                driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
            }

    }

    private void checkElementsOrder(By locator) {
        List<WebElement> elements = driver.findElements(locator);

        for (int i = 0; i < elements.size() - 1; i++) {
            Assert.assertTrue(elements.get(i)
                    .getText().compareToIgnoreCase(elements.get(i + 1).getText()) < 1);

            System.out.print(elements.get(i).getText() + " < ");
            System.out.println(elements.get(i + 1).getText());
        }
    }

    private void checkElementsOrder(By locator, String attribute) {
        List<WebElement> elements = driver.findElements(locator);

        for (int i = 0; i < elements.size() - 1; i++) {
            Assert.assertTrue(elements.get(i).getAttribute(attribute)
                    .compareToIgnoreCase(elements.get(i + 1).getAttribute(attribute)) < 1);

            System.out.print(elements.get(i).getAttribute(attribute) + " < ");
            System.out.println(elements.get(i + 1).getAttribute(attribute));
        }
    }
}
