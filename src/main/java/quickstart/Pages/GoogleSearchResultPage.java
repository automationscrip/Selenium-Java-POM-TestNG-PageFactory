package quickstart.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Constants.TimeOuts;

public class GoogleSearchResultPage {

	WebDriver driver;

	By firstResult= By.xpath("//div[@class='g']//h3");

	public GoogleSearchResultPage(WebDriver driver) {
		this.driver=driver;
	}

	public  boolean isLinkDisplayed(String elementName) {

		String searchResultLink="//h3[contains(.,'"+elementName+"')]";
		WebDriverWait wait= new WebDriverWait(driver, TimeOuts.DEFAULT_TIMEOUT);
		WebElement ele= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(searchResultLink)));
		return ele.isDisplayed();
	}
	
	
	public  WebElement getFirstResult() {
		WebElement firstLink= driver.findElement(firstResult);
		return firstLink;
	}
}
