package sample;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;

public class Amazon {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in");
        WebElement searchBox = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox"))
        );
        searchBox.sendKeys("bag");
        driver.findElement(By.id("nav-search-submit-button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.cssSelector("div.s-search-results")
        ));
        int count = 0;
        while (count < 5) {

            List<WebElement> brands = driver.findElements(
                By.xpath("//input[@type='checkbox' and contains(@name,'Brand')]")
            );

            if (brands.size() > count) {

                WebElement brand = brands.get(count);
                js.executeScript("arguments[0].click();", brand);
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector("div.s-search-results")
                ));

                count++;
            } else {
                break;
            }
        }

        System.out.println("First 5 brands selected successfully");
        Thread.sleep(3000);
        driver.quit();
    }
}