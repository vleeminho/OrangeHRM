package Pages;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import Utility.ExcelUtils;
import Utility.ReadPropertyFile;


public class TestBase {

	public static WebDriver driver;
	public static Map<String, List<String>> testSuiteData;
	public static List<String> testData;
	//public static Map<String,String> mapTFSId;
	public static String testSuite;
	public static ThreadLocal<WebDriver> tdriver=new ThreadLocal<WebDriver>();
	//private static final String JENKINS_BUILD_URL = System.getProperty("jenkins.buildUrl");
	
	@BeforeTest
	public void readExcelWorkbook(ITestContext ctx) {
		try {
			testSuite = ReadPropertyFile.readTestSuiteDirectory()+ctx.getName()+".xlsx";
			testSuiteData = ExcelUtils.readExcel(testSuite);
			System.out.println("Executing TestSuite ::"+testSuite);
			System.out.println("TestSuiteData  ::"+testSuiteData);
		}catch (Exception e) {
			
		}
	}
	
	@BeforeMethod
	@Parameters("browser")
	public void setUp(String browser,Method method,ITestContext ctx) throws Exception {
		String testName=method.getName();
		try {
			testData = ExcelUtils.getTestData(testName, testSuiteData);
			System.out.println("Test Method Data:: "+testData);
			//System.out.println("Build_Parameter is ::"+JENKINS_BUILD_URL);
			if(browser.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver", "D:\\Workspace\\OrangeHRM\\drivers\\chromedriver.exe");
				//WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
			}/*else if (browser.equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.gecko.driver", "D:\\Workspace\\OrangeHRM\\drivers\\geckodriver.exe");
				DesiredCapabilities capabilities = DesiredCapabilities.firefox();
				capabilities.setCapability("marionette",true);
				driver= new FirefoxDriver(capabilities);
			}*/
			else {
				System.setProperty("webdriver.chrome.driver", "D:\\Workspace\\OrangeHRM\\drivers\\chromedriver.exe");
				//WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
			}
			
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			tdriver.set(driver);
			Thread.sleep(3000);
		}catch (Exception e) {
			throw e;
		}
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		try {
			driver.close();
		}catch (Exception e) {
			throw e;
		}
	}
	public static synchronized WebDriver getDriverInstance()
    {
    	
		return tdriver.get();
    	
    }
}
