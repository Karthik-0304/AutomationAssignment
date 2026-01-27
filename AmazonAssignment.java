package week3;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AmazonAssignment {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobile");
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		List<WebElement> prices= driver.findElements(By.className("a-price-whole"));
		int[] pri=new int[prices.size()];//a[@class='a-link-normal s-line-clamp-2 puis-line-clamp-3-for-col-4-and-8 s-link-style a-text-normal']
		for (int i=0;i<pri.length;i++) {
			String priceinttext=prices.get(i).getText();
			String replaces = priceinttext.replaceAll(",","");
			int parse=Integer.parseInt(replaces);
			pri[i]=parse;
			
		}
		Arrays.sort(pri);
		for (int i : pri) 
		{
			System.out.print(i+" ");
		}
		Thread.sleep(3000L);
		driver.findElement(By.xpath("//a[@class='a-link-normal s-line-clamp-2 puis-line-clamp-3-for-col-4-and-8 s-link-style a-text-normal']")).click();
		
		Set<String> tabs = driver.getWindowHandles();
		for (String tab : tabs) {
			driver.switchTo().window(tab);
		}

		Thread.sleep(2000);

		// Wait for Add to Cart button
		WebElement addToCart = driver.findElement(By.id("add-to-cart-button"));

		// Scroll into view
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", addToCart);

		// Click using JavaScript (BEST for Amazon)
		js.executeScript("arguments[0].click();", addToCart);

		System.out.println("Added to cart successfully!");

	}

}
