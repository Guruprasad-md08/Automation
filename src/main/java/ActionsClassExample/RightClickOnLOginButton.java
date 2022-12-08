package ActionsClassExample;



import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RightClickOnLOginButton {
public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 WebDriverWait wait = new WebDriverWait(driver, 10);
	driver.get("https://www.facebook.com/");
	WebElement loginButton = driver.findElement(By.name("login"));
	Actions actions = new Actions(driver);
	//actions.moveToElement(loginButton).contextClick(loginButton).perform();
	//WebElement createNewAccButton = driver.findElement(By.linkText("Create New Account"));
	//actions.moveToElement(createNewAccButton).contextClick(createNewAccButton).perform();
	WebElement emailAddTextField = driver.findElement(By.id("email"));
	//actions.sendKeys(emailAddTextField, "chandan.r@testyantra.com").perform();
	//actions.sendKeys("chadan.r@testyantra.com").perform();
	//actions.scrollToElement(driver.findElement(By.linkText("Help"))).perform();
	//actions.scrollByAmount(0, 100).perform();
	//actions.key
	
}
}


