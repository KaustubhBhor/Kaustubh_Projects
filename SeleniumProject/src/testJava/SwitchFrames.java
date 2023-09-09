package testJava;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import dev.failsafe.internal.util.Assert;

public class SwitchFrames {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ASK Computers\\workspace\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://jqueryui.com/droppable/");
		
		WebElement LinkToNewTab = driver.findElement(By.linkText("Draggable"));
		
		Actions a = new Actions(driver);
		
		Thread.sleep(3000);
		
//		a.keyDown(LinkToNewTab, Keys.CONTROL).click().build().perform();
//		a.click(LinkToNewTab).keyDown(Keys.LEFT_CONTROL).build().perform();
		a.keyDown(Keys.LEFT_CONTROL).click(LinkToNewTab).build().perform();
		
		Thread.sleep(3000);
		
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String parent = it.next();
		String child = it.next();
		
		driver.switchTo().window(child);
		
		Thread.sleep(3000);
		
		driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
		WebElement src = driver.findElement(By.id("draggable"));
		String Text2 = src.getText();
		// do we need to switch to main frame again ?
		
		driver.switchTo().window(parent);
		driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
		
		Thread.sleep(3000);
		WebElement src1 = null;
		String Text1;
		
		try {
			Text1 = src.getText();
			
		} catch (Exception e) {
			src1 = driver.findElement(By.id("draggable"));
			Text1 = src1.getText();
		}
		
		System.out.println("drag box text on page 1 is : "+Text1);
		System.out.println("drag box text on page 2 is : "+Text2);
		
		Thread.sleep(3000);
		WebElement destination = driver.findElement(By.id("droppable"));
		a.dragAndDrop(src1, destination).build().perform();
		
		Thread.sleep(3000);
		driver.quit();

	}

}
