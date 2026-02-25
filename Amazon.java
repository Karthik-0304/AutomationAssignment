package sample;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		JavascriptExecutor jsExecutor=(JavascriptExecutor) driver;
		
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("bag");
        driver.findElement(By.id("nav-search-submit-button")).click();
		
		List<WebElement> brandsElements=driver.findElements(By.xpath("//span[text()='Brands']//following::span[@class='a-list-item']"));
		
		for (int i = 0; i < brandsElements.size(); i++) {
			if(i==5) {
				break;
			}
				WebElement brandElement=brandsElements.get(i);
				if(!brandElement.isSelected()) {
					jsExecutor.executeScript("arguments[0].click();", brandElement);
			}
		}
	}
}
