package ru.stqa.training.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends Page {

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void removeAllItems() {
        By items = By.xpath("//td[@class='item']");
        int size = driver.findElements(items).size();
        for (int i = 0; i < size; i++) {
            size = driver.findElements(items).size();
            driver.findElement( By.xpath("//button[@value='Remove']")).click();
            wait.until(ExpectedConditions.numberOfElementsToBe(items, size - 1));
        }
    }

}
