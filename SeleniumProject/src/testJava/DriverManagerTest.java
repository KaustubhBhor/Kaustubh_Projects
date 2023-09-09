package testJava;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManagerTest {

	public static void main(String[] args) throws InterruptedException {

			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--remote-allow-origins=*");
			
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver(chromeOptions);
			
			// Navigate to the Kaustubh's Repo
			driver.get("https://github.com/KaustubhBhor/Kaustubh_Projects");
			driver.manage().window().maximize();
			Thread.sleep(2000);
			driver.quit();
	}
}
