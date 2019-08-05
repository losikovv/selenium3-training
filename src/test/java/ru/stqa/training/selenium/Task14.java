package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.stqa.training.selenium.app.Application;

import java.util.List;
import java.util.Set;

public class Task14 extends Application {

    WebDriverWait wait = new WebDriverWait(driver, 10);

    @Test
    public void externalLinks() {
        adminLoginPage.auth();
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        driver.findElement(By.xpath("//a[@class='button']")).click();

        List<WebElement> links = driver.findElements(By.xpath("//i[@class='fa fa-external-link']"));
        for (WebElement link : links) {
            String originalWindow = driver.getWindowHandle();
            Set<String> existingWindows = driver.getWindowHandles();
            link.click();
            String newWindow = wait.until(getAnyWindowOtherThan(existingWindows));
            driver.switchTo().window(newWindow);
            //System.out.println(driver.getTitle());
            driver.close();
            driver.switchTo().window(originalWindow);
        }
    }

    private ExpectedCondition<String> getAnyWindowOtherThan(Set<String> existingWindows) {
        return new ExpectedCondition<String>() {
            public String apply(WebDriver driver) {
                Set<String> handles = driver.getWindowHandles();
                handles.removeAll(existingWindows);
                return handles.size() > 0 ? handles.iterator().next() : null;
            }
        };
    }
}
