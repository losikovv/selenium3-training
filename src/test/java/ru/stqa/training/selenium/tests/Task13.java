package ru.stqa.training.selenium.tests;

import org.junit.Test;

public class Task13 extends TestBase {

    @Test
    public void cart() {
        app.addItemsToCart(3);
        app.clearCart();
    }
}
