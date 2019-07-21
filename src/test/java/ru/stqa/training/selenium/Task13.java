package ru.stqa.training.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Task13 extends TestBase {

    @Test
    public void cart() {

        for (int i = 0; i < 3; i++) {
            driver.get("http://localhost/litecart/en/");
            driver.findElement(By.xpath("//li[@class='product column shadow hover-light']")).click();

            By option = By.xpath("//select[@name='options[Size]']");
            if (driver.findElements(option).size() > 0) driver.findElement(option).sendKeys("small");

            By qtyLocator = By.xpath("//span[@class='quantity']");
            int quantityOfItems = Integer.parseInt(driver.findElement(qtyLocator).getText());
            driver.findElement(By.xpath("//button[@name='add_cart_product']")).click();
            wait.until(ExpectedConditions.textToBe(qtyLocator, Integer.toString(quantityOfItems + 1)));
        }

        driver.findElement(By.xpath("//a[contains(text(),'Checkout »')]")).click();

        By remove = By.xpath("//button[@value='Remove']");
        int size = driver.findElements(remove).size();
        for (int i = 0; i < size; i++) {
        driver.findElement(remove).click();
        wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath("//div[@id='order_confirmation-wrapper']"))));
        }
        Assert.assertTrue(driver.findElements(
                By.xpath("//em[contains(text(),'There are no items in your cart.')]")).size() > 0);
    }
}
