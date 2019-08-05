package ru.stqa.training.selenium.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CartPage extends Page {

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//td[@class='item']")
    public List<WebElement> items;

    @FindBy (xpath = "//button[@value='Remove']")
    public WebElement removeItem;

    public void removeAllItems() {
        int size = items.size();
        for (int i = 0; i < size; i++) {
            size = items.size();
            removeItem.click();
            wait.until(ExpectedConditions.stalenessOf(items.get(0)));
            Assert.assertEquals(size - 1, items.size());
        }
    }

}
