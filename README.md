# Selenium-Java-POM-TestNG-PageFactory
## Introduction
This is a quickstart test automation framework based on **Page Object Model** design pattern for **Selenium WebDriver** with *Java*, *maven* and *TestNG*. It also integrates Extent Reports for reporting.
Note :

> This framework uses **PageFactory** method to store the WebElements in the page objects. The elements are initialized in the constructors of their respective  page objects with the help of **PageFactory.initElements**


## Test Scenario
We have taken a very simple test scenario for quickstart.
Search a keyword on google and validate if the keyword appears as the first result on search results page.

### Test Steps:
		1. Open google search application: url- www.google.com
		2. Enter a keyword in the search box
		3. On the search results page, validate if the keyword appears as the first result.
	
## Plugins

 1. **Eclipse Plugin** - If you want to run your tests from Eclipse as *TestNG Suite*, you need to download TestNG in Eclipse through *available software site*-  [TestNG](https://dl.bintray.com/testng-team/testng-eclipse-release/).

2. **Maven Dependencies** - This framework has been designed with following maven dependencies as defined further in the *pom.xml*.
	| Dependency | Version | Purpose |
	|--|--|--|
	| Selenium WebDriver|3.141| It automates the testing of web application.|
	| TestNG|7.3.0|To run the tests as a suite.|
	| Extent Reports|5.0.6|To genarate Enhanced html reports after test run.|
	| APACHE Commons IO|2.8.0|To perform file opeartions.|
	| webdrivermanager|4.3.1| WebDriverManager is a library which allows to automate the management of the drivers (e.g. _chromedriver_, _geckodriver_, etc.) required by Selenium WebDriver. [bonigarcia/webdrivermanager: Automated driver management for Selenium WebDriver (github.com)](https://github.com/bonigarcia/webdrivermanager#basic-usage)|
	| Apache POI|5.0.0|To read and write .xls excel files (e.g. test data files)
	| POI-OOXML|5.0.0| To read and write .xlsx excel files (e.g. test data files)


	**pom.xml**
```xml
	<dependencies>

		<dependency>
			<groupId>org.testng</groupId>
			<artifactId>testng</artifactId>
			<version>7.3.0</version>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>com.aventstack</groupId>
			<artifactId>extentreports</artifactId>
			<version>5.0.6</version>
		</dependency>
		<dependency>
			<groupId>org.seleniumhq.selenium</groupId>
			<artifactId>selenium-java</artifactId>
			<version>3.141.59</version>
		</dependency>
		<dependency>
			<groupId>commons-io</groupId>
			<artifactId>commons-io</artifactId>
			<version>2.8.0</version>
		</dependency>
		<dependency>
			<groupId>io.github.bonigarcia</groupId>
			<artifactId>webdrivermanager</artifactId>
			<version>4.3.1</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/org.apache.poi/poi -->
		<dependency>
			<groupId>org.apache.poi</groupId>
			<artifactId>poi</artifactId>
			<version>5.0.0</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml -->
		<dependency>
			<groupId>org.apache.poi</groupId>
			<artifactId>poi-ooxml</artifactId>
			<version>5.0.0</version>
		</dependency>

	</dependencies>
``` 

## How to use
The first thing a framework should be able to handle is to launch the browser and navigate a given url.

 1. ### Download Dependencies
 
	First of all, you need to download your maven depenedencies using any of the maven commands such as 
	Go to-
		 1. *Eclipse> Project Explorer*
		 2. Right click on the project.
		 3. *Maven> Update Project*.
 

 2. ### Project structure
	The automation framework is built to address following 4 major requirements through it's components.

	1. **Setup the WebDriver** to automate actions on browser.
	2. **Read test data** from test data file(formats such as .xls, .json, .xml etc.)
	3. **Page Classes** for each page containing locators of their respective WebElements and methods to operate on them.		 
	4. **Test Classes** containing Test cases in the form of methods with annotation @Test.
	5. **Execution control**- We are executing our tests through *testng.xml*. It can be other options such as through mvn test or command line.
	6. **Create a readable html report** after test execution.
		 
3. ### Test Classes		
	We have a class *DemoTest.java* under *src/test/java/quickstart.Tests*. 
	Every Test method has annotation *@test*. This is the place where we have all the checkpoints.	This class utilizes TestNG annotations to handle the flow of test execution in the given order.
	
	1. **@BeforeSuite**- 
		 - Setup the chromedriver binaries using below: 
			`WebDriverManager.chromedriver().setup();`			
		 - Initialize the WebDriver *driver*
		 - Initialize the Logger *logger*
		 - loads the test data file and initialize it in *testdata*
		 
	2. **@BeforeMethod**- 			
		 - Create a test in Extent Report before each test.
		 - Navigate a urland maximize the window.

	3. **@Test**- 
		
		 - Initialize the page objects.
		 - Validation steps by calling the page objects.

	4. **@AfterMethod**	

		 - End the logging for the test.

	5. **@AfterSuite**	

		 - End the test suite in logging
		 - Quit the WebDriver instance



3. ### Page classes
	We create page classes for each of the pages of our application. 
	`src/main/java> quickstart.pages> GoogleSearchPage.java`

	Each page class contains two components as below.
	1. Locators are written as 
	```java
		@FindBy(xpath="//div[@class='g']//h3/span")
		WebElement firstResult;
	```
	2. Page class methods for tests steps
	3. Page class constructor initializes the webelements through 
	```java
		PageFactory.initElements(driver, this);
	```

 5. ### Run tests through testng.xml
	 If you want to run your tests through *testng.xml* , You can perform following steps.

	 1. Eclipse>Project Explorer
	 2. Open/Expand the project
	 3. Right click on the *testng.xml*
	 4. *Run As> TestNG Suite*

	It will run all the tests as per defined classes in the the file.
	 
 6. ### Run tests through maven
	 If you want to run your tests through maven, You can perform following steps.
	1. *Eclipse> Project Explorer*
	2. Right click on the project.
	3. *Run As> Maven test*.

			 
	It will automatically run all the tests as per below convention.
	
	 1. Classes under src/test/java
	 2. Class name with text *Test* in the beginneing or end
	 3. Test methods with annotation @test

