package week3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Alert {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://codepen.io/unknownUser7/pen/ZEdGLbq");
		WebElement fr=driver.findElement(By.id("result"));
		
		//Enter username,password and click login
		driver.switchTo().frame(fr);
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("pass");	
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		
		//To handle alert
		//driver.switchTo().alert();
		org.openqa.selenium.Alert alert = driver.switchTo().alert();
		String a=alert.getText();
		System.out.println(a);
		alert.accept();
		
		
		String verify="Login successful";
		if(a.contains(verify)) {
			System.out.println("Succesfully Logged in.");
		}
		else {
			System.out.println("You have not Logged in.");
		}
		
		//Handling the alert after logout
		//Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@onclick='logout()']")).click();
		org.openqa.selenium.Alert alert1 = driver.switchTo().alert();
		System.out.println(alert1.getText());
		alert1.accept();
		
		driver.close();
	}

}
