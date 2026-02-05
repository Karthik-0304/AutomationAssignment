package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Testcase1 {

	@Test(priority = 1)
	public void postive() {
		WebDriver driver=new FirefoxDriver();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://practicetestautomation.com/practice-test-login/");
		
		WebElement user=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		user.sendKeys("student");
		driver.findElement(By.id("password")).sendKeys("Password123");
		driver.findElement(By.id("submit")).click();
		
		String txt="successfully logged in";
		WebElement text=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[contains(text(),'successfully logged in')]")));
		String txt1=text.getText();
		
		String curl=driver.getCurrentUrl();

		WebElement lout=driver.findElement(By.xpath("//a[text()='Log out']"));
		if(curl.contains("https://practicetestautomation.com/logged-in-successfully/") && txt1.contains(txt)) {
			System.out.println("Successfully verified");
		}
		else {
			System.out.println("Not verified");
		}
		
		if (lout.isDisplayed()) {
			System.out.println(lout.isDisplayed());
		}
		else {
			System.out.println(lout.isDisplayed());
		}
	}
	
	@Test(dependsOnMethods = "postive",priority = 2)
	public void negative() {
		WebDriver driver=new FirefoxDriver();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://practicetestautomation.com/practice-test-login/");
		
		WebElement user=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		user.sendKeys("incorrectUser");
		driver.findElement(By.id("password")).sendKeys("Password123");
		driver.findElement(By.id("submit")).click();
		
		WebElement err=driver.findElement(By.id("error"));
		String txt=err.getText();
		String etxt="Your username is invalid!";
		
		if(etxt.contains(txt)) {
			System.out.println("error is verified");
		}
		else {
			System.out.println("not verified");
		}
		
		
		
	}
	
	@Test(dependsOnMethods = "negative",priority = 3)
	public void negativepass() {
		WebDriver driver=new FirefoxDriver();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://practicetestautomation.com/practice-test-login/");
		
		WebElement user=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		user.sendKeys("student");
		driver.findElement(By.id("password")).sendKeys("incorrectPassword");
		driver.findElement(By.id("submit")).click();
		
		WebElement err=driver.findElement(By.id("error"));
		String txt=err.getText();
		String wtxt="Your password is invalid!";
		
		if(wtxt.contains(txt)) {
			System.out.println("error is verified");
		}
		else {
			System.out.println("not verified");
		}
	

	}
}
