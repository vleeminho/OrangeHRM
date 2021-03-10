package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class TestNGAllureReport {
	WebDriver driver;
	
	@Test
	public void functionTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Workspace\\OrangeHRM\\drivers\\chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		Thread.sleep(3000);
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}

}
