package ru.stqa.training.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ItemPage extends Page {

    public ItemPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//select[@name='options[Size]']")
    public List<WebElement> selectItemSize;

    @FindBy (xpath = "//span[@class='quantity']")
    public WebElement itemsQuantity;

    @FindBy (xpath = "//button[@name='add_cart_product']")
    public WebElement addItemToCart;

    public void addItemToCart() {
        int before = Integer.parseInt(itemsQuantity.getText());
        addItemToCart.click();
        wait.until(ExpectedConditions.attributeToBe(itemsQuantity,"innerText", Integer.toString(before + 1)));
    }

    public void selectItemSize(String size) {
        if (selectItemSize.size() > 0) selectItemSize.get(0).sendKeys(size);
    }
}
