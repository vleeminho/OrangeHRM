package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import Utility.utilities;

public class HomePage extends TestBase{
	
	//@FindBy(how=How.ID,using="welcome")  WebElement txtWelcome;
	
	WebDriverWait wait=new WebDriverWait(driver, 30);
	public void verifyValidLogin() {
		try {
			WebElement txtWelcome=driver.findElement(By.id("welcome"));
			utilities.waitForElementVisibility(txtWelcome);
			String name=txtWelcome.getText();
			System.out.println("Logged in User name is ::"+name);
			
			Assert.assertTrue(name.contains("Welcome"), "Logged in user welcome message did not displayed");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void verifyAssignLeave() {
		try {
			WebElement lnkAssignLeave=driver.findElement(By.xpath("//span[text()='Assign Leave']"));
			utilities.waitForElementVisibility(lnkAssignLeave);
			lnkAssignLeave.click();
			
			WebElement btnAssign=driver.findElement(By.id("assignBtn"));
			utilities.waitForElementVisibility(btnAssign);
			String val=btnAssign.getAttribute("value");
			System.out.println(val);
			btnAssign.click();
			Assert.assertTrue(val.contains("Assign"), "Assign Leave button text not valid");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
