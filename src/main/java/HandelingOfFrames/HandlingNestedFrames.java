package HandelingOfFrames;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingNestedFrames {
public static void main(String[] args) throws Throwable {
 WebDriver driver = new ChromeDriver();
 driver.manage().window().maximize();
 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 WebDriverWait wait = new WebDriverWait(driver, 10);
 driver.get("https://demo.automationtesting.in/Frames.html");
 driver.findElement(By.xpath("//a[text()='Iframe with in an Iframe']")).click();
 WebElement frameElement = driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
 //Trasferred the control from the default content to the main frame
 driver.switchTo().frame(frameElement);
 //transfer the control from the main frame to the nested frame
 WebElement nestedFrameEle = driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']"));
 driver.switchTo().frame(nestedFrameEle);
 WebElement textFieldOfNestedFrame = driver.findElement(By.xpath("//input[@type='text']"));
 textFieldOfNestedFrame.sendKeys("Selenium");
 //transfer the control back to the parent frame from the nested frame parentFrame()
 String parentFrameText = driver.switchTo().parentFrame().findElement(By.tagName("h5")).getText();
 System.out.println(parentFrameText);
 //transfer the control from parent frame to the nested frame
 driver.switchTo().frame(nestedFrameEle);
 //transfer the control from nested frame to the default content area
 driver.switchTo().defaultContent();
 driver.findElement(By.xpath("//a[text()='Single Iframe ']")).click();
 Thread.sleep(5000);
 //driver.manage().window().minimize();
 driver.quit();
}
}
