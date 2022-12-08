package mouseOverHandelings;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipkartLogin {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Actions actions = new Actions(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		driver.get("https://www.flipkart.com/");
	WebElement popupClose = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
	popupClose.click();	
	WebElement loginButton = driver.findElement(By.xpath("//a[text()='Login']"));
		actions.moveToElement(loginButton).pause(4).perform();
		Thread.sleep(500);
		WebElement rewardOption = driver.findElement(By.xpath("//div[text()='Rewards']"));
		actions.moveToElement(rewardOption).pause(4).click().perform();
			driver.quit();	
	}

}
