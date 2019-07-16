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
        String regularPriceMainText = regularPriceMain.getText();
        WebElement campaignPriceMain = driver.findElement(By.xpath("//div[@id='box-campaigns']//strong[@class='campaign-price']"));
        String campaignPriceMainText = campaignPriceMain.getText();

        isPriceSizeOk(regularPriceMain, campaignPriceMain);
        isGrey(regularPriceMain);
        isCrossed(regularPriceMain);
        isRed(campaignPriceMain);
        Assert.assertTrue(bold(campaignPriceMain));

        driver.findElement(By.xpath("//div[@id='box-campaigns']//li")).click();

        WebElement regularPriceCard = driver.findElement(By.xpath("//s[@class='regular-price']"));
        String regularPriceCardText = regularPriceCard.getText();
        WebElement campaignPriceCard = driver.findElement(By.xpath("//strong[@class='campaign-price']"));
        String campaignPriceCardText = campaignPriceCard.getText();

        Assert.assertEquals(name, driver.findElement(By.xpath("//h1")).getText());
        Assert.assertEquals(regularPriceMainText, regularPriceCardText);
        Assert.assertEquals(campaignPriceMainText, campaignPriceCardText);

        isPriceSizeOk(regularPriceCard, campaignPriceCard);
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

        Assert.assertNotEquals("0", rgb[0]);
        Assert.assertEquals("0", rgb[1]);
        Assert.assertEquals("0", rgb[2]);
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

    private void isPriceSizeOk(WebElement regular, WebElement campaign) {
        float regularSize = Float.parseFloat(regular.getCssValue("font-size")
                .replaceAll("[pxt]", ""));
        float campaignSize = Float.parseFloat(campaign.getCssValue("font-size")
                .replaceAll("[pxt]", ""));

        System.out.println("\nregular font-size: " + regularSize);
        System.out.println("campaign font-size: " + campaignSize);

        Assert.assertTrue(regularSize < campaignSize);
    }
}
