package sample;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MapAssg {
	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.mapz.com/map");
		driver.findElement(By.xpath("//a[normalize-space()='Draw']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement em=driver.findElement(By.xpath("(//input[@id='email'])[1]"));
		Actions act =new Actions(driver);
		act.moveToElement(em).build().perform();
		String s = em.getAttribute("validationMessage");
		System.out.println(s);
		
	}

}
