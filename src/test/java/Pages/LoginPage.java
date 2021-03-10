package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.ReadPropertyFile;

public class LoginPage extends TestBase{
	
	
	public void login() {
		WebDriverWait wait=new WebDriverWait(driver, 50);
		try {
			driver.get(ReadPropertyFile.getURL());
			Thread.sleep(9000);
			driver.findElement(By.id("txtUsername")).sendKeys(ReadPropertyFile.getUsername());
			driver.findElement(By.id("txtPassword")).sendKeys(ReadPropertyFile.getPassword());
			driver.findElement(By.id("btnLogin")).click();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
