package LeaftapsPages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Leaftaps {

    WebDriver driver;
    WebDriverWait wait;
    Actions act;
    JavascriptExecutor js;
    @BeforeMethod
    public void setup() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        act = new Actions(driver);
        js = (JavascriptExecutor) driver;

        driver.get("https://leafground.com/input.xhtml");
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void Testcase01() {
        WebElement name=driver.findElement(By.xpath("//h5[text()='Type your name']/following::input[1]"));
        name.sendKeys("Tesleaf");
        System.out.println("Entered Name: " + name.getAttribute("value"));
    }

    @Test(priority = 2)
    public void Testcase02() {
        WebElement country=driver.findElement(By.id("j_idt88:j_idt91"));
        country.sendKeys("India");
        System.out.println("Country Value: " + country.getAttribute("value"));
    }
    @Test(priority = 3)
    public void Tetcase03() {
        WebElement textbox=driver.findElement(By.id("j_idt88:j_idt93"));
        System.out.println("Textbox Enabled: " + textbox.isEnabled());
    }
    @Test(priority = 4)
    public void Tetcase04() {
        WebElement textbox=driver.findElement(By.id("j_idt88:j_idt95"));
        textbox.clear();
        System.out.println("Textbox Cleared: " + textbox.getAttribute("value").isEmpty());
    }
    @Test(priority = 5)
    public void Tetcase05() {
        WebElement textbox=driver.findElement(By.id("j_idt88:j_idt97"));
        System.out.println("Retrieved Text: " + textbox.getAttribute("value"));
    }
    @Test(priority = 6)
    public void Tetcase06() {
        WebElement email=driver.findElement(By.id("j_idt88:j_idt99"));
        email.sendKeys("test@example.com");
        email.sendKeys(Keys.TAB);
        System.out.println("Cursor moved to: " + driver.switchTo().activeElement().getAttribute("id"));
    }
    @Test(priority = 7)
    public void Tetcase07() {
        WebElement textbox=driver.findElement(By.id("j_idt88:j_idt101"));
        textbox.sendKeys("Practicing in LeafGround");
        System.out.println("Textbox has value: " + !textbox.getAttribute("value").isEmpty());
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
        WebElement error=wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[contains(text(),'Age is mandatory')]")));
        System.out.println("Validation Message: " + error.getText());
    }
    @Test(priority = 10)
    public void Tetcase10() {
        WebElement label=driver.findElement(By.xpath("//label[text()='Username']"));
        int beforeY=label.getLocation().getY();
        driver.findElement(By.id("j_idt106:thisform:name")).click();
        int afterY=label.getLocation().getY();
        System.out.println("Label Moved: " + (beforeY != afterY));
    }
    @Test(priority = 11)
    public void Tetcase11() {
        WebElement auto = driver.findElement(By.xpath("//span[contains(@class,'ui-autocomplete')]//input"));
        auto.sendKeys("a");
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//ul[contains(@class,'ui-autocomplete-items')]")));
        List<WebElement> options = driver.findElements(
                By.xpath("//ul[contains(@class,'ui-autocomplete-items')]//li"));
        if (options.size() >= 3) {
            options.get(2).click();
            System.out.println("Third option selected");
        }
    }
    @Test(priority = 12)
    public void Tetcase12() {
        WebElement dob = driver.findElement(By.xpath("//input[contains(@id,'date')]"));
        dob.clear();
        dob.sendKeys("21/02/2026");
        System.out.println("Date Entered: " + dob.getAttribute("value"));
    }
    @Test(priority = 13)
    public void Tetcase13() {
        WebElement spinner = driver.findElement(By.xpath("//input[contains(@class,'ui-spinner-input')]"));
        spinner.clear();
        spinner.sendKeys("10");
        int before = Integer.parseInt(spinner.getAttribute("value"));
        driver.findElement(By.xpath("//a[contains(@class,'ui-spinner-up')]")).click();
        int after = Integer.parseInt(spinner.getAttribute("value"));
        System.out.println("Spinner Incremented: " + (after == before + 1));
    }
    @Test(priority = 14)
    public void Tetcase14() {
        WebElement slider = driver.findElement(By.xpath("//div[contains(@class,'ui-slider')]//span"));
        String before = slider.getAttribute("style");
        act.clickAndHold(slider).moveByOffset(40, 0).release().perform();
        String after = slider.getAttribute("style");
        System.out.println("Slider Moved: " + !before.equals(after));
    }
    @Test(priority = 15)
    public void Tetcase15() {
        WebElement keyboard = driver.findElement(By.xpath("//input[contains(@class,'ui-keyboard-input')]"));
        keyboard.click();
        keyboard.sendKeys(Keys.ENTER);
        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class,'ui-keyboard')]")));
        System.out.println("Keyboard Displayed: " + popup.isDisplayed());
    }
    @Test(priority = 16)
    public void Tetcase16() {
        WebElement boldBtn = driver.findElement(By.xpath("//button[contains(@class,'ql-bold')]"));
        boldBtn.click();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.tagName("iframe")));
        WebElement body = driver.findElement(By.tagName("body"));
        body.sendKeys("Bold Text");
        String html = body.getAttribute("innerHTML");
        System.out.println("Bold Applied: " + (html.contains("<strong>") || html.contains("<b>")));
        driver.switchTo().defaultContent();
    }

    @AfterMethod
    public void close() {
        driver.quit();
    }
}