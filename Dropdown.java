package week3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.telerik.com/contact");

		//Select by value
		WebElement dropdown1 = driver.findElement(By.id("Dropdown-1"));
		Select obj1 = new Select(dropdown1);
		obj1.selectByValue("Invoicing/Billing");

		//Select by visible text
		WebElement dropdown2 = driver.findElement(By.id("Dropdown-2"));
		Select obj2 = new Select(dropdown2);
		obj2.selectByVisibleText("Testing Framework");

		//Enter First and Last Name
		driver.findElement(By.id("Textbox-1")).sendKeys("Karthik");
		driver.findElement(By.id("Textbox-2")).sendKeys("Sivakumar");

		Thread.sleep(1000);
		//Scroll to Country dropdown
		WebElement countryDropdown = driver.findElement(By.id("Country-1"));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", countryDropdown);


		Thread.sleep(1000);
		//Select by index
		Select obj3 = new Select(countryDropdown);
		obj3.selectByIndex(1);
		
		driver.close();
	}
}

