package seleniumProjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingDivisions {
	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.get("https://trello.com/");
		WebElement menuContainer = driver.findElement(By.xpath("//div[@class='Tabsstyles__TabGroup-sc-1grh34k-2 hniXih']"));
		WebElement featuresButton = menuContainer.findElement(By.xpath("//button[text()='Features']"));
		featuresButton.click();
		WebElement solutionsButton = menuContainer.findElement(By.xpath("//button[text()='Solutions']"));
		System.out.println("solutionsButton TagName = "+solutionsButton.getTagName());
		solutionsButton.click();
		WebElement plansButton = menuContainer.findElement(By.xpath("//button[text()='Plans']"));
		if(plansButton.isDisplayed()) {
			System.out.println("Pass: Plans Button is Displayed");
			plansButton.click();
		}else {
			System.out.println("Fail: Plans Button is not Displayed");	
		}
		WebElement pricingOption = menuContainer.findElement(By.linkText("Pricing"));
		if (pricingOption.getTagName().equals("button")) {
			System.out.println("Fail: This should not be  <button> and it should be <a> ");
		}else if(pricingOption.getTagName().equals("a")){
			System.out.println("Pass: It Is <a> and we perform action on the element.");
			pricingOption.click();
		}
		driver.navigate().back();
		Thread.sleep(5000);
		WebElement resourcesButton = driver.findElement(By.xpath("//div[@class='Tabsstyles__TabGroup-sc-1grh34k-2 hniXih']//button[text()='Resources']"));
		wait.until(ExpectedConditions.elementToBeClickable(resourcesButton));
		resourcesButton.click();
driver.quit();
	}
	}

