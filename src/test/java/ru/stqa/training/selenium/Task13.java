package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Task13 extends TestBase {

    @Test
    public void cart() {
        addToCart(3);
        clearCart();
    }

    private void clearCart() {
        driver.findElement(By.xpath("//a[contains(text(),'Checkout »')]")).click();

        By items = By.xpath("//td[@class='item']");
        int size = driver.findElements(items).size();
        for (int i = 0; i < size; i++) {
            size = driver.findElements(items).size();
            driver.findElement( By.xpath("//button[@value='Remove']")).click();
            wait.until(ExpectedConditions.numberOfElementsToBe(items, size - 1));
        }
    }

    private void addToCart(int number) {
        for (int i = 0; i < number; i++) {
            driver.get("http://localhost/litecart/en/");
            driver.findElement(By.xpath("//li[@class='product column shadow hover-light']")).click();

            By option = By.xpath("//select[@name='options[Size]']");
            if (driver.findElements(option).size() > 0) driver.findElement(option).sendKeys("small");

            By quantity = By.xpath("//span[@class='quantity']");
            int before = Integer.parseInt(driver.findElement(quantity).getText());
            driver.findElement(By.xpath("//button[@name='add_cart_product']")).click();
            wait.until(ExpectedConditions.textToBe(quantity, Integer.toString(before + 1)));
        }
    }
}
