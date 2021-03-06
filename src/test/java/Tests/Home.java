package Tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.TestBase;
import Utility.utilities;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;


public class Home extends TestBase{
	LoginPage login;
	HomePage home;
	

	@Test(priority=0)
	@Description("Login to Orange HRM")
	public void initializePageFactory() {
		login=PageFactory.initElements(driver, LoginPage.class);
		home=PageFactory.initElements(driver, HomePage.class);
		login=new LoginPage();
		home=new HomePage();
	}
	
	
	@Test(priority=1,enabled=false)
	@Description("Verify Welcome Message")
	@Epic(" Epic : Home")
	@Feature("Feature : Valid Login")
	@Step("Steps : Verify valid user is logged in")
	@Severity(SeverityLevel.BLOCKER)
	public void login() throws InterruptedException {
		System.out.println("Test Method Data:: "+testData);
		login.login();
		utilities.waitForWebElement();
		home.verifyValidLogin();
	}
	
	@Test(priority=2)
	@Description("Verify Assign Leave")
	@Epic(" Epic : Leave")
	@Feature("Feature : Valid Assign Leave")
	@Step("Steps : Navigate to Assign Leave and Verify Page")
	@Severity(SeverityLevel.BLOCKER)
	public void verifyAssignLeave() throws InterruptedException {
		login.login();
		utilities.waitForWebElement();
		home.verifyAssignLeave();
	}

}
