package week3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Day1 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.leafground.com/");
		driver.findElement(By.xpath("//i[@class='pi pi-globe layout-menuitem-icon']")).click();
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement alert=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='pi pi-fw pi-clone layout-menuitem-icon']//following::span")));
		alert.click();
		
		WebElement conf=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='Sweet Alert (Confirmation)']//following::span[@class='ui-button-text ui-c']")));
		conf.click();
		System.out.println("Sweet Alert (Confirmation)");
		WebElement text=driver.findElement(By.xpath("//span[@class='ui-confirm-dialog-message']"));
		System.out.println(text.getText());
		WebElement yes=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='ui-button-text ui-c' and text()='Yes']")));
		System.out.println(yes.getText());
		yes.click();
		System.out.println("");
		
		Thread.sleep(1000);
		
		WebElement simp = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h5[text()='Sweet Alert (Simple Dialog)']//following::button")));
		simp.click();
		System.out.println("Sweet Alert (Simple Dialog)");
		WebElement dia=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='j_idt88:j_idt96_content']//p")));
		System.out.println(dia.getText());
		Thread.sleep(2000);
		WebElement dis=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='ui-button-text ui-c' and text()='Dismiss']")));
		System.out.println(dis.getText());
		dis.click();
		System.out.println("");
		
		Thread.sleep(1000);
		
		WebElement moddia = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h5[text()='Sweet Modal Dialog']//following::button")));
		moddia.click();
		System.out.println("Sweet Modal Dialog");
		WebElement text2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='m-0']")));
		System.out.println(text2.getText());
		WebElement cl=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@aria-label='Close']//following::span[@class='ui-icon ui-icon-closethick'][1]")));
		cl.click();
		System.out.println("");
		
		Thread.sleep(1000);
		
		WebElement maxmin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h5[text()='Minimize and Maximize']//following::button")));
		maxmin.click();
		System.out.println("Minimize and Maximize");
		WebElement max=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='m-0']")));
		System.out.println(max.getText());
		WebElement clo=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='ui-icon ui-icon-closethick'])[3]")));
		clo.click();
		//By x =By.xpath("(//span[@class='ui-icon ui-icon-closethick'])[3]");
        //wait.until(ExpectedConditions.elementToBeClickable(x)).click();
        //wait.until(ExpectedConditions.elementToBeClickable(x)).click();
		//System.out.println("");
		
		driver.close();
		
	}
}
