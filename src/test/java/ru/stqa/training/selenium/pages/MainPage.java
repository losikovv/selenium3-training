package ru.stqa.training.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends Page {

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//li[@class='product column shadow hover-light']")
    public WebElement firstItemCard;

    @FindBy (xpath = "//a[contains(text(),'Checkout »')]")
    public WebElement checkout;

    public void open() {
        driver.get("http://localhost/litecart/en/");
    }
}
