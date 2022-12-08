package mouseOverHandelings;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyntraMenuBar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Actions actions = new Actions(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 5);
				driver.get("https://www.myntra.com/");
				List<WebElement> menuSelection = driver.findElements(By.xpath("//div[@class='desktop-navLink']"));
		for (WebElement menuOption : menuSelection)
		{
			actions.moveToElement(menuOption).pause(4).perform();
		}
			driver.quit();	
	}

}
