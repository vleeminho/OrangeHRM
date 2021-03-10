package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class HomePage extends TestBase{
	
	//@FindBy(how=How.ID,using="welcome")  WebElement txtWelcome;
	
	WebDriverWait wait=new WebDriverWait(driver, 30);
	public void verifyValidLogin() {
		try {
			WebElement txtWelcome=driver.findElement(By.id("welcome"));
			wait.until(ExpectedConditions.visibilityOf(txtWelcome));
			String name=txtWelcome.getText();
			System.out.println("Logged in User name is ::"+name);
			
			Assert.assertTrue(name.contains("Welcome"), "Logged in user welcome message did not displayed");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
