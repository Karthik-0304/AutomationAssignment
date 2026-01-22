package test;

import java.time.Duration;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Saucedemo {
	public static void main(String[] args) {
		FirefoxOptions opt=new FirefoxOptions();
		WebDriver driver=new FirefoxDriver(opt);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.get("https://www.saucedemo.com/");
		
		By user=By.id("user-name");
		By pass=By.id("password");
		By lgn=By.id("login-button");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(user)).sendKeys("standard_user");
		driver.findElement(pass).sendKeys("secret_sauce");
		driver.findElement(lgn).click();
		
		By fprd=By.xpath("//div[@class='inventory_item_name ' and text()='Sauce Labs Backpack']");
		By fpri=By.xpath("//div[@class='inventory_item_price' and text()='29.99']");
		By adcar=By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
		By ca=By.xpath("//a[@class='shopping_cart_link']");
		
		WebElement frpr=wait.until(ExpectedConditions.visibilityOfElementLocated(fprd));
		WebElement frpi=driver.findElement(fpri);
		String pric=frpi.getText();
		System.out.println("First product name: "+frpr.getText());
		System.out.println("First product price: "+frpi.getText());
		
		driver.findElement(adcar).click();
		driver.findElement(ca).click();
		
		By invpri=By.xpath("//div[@class='inventory_item_price']");
		By check=By.xpath("//button[text()='Checkout']");
		
		WebElement inpri=wait.until(ExpectedConditions.visibilityOfElementLocated(invpri));
		String invenpric=inpri.getText();
		if(pric.equals(invenpric)) {
			System.out.println("Product price matches inventory price");
		}
		else {
			System.out.println("Product price not matches inventory price");
		}
		driver.findElement(check).click();
		
		By fn=By.id("first-name");
		By ln=By.id("last-name");
		By pco=By.id("postal-code");
		By con=By.id("continue");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(fn)).sendKeys("Karthik");
		driver.findElement(ln).sendKeys("s");
		driver.findElement(pco).sendKeys("600000");
		driver.findElement(con).click();
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement element = driver.findElement(By.id("finish"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);

		element.click();
		
		driver.findElement(By.id("back-to-products")).click();
		
		List<WebElement> prices=driver.findElements(By.className("inventory_item_price"));
		for (WebElement webElement : prices) {
			System.out.println(webElement.getText());
		}
		String[] arr=new String[prices.size()];
		for(int i=0;i>prices.size();i++) {
			for (WebElement webElement : prices) {
				String s=webElement.getText();
				arr[i]=s;
			}
			System.out.print(arr[i]);
		}
		
	}

}
