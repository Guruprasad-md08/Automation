package dataDrivenProjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropdownOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
WebDriverWait wait = new WebDriverWait(driver, 2);
driver.get("https://www.facebook.com/signup/");
WebElement dropDown = driver.findElement(By.id("day"));
Select daySelect = new Select(dropDown);

	}

}
