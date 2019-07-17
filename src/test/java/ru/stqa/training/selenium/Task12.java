package ru.stqa.training.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class Task12 extends TestBase {

    @Test
    public void item() {
        authAdmin();
        driver.findElement(By.xpath("//span[text()='Catalog']")).click();
        int before = driver.findElements(By.xpath("//tr[@class='row']")).size();
        System.out.println(before);
        driver.findElement(By.xpath("//a[contains(text(),'Add New Product')]")).click();

        System.out.println(System.getProperty("user.dir"));

        driver.findElement(By.xpath("//input[@value='1'][@type='radio']")).click();
        driver.findElement(By.xpath("//input[@name='name[en]']")).sendKeys("Rubber Crocodile");
        driver.findElement(By.xpath("//input[@name='code']")).sendKeys("123");
        driver.findElement(By.xpath("//input[@name='categories[]'][@value='1']")).click();
        driver.findElement(By.xpath("//input[@name='categories[]'][@value='2']")).click();
        driver.findElement(By.xpath("//input[@value='1-3']")).click();
        driver.findElement(By.xpath("//input[@name='quantity']")).sendKeys("10");
        driver.findElement(By.xpath("//input[@name='new_images[]']"))
                .sendKeys(System.getProperty("user.dir") + "/src/img/rubber_croc.jpg");
        driver.findElement(By.xpath("//input[@name='date_valid_from']")).sendKeys("17072019");
        driver.findElement(By.xpath("//input[@name='date_valid_to']")).sendKeys("17072020");

        driver.findElement(By.xpath("//a[@href='#tab-information']")).click();
        driver.findElement(By.xpath("//select[@name='manufacturer_id']")).click();
        driver.findElement(By.xpath("//select[@name='manufacturer_id']")).sendKeys("a");
        driver.findElement(By.xpath("//select[@name='manufacturer_id']")).click();
        driver.findElement(By.xpath("//input[@name='keywords']")).sendKeys("rubber crocodile test");
        driver.findElement(By.xpath("//input[@name='short_description[en]']")).sendKeys("test");
        driver.findElement(By.xpath("//div[@class='trumbowyg-editor']")).sendKeys("test");
        driver.findElement(By.xpath("//input[@name='head_title[en]']")).sendKeys("Rubber Crocodile");

        driver.findElement(By.xpath("//a[@href='#tab-prices']")).click();
        driver.findElement(By.xpath("//input[@name='purchase_price']")).sendKeys("10");
        driver.findElement(By.xpath("//select[@name='purchase_price_currency_code']")).click();
        driver.findElement(By.xpath("//select[@name='purchase_price_currency_code']")).sendKeys("eur");
        driver.findElement(By.xpath("//select[@name='purchase_price_currency_code']")).click();
        driver.findElement(By.xpath("//input[@name='prices[USD]']")).sendKeys("10");
        driver.findElement(By.xpath("//input[@name='prices[EUR]']")).sendKeys("9");

        driver.findElement(By.xpath("//button[@name='save']")).click();
        driver.findElement(By.xpath("//span[text()='Catalog']")).click();
        int after = driver.findElements(By.xpath("//tr[@class='row']")).size();
        System.out.println(after);
        Assert.assertEquals(before + 1, after);
    }

    private void authAdmin() {
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }
}
