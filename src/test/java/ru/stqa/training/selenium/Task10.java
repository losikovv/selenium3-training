package ru.stqa.training.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Arrays;

public class Task10 extends TestBase {

    @Test
    public void itemCard() {
        driver.get("http://localhost/litecart/en/");
        String name = driver.findElement(By.xpath("//div[@id='box-campaigns']//div[@class='name']")).getText();
        WebElement regularPriceMain = driver.findElement(By.xpath("//div[@id='box-campaigns']//s[@class='regular-price']"));
        WebElement campaignPriceMain = driver.findElement(By.xpath("//div[@id='box-campaigns']//strong[@class='campaign-price']"));

        isGrey(regularPriceMain);
        isCrossed(regularPriceMain);

        isRed(campaignPriceMain);
        Assert.assertTrue(bold(campaignPriceMain));

        driver.findElement(By.xpath("//div[@id='box-campaigns']//li")).click();

        WebElement regularPriceCard = driver.findElement(By.xpath("//s[@class='regular-price']"));
        WebElement campaignPriceCard = driver.findElement(By.xpath("//strong[@class='campaign-price']"));

        Assert.assertEquals(name, driver.findElement(By.xpath("//h1")).getText());
        Assert.assertEquals(regularPriceMain.getText(), regularPriceCard.getText());
        Assert.assertEquals(campaignPriceMain.getText(), campaignPriceCard.getText());

        isGrey(regularPriceCard);
        isCrossed(regularPriceCard);

        isRed(campaignPriceCard);
        Assert.assertTrue(bold(campaignPriceCard));
    }

    private void isGrey(WebElement element) {
        String[] rgb = element
                .getCssValue("color")
                .replaceAll("[rgba()]", "")
                .split("\\s*,\\s*");

        System.out.println("\ncolor: " + Arrays.toString(rgb));

        Assert.assertEquals(rgb[0], rgb[1]);
        Assert.assertEquals(rgb[1], rgb[2]);
    }

    private void isRed(WebElement element) {
        String[] rgb = element
                .getCssValue("color")
                .replaceAll("[rgba()]", "")
                .split("\\s*,\\s*");

        System.out.println("\ncolor: " + Arrays.toString(rgb));

        Assert.assertTrue(Integer.parseInt(rgb[0]) > Integer.parseInt(rgb[1]));
        Assert.assertEquals(rgb[1], rgb[2]);
    }

    private void isCrossed(WebElement element) {
        String decor = element.getCssValue("text-decoration");

        System.out.println("text-decoration: " + decor);

        Assert.assertEquals("line-through", decor.substring(0, 12));
    }

    private boolean bold(WebElement element) {
        String weight = element.getCssValue("font-weight");

        System.out.println("font-weight: " + weight);

        if (weight.equalsIgnoreCase("bold")) {
            return true;
        } else return Integer.parseInt(weight) > 699;
    }
}
