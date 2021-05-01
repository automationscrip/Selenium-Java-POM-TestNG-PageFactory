package quickstart.Tests;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;



import functionLibrary.ReportLog;
import functionLibrary.TestData;
import io.github.bonigarcia.wdm.WebDriverManager;
import quickstart.Pages.GoogleSearchPage;
import quickstart.Pages.GoogleSearchResultPage;


public class DemoTest {
	WebDriver driver;
	GoogleSearchPage googleSearch ;
	GoogleSearchResultPage googlesearchresults;
	ReportLog logger;

	TestData testdata;

	@BeforeSuite
	public void startTestSuite() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		logger= new ReportLog(driver);
		String currDir= System.getProperty("user.dir");
		try {
			testdata= new TestData(currDir+"\\TestData\\searchData.xlsx");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Issue in Test data file opening; you can do some operation here, may be exit test");
		}
	}
	@BeforeMethod
	public void startTest(Method m) {
		logger.startTest(m.getName());
		driver.get("https://google.com");
		driver.manage().window().maximize();

	}

	@AfterMethod
	public void endTest() {
		logger.endTest();

	}

	@AfterSuite
	public void endTestSuite() {
		logger.endTestSuite();
		driver.quit();
	}

	@Test
	public  void GoogleSearch_automationScript() throws IOException {

		googleSearch= new GoogleSearchPage(driver);
		googlesearchresults= new GoogleSearchResultPage(driver);		
		googleSearch.searchKeyword("automationScript");			
		boolean isDisplayed= googlesearchresults.isLinkDisplayed("automationScript");		
		if(isDisplayed==true) {
			logger.logPass("automationScript Link is displayed on Google Search results page 1");
		}else {
			logger.logFail("automationScript Link is not displayed on Google Search results page 1");

		}
		String firstLinkText= googlesearchresults.getFirstResult().getAttribute("innerText");		
		if(firstLinkText.contains("automationScript")) {
			logger.logPass("automationScript Link is displayed as 1st link on Google Search results page 1");
		}else {
			logger.logFail("automationScript Link is not displayed as 1st link on Google Search results page 1");

		}
		logger.logInfo("Sample Test data fetched from test data file for test case 1= "+testdata.getTestData("1", "Keyword"));
	}


	@Test
	public  void GoogleSearch_Facebook() throws IOException {

		googleSearch= new GoogleSearchPage(driver);
		googlesearchresults= new GoogleSearchResultPage(driver);		
		googleSearch.searchKeyword("Facebook");			
		boolean isDisplayed= googlesearchresults.isLinkDisplayed("Facebook");		
		if(isDisplayed==true) {
			logger.logPass("Facebook Link is displayed on Google Search results page 1");
		}else {
			logger.logFail("Facebook Link is not displayed on Google Search results page 1");

		}
		String firstLinkText= googlesearchresults.getFirstResult().getAttribute("innerText");		
		if(firstLinkText.contains("Facebook")) {
			logger.logPass("Facebook Link is displayed as 1st link on Google Search results page 1");
		}else {
			logger.logFail("Facebook Link is not displayed as 1st link on Google Search results page 1");

		}
		logger.logInfo("Sample Test data fetched from test data file for test case 2= "+testdata.getTestData("2", "Keyword"));


	}




	@Test
	public  void GoogleSearch_Twitter() throws IOException {

		googleSearch= new GoogleSearchPage(driver);
		googlesearchresults= new GoogleSearchResultPage(driver);		
		googleSearch.searchKeyword("Twitter");			
		boolean isDisplayed= googlesearchresults.isLinkDisplayed("Twitter");		
		if(isDisplayed==true) {
			logger.logPass("Twitter Link is displayed on Google Search results page 1");
		}else {
			logger.logFail("Twitter Link is not displayed on Google Search results page 1");

		}
		String firstLinkText= googlesearchresults.getFirstResult().getAttribute("innerText");		
		if(firstLinkText.contains("Twitter")) {
			logger.logPass("Twitter Link is displayed as 1st link on Google Search results page 1");
		}else {
			logger.logFail("Twitter Link is not displayed as 1st link on Google Search results page 1");

		}
		logger.logInfo("Sample Test data fetched from test data file for test case 3= "+testdata.getTestData("3", "Keyword"));
	}


	@Test
	public  void GoogleSearch_LinkedIn() throws IOException {

		googleSearch= new GoogleSearchPage(driver);
		googlesearchresults= new GoogleSearchResultPage(driver);		
		googleSearch.searchKeyword("LinkedIn");			
		boolean isDisplayed= googlesearchresults.isLinkDisplayed("LinkedIn");		
		if(isDisplayed==true) {
			logger.logPass("LinkedIn Link is displayed on Google Search results page 1");
		}else {
			logger.logFail("LinkedIn Link is not displayed on Google Search results page 1");

		}
		String firstLinkText= googlesearchresults.getFirstResult().getAttribute("innerText");		
		if(firstLinkText.contains("LinkedIn")) {
			logger.logPass("LinkedIn Link is displayed as 1st link on Google Search results page 1");
		}else {
			logger.logFail("LinkedIn Link is not displayed as 1st link on Google Search results page 1");

		}
		logger.logInfo("Sample Test data fetched from test data file for test case 4= "+testdata.getTestData("4", "Keyword"));

	}

}
