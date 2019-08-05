package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import ru.stqa.training.selenium.app.Application;

import java.util.UUID;

public class Task11 extends Application {

    @Test
    public void reg() {
        driver.get("http://localhost/litecart/en/create_account");

        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Test");
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Test");
        driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("Test");
        driver.findElement(By.xpath("//input[@name='postcode']")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Moscow");

        driver.findElement(By.xpath("//span[@class='select2-selection__rendered']")).click();
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("united states", Keys.ENTER);
        driver.findElement(By.xpath("//select[@name='zone_code']")).click();
        driver.findElement(By.xpath("//select[@name='zone_code']")).sendKeys("hawaii", Keys.ENTER);

        String email = UUID.randomUUID().toString() + "@example.com";
        System.out.println(email);
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("1234567890");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("test");
        driver.findElement(By.xpath("//input[@name='confirmed_password']")).sendKeys("test");

        driver.findElement(By.xpath("//button[@name='create_account']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();

        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("test");
        driver.findElement(By.xpath("//button[@name='login']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
    }
}
