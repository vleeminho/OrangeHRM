package Utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.TestBase;
import io.qameta.allure.Attachment;

public class utilities extends TestBase{
	public static WebDriverWait wait=new WebDriverWait(driver, 60);
	
	@Attachment(value= "{0}",type="text/plain")
	public static String saveTextLog(String message) {
		return message;
	}
	public static void webEditTxtChange(WebElement ele,String value) {
		try {
			ele.clear();
			if(!value.equals("\"\"")) {
				ele.sendKeys(value);
			}
			
		}catch (Exception e) {
			saveTextLog("webEditTxtChange Failed!!!");
			e.printStackTrace();
		}
	}
	
	public static void webCheckON(WebElement ele) {
		try {
			if(ele.isSelected()==false) {
				ele.click();
				saveTextLog("Check box checked");
			}else {
				saveTextLog("Check already box checked!");
			}
		} catch (Exception e) {
			saveTextLog("webCheckON Failed!!!");
			e.printStackTrace();
		}
	}
	
	public static void webCheckOFF(WebElement ele) {
		try {
			if(ele.isSelected()==true) {
				ele.click();
				saveTextLog("Check box unchecked");
			}else {
				saveTextLog("Check already box unchecked!");
			}
		} catch (Exception e) {
			saveTextLog("webCheckON Failed!!!");
			e.printStackTrace();
		}
	}
	
	public static void waitForPageLoad(WebElement ele) {
		try {
			wait.until(ExpectedConditions.invisibilityOf(ele));
		} catch (Exception e) {
			saveTextLog("waitForPageLoad Failed!!!");
			e.printStackTrace();
		}
	}
	
	public static void waitForWebElement() {
		try {
			Thread.sleep(CONSTANT.PAGELOADTIME);
		} catch (Exception e) {
			saveTextLog("waitForWebElement Failed!!!");
			e.printStackTrace();
		}
	}
	
	public static void waitForElementVisibility(WebElement ele) {
		try {
			if(ele!=null) {
				wait.until(ExpectedConditions.visibilityOf(ele));
			}else {
				saveTextLog("WebElement is null");
			}
			
		} catch (Exception e) {
			saveTextLog("waitForElementVisibility Failed!!!");
			e.printStackTrace();
		}
	}

}
