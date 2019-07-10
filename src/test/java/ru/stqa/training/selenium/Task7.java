package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertTrue;

public class Task7 extends TestBase {

    @Test
    public void task7() {
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        int size = driver.findElements(By.cssSelector("li#app-")).size();
        for (int i = 0; i < size; i++) {
            driver.findElements(By.cssSelector("li#app-")).get(i).click();

            assertTrue(isElementPresent(By.cssSelector("h1")));
            System.out.println("\n⬤ " + driver.findElement(By.cssSelector("h1")).getText());

            int size1 = driver.findElements(By.cssSelector("ul.docs > li")).size();
            for (int c = 0; c < size1; c++) {
                driver.findElements(By.cssSelector("ul.docs > li")).get(c).click();

                assertTrue(isElementPresent(By.cssSelector("h1")));
                System.out.println("● " + driver.findElement(By.cssSelector("h1")).getText());
            }
        }
    }

    private boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }
}
