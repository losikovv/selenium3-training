package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

public class Task8 extends TestBase {

    @Test
    public void task8() {
        driver.get("http://localhost/litecart/en/");

        checkStickersInBox("div#box-most-popular li");
        checkStickersInBox("div#box-campaigns li");
        checkStickersInBox("div#box-latest-products li");
    }

    private void checkStickersInBox(String selector) {
        int size = driver.findElements(By.cssSelector(selector)).size();

        for (int i = 1; i < size + 1; i++) {
            assertEquals(1, driver.findElements(By.cssSelector(selector + ":nth-child(" + i + ") div.sticker")).size());
            System.out.println(driver.findElement(By.cssSelector(selector + ":nth-child(" + i + ") div.sticker")).getText());
        }
    }
}
