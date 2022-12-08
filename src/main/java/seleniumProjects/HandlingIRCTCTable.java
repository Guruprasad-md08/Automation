package seleniumProjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingIRCTCTable {
	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.get("https://irctc.com/contact.html");
		WebElement irctcOption = driver.findElement(By.id("heading-9"));
		irctcOption.click();
		WebElement parentTable = driver.findElement(By.tagName("table"));
		List<WebElement> allNameofWebSite = parentTable.findElements(By.xpath("//td[@data-title='Name']"));
		for (WebElement website : allNameofWebSite) {
			String nameOfWebsite = website.getText();
			System.out.println("nameOfWebsite = " + nameOfWebsite);
		}
		List<WebElement> allEmailAdress = parentTable.findElements(By.xpath("//td[@data-title='mail']"));
		for (WebElement emailEle : allEmailAdress) {
			String email = emailEle.getText();
			if (email.isEmpty()) {
				System.out.println("Email is Not Availible");
			}else {
				System.out.println("email = " + email);
			}
		}
		List<WebElement> allWebSitesInTable = parentTable.findElements(By.linkText("Visit Website"));
		for (WebElement urlEle : allWebSitesInTable) {
			String url = urlEle.getAttribute("href");
			System.out.println("url = " + url);
			if (url.equals("https://www.the-maharajas.com/")) {
				driver.get(url);
				Thread.sleep(2000);
				driver.navigate().back();
				Thread.sleep(2000);
				driver.navigate().back();
				Thread.sleep(2000);
			}
			
		}
		//driver.manage().window().minimize();
		driver.quit();
		
		
	}
	}
			

