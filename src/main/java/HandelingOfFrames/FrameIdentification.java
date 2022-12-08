package HandelingOfFrames;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FrameIdentification {
public static void main(String[] args) throws Throwable {
	WebDriver driver = new ChromeDriver();
	Actions actions = new Actions(driver);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5 , TimeUnit.SECONDS);
	WebDriverWait wait = new WebDriverWait(driver, 5);
	driver.get("https://jqueryui.com/draggable/");
	//NoSuchElementException - Bcz the target element Is presenrt Inside the frame (<iframe>)
	//transfer The control from default content(Webpage) to frame area by using it's index
	driver.switchTo().frame(0);
	WebElement draggableObject = driver.findElement(By.id("draggable"));
	actions.dragAndDropBy(draggableObject, 60, 0).perform();
	Thread.sleep(5000);
	//Element is present In the default content area
	//switch back the control from the currrent frame to the defaultContent area
	driver.switchTo().defaultContent();
	driver.findElement(By.linkText("API Documentation")).click();
	Thread.sleep(5000);
	//driver.manage().window().minimize();
	driver.quit();
}
}

