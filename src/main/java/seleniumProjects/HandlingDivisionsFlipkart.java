package seleniumProjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingDivisionsFlipkart {
	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.get("https://www.flipkart.com/");
		WebElement menuContainer = driver.findElement(By.xpath("//div[@class='_37M3Pb']"));
		WebElement topOffersButton = menuContainer.findElement(By.xpath("//div[text()='Top Offers']"));
		topOffersButton.click();
		WebElement groceryButton = menuContainer.findElement(By.xpath("//div[text()='Grocery']"));
		System.out.println("groceryButton TagName = "+groceryButton.getTagName());
		groceryButton.click();
		driver.navigate().back();
		driver.navigate().back();
		Thread.sleep(5000);
		WebElement mobilesButton = menuContainer.findElement(By.xpath("//div[text()='Mobiles']"));
		if(mobilesButton.isDisplayed()) {
			System.out.println("Pass: Mobiles Button is Displayed");
			mobilesButton.click();
		}else {
			System.out.println("Fail: Mobiles Button is not Displayed");	
		}
		
		WebElement fashionOption = menuContainer.findElement(By.linkText("Fashion"));
		if (fashionOption.getTagName().equals("button")) {
			System.out.println("Fail: This should not be  <button> and it should be <a> ");
		}else if(fashionOption.getTagName().equals("a")){
			System.out.println("Pass: It Is <a> and we perform action on the element.");
			fashionOption.click();
		}
	//	driver.navigate().back();
	//	Thread.sleep(5000);
	//	WebElement resourcesButton = driver.findElement(By.xpath("//div[@class='Tabsstyles__TabGroup-sc-1grh34k-2 hniXih']//button[text()='Resources']"));
	//	wait.until(ExpectedConditions.elementToBeClickable(resourcesButton));
	//	resourcesButton.click();
driver.quit();
	}
	}

