package ActionsClassExample;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RightClickOnElement {
public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 WebDriverWait wait = new WebDriverWait(driver, 10);
	driver.get("file:///C:/Users/HP/Desktop/check.html");
	//Right click
	WebElement rightclickOption = driver.findElement(By.id("rightclick"));
	new Actions(driver).contextClick(rightclickOption).perform();
}
}

