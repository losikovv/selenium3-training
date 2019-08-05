package ru.stqa.training.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends Page {

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get("http://localhost/litecart/en/");
    }

    public void clickFirstItemCard() {
        driver.findElement(By.xpath("//li[@class='product column shadow hover-light']")).click();
    }

    public void clickCheckout() {
        driver.findElement(By.xpath("//a[contains(text(),'Checkout »')]")).click();
    }
}
