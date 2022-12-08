package seleniumProjects;

import java.awt.Window;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActiTimeLogin{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//01 -open the browser
		
		System.setProperty("webdriver.chrome.driver","./drivers/chromeDriver.exe");
		WebDriver  driver = new ChromeDriver();
		
		//02 - Maximize the window
		
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//Step 03: enter the main URL Of the application
		driver.get("https://demo.actitime.com/");
		String expectedLoginPageTitle = "actiTIME - Login";
		System.out.println("expectedLoginPageTitle = " + expectedLoginPageTitle);
		String expectedLoginPageUrl = "https://demo.actitime.com/login.do";
		System.out.println("expectedLoginPageUrl = " + expectedLoginPageUrl);
		if (wait.until(ExpectedConditions.titleIs(expectedLoginPageTitle))&& wait.until(ExpectedConditions.urlToBe(expectedLoginPageUrl))) {
			String actualLoginPageUrl = driver.getCurrentUrl();
			System.out.println("actualLoginPageUrl = " + actualLoginPageUrl);	
			String actualLoginPageTitle = driver.getTitle();
			System.out.println("actualLoginPageTitle = " + actualLoginPageTitle);
			System.out.println("Pass: Login page is displayed and it is verified upon it's title and URL");
			}else {
				System.out.println("Fail: Login page is not displayed and it is verified upon it's title and URL");
			}
		//Step 04: Enter the Username
			WebElement usernameTextField = driver.findElement(By.id("username"));
			usernameTextField.clear();
			usernameTextField.sendKeys("admin");
		//Step 05: Enter the password
			WebElement passwordTextField = driver.findElement(By.name("pwd"));
			passwordTextField.clear();
			passwordTextField.sendKeys("manager");
			//Step 06: Select the check box
			WebElement keepLoggedInCheckBox = driver.findElement(By.id("keepLoggedInCheckBox"));
			keepLoggedInCheckBox.click();
			if (keepLoggedInCheckBox.isSelected()) {
				System.out.println("Pass: The keepLoggedInCheckBox is selected and it is verified.");
			}else {
				System.out.println("Fail: The keepLoggedInCheckBox is not selected and it is verified.");
			}
		//Step 07: Click on Login Button
			WebElement loginButton = driver.findElement(By.id("loginButton"));
		
			if (loginButton.getTagName().equals("a")) {
				System.out.println("Pass: The Login Button made with <a>.");
				loginButton.click();
				String expectedHomePageTitle ="actiTIME - Enter Time-Track";
				System.out.println("expectedHomePageTitle = " + expectedHomePageTitle);
				String actualHomePageTitle = driver.getTitle();
				System.out.println("actualHomePageTitle = " + actualHomePageTitle);
				String expectedHomePageUrl = "https://demo.actitime.com/user/submit_tt.do";
				System.out.println("expectedHomePageUrl = " + expectedHomePageUrl);
				String actualHomePageUrl = driver.getCurrentUrl();
				System.out.println("actualHomePageUrl = " + actualHomePageUrl);
				WebElement logoutOption = driver.findElement(By.id("logoutLink"));
				if (wait.until(ExpectedConditions.titleIs(expectedHomePageTitle))) {
					if (wait.until(ExpectedConditions.urlToBe(expectedHomePageUrl))) {
						wait.until(ExpectedConditions.visibilityOf(logoutOption));
						if (logoutOption.isDisplayed()) {
							
							logoutOption.click();
							System.out.println("Pass: The Home Page Is Displayed and it is verified upon title, URL and visibility of logout option.");
							}	
						}
					}else {
					System.out.println("Fail: The Home Page is not displayed and it Is verified upon it's title, URL and visibility of logout option.");
				}
			}else {
				System.out.println("Fail: The Login Button is made with<" +loginButton.getTagName()+">,and it will not be clicked. ");
			}
			
		//Step 08: minimize the browser window
			//driver.manage().window().minimize();
		//Step 09: Terminate the session
			driver.quit();	
	}

}

