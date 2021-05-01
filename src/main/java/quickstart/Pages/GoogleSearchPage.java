package quickstart.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Constants.TimeOuts;

public class GoogleSearchPage  {

	WebDriver driver;


    @FindBy(xpath="//input[@name='q']")
    WebElement searchBox;
	
    @FindBy(xpath="//div[@class='g']//h3/span")
    WebElement firstResult;

	/**
	 * Constructor of the Page class to set the driver.
	 * It is also used to initialize all the elements.
	 * @param driver
	 */
	public GoogleSearchPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * This method is for entering a keyword in an input field on the webpage
	 * Notice how the above defined WebElement searchBox is used in place of 
	 * driver.findElement(By.xpath(locator))
	 * @param keyword A string value to be entered in the field
	 */
	public void enterKeyWord(String keyword) {
		
		searchBox.sendKeys(keyword);
		searchBox.sendKeys(Keys.ENTER);
	}
	
	public  void searchKeyword(String keyword) {
		
		this.enterKeyWord(keyword);
		this.waitForResultLink(keyword);			
	}
	public void waitForResultLink(String keyword) {
		String searchResultLink="//h3[contains(.,'"+keyword+"')]";
		WebDriverWait wait= new WebDriverWait(driver, TimeOuts.DEFAULT_TIMEOUT);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(searchResultLink)));		
	}

}
