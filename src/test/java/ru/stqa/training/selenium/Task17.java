package ru.stqa.training.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.logging.LogEntry;
import ru.stqa.training.selenium.app.Application;

public class Task17 extends Application {

    @Test
    public void noBrowserLogs() {
        adminLoginPage.auth();
        String catalog = "http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1";
        driver.get(catalog);

        int size = driver.findElements(By.xpath("//tr[.//input[contains(@name, 'products')]]/td[3]/a")).size();

        for (int i = 1; i <= size; i++) {
            driver.findElement(By.xpath("//tr[.//input[contains(@name, 'products')]][" + i + "]/td[3]/a")).click();

            for (LogEntry l : driver.manage().logs().get("browser").getAll()) {
                System.out.println(l);
                Assert.assertNull(l);
            }

            driver.get(catalog);
        }
    }
}
