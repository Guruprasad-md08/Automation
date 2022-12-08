package mouseOverHandelings;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyntraMoveToOffset {
public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	Actions actions = new Actions(driver);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	WebDriverWait wait = new WebDriverWait(driver, 10);
	driver.get("https://www.myntra.com/");
	WebElement menSection = driver.findElement(By.xpath("//div[@class='desktop-navLink']/a[text()='Men']"));
	actions.moveToElement(menSection).pause(Duration.ofSeconds(2)).moveToElement(menSection, 76, 0).pause(Duration.ofSeconds(2)).moveToElement(menSection, 153, 0).pause(Duration.ofSeconds(2)).moveToElement(menSection, 253, 0).pause(Duration.ofSeconds(2)).moveToElement(menSection, 365, 0).pause(Duration.ofSeconds(2)).moveToElement(menSection, 454, 0).build().perform();
}
}