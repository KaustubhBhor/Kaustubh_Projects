package testJava;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class InvokeBrowser {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\ASK Computers\\workspace\\chromedriver_win32\\chromedriver.exe");
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		
		driver = new ChromeDriver(chromeOptions);
//		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		
		WebElement cost1 = driver.findElement(By.xpath("//*[contains(text(),'Beetroot')]//following::p[1]"));
		String costOfBeetroot = cost1.getText();
		System.out.println(costOfBeetroot);
		
//		WebElement cost2 = driver.findElement(By.xpath("//*[contains(text(),'Beetroot')]//following::input[1]"));
//		cost2.sendKeys("3");
		
//		InvokeBrowser.mouseHover();
//		InvokeBrowser.WindowHandlers();
		driver.quit();		
	}
	
	private static void staleElementHandling() throws InterruptedException {
		
		driver.get("https://www.udemy.com/");
		WebElement dev = driver.findElement(By.xpath("(//*[@id='icon'])[2]"));
		dev.click();
		
		Thread.sleep(3000);
		
		driver.navigate().back();
		
		Thread.sleep(3000);
		try {
			dev.click();
		} catch (Exception e) {
			dev = driver.findElement(By.xpath("(//*[@id='icon'])[2]"));
			dev.click();
		}
	}

	private static void switchTab() {
		
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		
		while (it.hasNext()) {
			
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
			
		}
		
	}
	
	private static void mouseHover() throws InterruptedException {
		
		driver.get("https://www.amazon.in/");
		WebElement Acnts = driver.findElement(By.xpath("//*[@id='nav-link-accountList']/span"));
		
		Actions a = new Actions(driver);
		a.moveToElement(Acnts).build().perform();
		
		Thread.sleep(5000);
	}
	
	private static void WindowHandlers() {
		
		WebElement body = driver.findElement(By.tagName("body"));
		body.sendKeys(Keys.CONTROL + "t");
		((JavascriptExecutor) driver).executeScript("window.open('https://chromedriver.chromium.org/home')");
		
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		
		while(it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
	}
}
