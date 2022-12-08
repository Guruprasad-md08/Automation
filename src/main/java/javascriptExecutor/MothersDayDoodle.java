package javascriptExecutor;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MothersDayDoodle {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.get("https://www.google.com/doodles");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		for(;;) {
			try {
				WebElement mothersDayDoodle = driver.findElement(By.linkText("Mother's Day 2021 (October 17)"));
				mothersDayDoodle.click();
				break;
			} catch (Exception e) {
				//System.out.println("QCSE6 people - Doodle is not their in the view port area Plz come up with the solution.");
				jse.executeScript("window.scrollBy(0,600)");
			}
			driver.quit();
			}


		}
		}
