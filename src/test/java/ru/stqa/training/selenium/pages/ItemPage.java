package ru.stqa.training.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ItemPage extends Page {

    public ItemPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void addItemToCart() {
        By quantity = By.xpath("//span[@class='quantity']");
        int before = Integer.parseInt(driver.findElement(quantity).getText());
        driver.findElement(By.xpath("//button[@name='add_cart_product']")).click();
        wait.until(ExpectedConditions.textToBe(quantity, Integer.toString(before + 1)));
    }

    public void selectItemSize(String size) {
        By option = By.xpath("//select[@name='options[Size]']");
        if (driver.findElements(option).size() > 0) driver.findElement(option).sendKeys(size);
    }
}
