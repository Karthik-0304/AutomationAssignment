package LeaftapsPages;

import java.awt.Desktop.Action;
import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import net.bytebuddy.asm.Advice.Enter;

public class Leaftaps {
	WebDriver driver=new FirefoxDriver();
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	Actions act=new Actions(driver);
	@BeforeClass
	public void setup() {
		
		driver.get("https://leafground.com/input.xhtml");
		driver.manage().window().maximize();
		
	}
	@Test(priority = 1)
	public void Testcase01() {
		String a="Tesleaf";
		WebElement name=driver.findElement(By.xpath("//h5[text()='Type your name']//following::input[1]"));
		name.sendKeys(a);
		String tx=name.getAttribute("value");
		if(a.equalsIgnoreCase(tx)) {
			System.out.println("entered successfully");
		}
		else {
			System.out.println("Not entered");
		}
	}
	@Test(priority = 2)
	public void Testcase02() {
		WebElement coutname=driver.findElement(By.xpath("//input[@id='j_idt88:j_idt91']"));
		String b="India";
		coutname.sendKeys(b);
		String tx1=coutname.getAttribute("value");
		if(tx1.contains(b)) {
			System.out.println("Country name appended ");
		}
		else {
			System.out.println("Country name is not appended ");
		}
	}
	@Test(priority = 3)
	public void Tetcase03() {
		WebElement textbox=driver.findElement(By.id("j_idt88:j_idt93"));
		if(textbox.isEnabled()) {
			System.out.println("Textbox is enabled");
		}
		else {
			System.out.println("Textbox is disabled");
			
		}
	}
	@Test(priority = 4)
	public void Tetcase04() {
		WebElement textbox= driver.findElement(By.id("j_idt88:j_idt95"));
		textbox.clear();
		String nu=textbox.getAttribute("value");
		if(nu.isEmpty()) {
			System.out.println("Textbox is cleared");
		}
		else {
			System.out.println("Textbox is not cleared");
			
		}
	}
	@Test(priority = 5)
	public void Tetcase05() {
		WebElement textbox=driver.findElement(By.id("j_idt88:j_idt97"));
		String nu=textbox.getAttribute("value");
		System.out.println(nu);
	}
	@Test(priority = 6)
	public void Tetcase06() {
		WebElement email=driver.findElement(By.id("j_idt88:j_idt99"));
		email.sendKeys("test@example.com");
		email.sendKeys(Keys.TAB);
		WebElement activeElement=driver.switchTo().activeElement();
		String cursortobeinId=activeElement.getAttribute("id");
        String expectedNextId="j_idt88:j_idt100";
        if (cursortobeinId.equals(expectedNextId)) {
            System.out.println("Cursor moved to next element");
        } else {
            System.out.println("Cursor did not move correctly");
        }
	}
	@Test(priority = 7)
	public void Tetcase07() {
		WebElement textbox=driver.findElement(By.id("j_idt88:j_idt101"));
		textbox.sendKeys("Practicing in leafTaps");
		String nu=textbox.getAttribute("value");
		if(nu.isEmpty()) {
			System.out.println("TextBox is empty");
		}
		else {
			System.out.println("TextBox is not empty");
		}
	}
	@Test(priority = 8)
	public void Tetcase08() {
		WebElement ifont=driver.findElement(By.xpath("//button[@class='ql-italic']"));
		WebElement textbox=driver.findElement(By.xpath("//h5[@class='mt-0']//following::div[@data-gramm='false'][1]"));
		ifont.click();
		textbox.sendKeys("Practicing in leafTaps");
		String nu=textbox.getAttribute("value");
		System.out.println(nu);
	}
	@Test(priority = 9)
	public void Tetcase09() {
		WebElement textbox=driver.findElement(By.id("j_idt106:thisform:age"));
		textbox.sendKeys(Keys.ENTER);
		WebElement err = wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//span[contains(text(),'Age is mandatory')]")));
	    String actMsg=err.getText();
	    String exMsg="Age is mandatory";
	    if (actMsg.equals(exMsg)) {
	        System.out.println("PASS: Mandatory validation verified");
	    } else {
	        System.out.println("FAIL: Validation not verified");
	    }
	}
	@Test(priority = 10)
	public void Tetcase10() {
		WebElement label=driver.findElement(By.xpath("//label[text()='Username']"));
	    Point beforeClick=label.getLocation();
	    int beforeY=beforeClick.getY();
	    WebElement textbox=driver.findElement(By.id("j_idt106:thisform:name"));
	    textbox.click();
	    Point afterClick=label.getLocation();
	    int afterY=afterClick.getY();
	    if (beforeY != afterY) {
	        System.out.println("Label position changed");
	    } else {
	        System.out.println("Label position did not change");
	    }
	}
	
	
}
