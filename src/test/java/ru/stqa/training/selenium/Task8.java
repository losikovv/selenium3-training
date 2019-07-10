package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertTrue;

public class Task8 extends TestBase {

    @Test
    public void task8() {
        driver.get("http://localhost/litecart/en/");

        checkStickersInBox("div#box-most-popular li");
        checkStickersInBox("div#box-campaigns li");
        checkStickersInBox("div#box-latest-products li");
    }

    private boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    private void checkStickersInBox(String selector) {
        int size = driver.findElements(By.cssSelector(selector)).size();

        for (int i = 1; i < size + 1; i++) {
            assertTrue(isElementPresent(By.cssSelector(selector + ":nth-child(" + i + ") div.sticker:nth-of-type(1)")));
            assertTrue(!isElementPresent(By.cssSelector(selector + ":nth-child(" + i + ") div.sticker:nth-of-type(2)")));
            System.out.println(
                    driver.findElement(By.cssSelector(selector + ":nth-child(" + i + ") div.sticker:nth-of-type(1)")).getText());
        }
    }
}
