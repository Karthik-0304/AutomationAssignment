package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Facebooklogin {
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		FirefoxDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("XXXYYY");
		driver.findElement(By.id("pass")).sendKeys("YYYYXXXX");
		driver.findElement(By.name("login")).click();
		
	}
}
