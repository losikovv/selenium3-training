package ru.stqa.training.selenium.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.stqa.training.selenium.pages.AdminLoginPage;
import ru.stqa.training.selenium.pages.CartPage;
import ru.stqa.training.selenium.pages.ItemPage;
import ru.stqa.training.selenium.pages.MainPage;

public class Application {

    public WebDriver driver;

    protected MainPage mainPage;
    protected AdminLoginPage adminLoginPage;
    protected CartPage cartPage;
    protected ItemPage itemPage;

    public Application() {
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        adminLoginPage = new AdminLoginPage(driver);
        cartPage = new CartPage(driver);
        itemPage = new ItemPage(driver);
    }

    public void quit() {
        driver.quit();
    }

    public void addItemsToCart(int number) {
        for (int i = 0; i < number; i++) {
            mainPage.open();
            mainPage.firstItemCard.click();

            itemPage.selectItemSize("small");
            itemPage.addItemToCart();
        }
    }

    public void clearCart() {
        mainPage.checkout.click();

        cartPage.removeAllItems();
    }
}