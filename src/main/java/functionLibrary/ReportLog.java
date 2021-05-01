package functionLibrary;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportLog {
	WebDriver driver;
	   ExtentReports extent;
	   ExtentSparkReporter spark;
	   ExtentTest test;
	   String ScreenshotPath; 
	
	
	public ReportLog(WebDriver driver) {
		this.driver=driver;
		this.extent = new ExtentReports();
		this.spark = new ExtentSparkReporter("target/Spark.html");
		this.extent.attachReporter(spark);	
		this.ScreenshotPath= "target/Spark/";
	}
	
	public void startTest(String TestName) {
		test= extent.createTest(TestName);
		test.log(Status.INFO, "Start of Test");
	}
	public void endTest() {
		test.log(Status.INFO, "End of Test");
	}
	
	public void endTestSuite() {
		test.log(Status.INFO, "End of Test Suite");
		extent.flush();
	}
	public void logPass(String checkpointDetails) throws IOException {
		String screenshotFilePath=Utilities.getScreenshot(driver);
		test.pass(checkpointDetails, MediaEntityBuilder.createScreenCaptureFromPath(screenshotFilePath).build());
		
	}
	public  void logFail(String checkpointDetails) throws IOException {
		String screenshotFilePath=Utilities.getScreenshot(driver);
		test.fail(checkpointDetails, MediaEntityBuilder.createScreenCaptureFromPath(screenshotFilePath).build());
	}
	
	public  void logInfo(String checkpointDetails) {
		test.info(checkpointDetails);
	}

}
