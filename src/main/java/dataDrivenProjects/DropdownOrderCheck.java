package dataDrivenProjects;


import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropdownOrderCheck {
public static void main(String[] args) throws Throwable {
	//System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
	FileInputStream fis = new FileInputStream("./excelfile/dropdowndata.xlsx");
	Workbook workbook =WorkbookFactory.create(fis);
	Sheet sheet = workbook.getSheet("dropdown");
	List<String> expectedDayOrder=new ArrayList<String>();
	List<String> expectedMonthOrder = new ArrayList<String>();
	List<String> expectedYearOrder = new ArrayList<String>();
	int i = 0;
	for(i=0; i<=2;i++ ) {
		Row row1 = sheet.getRow(i);
		short startCellNum1 = row1.getFirstCellNum();
		short lastCellNum1 = row1.getLastCellNum();
		for(short colIndex1=startCellNum1; colIndex1<lastCellNum1; colIndex1++) {
			if (colIndex1!=0) {
				Cell cell1 = row1.getCell(colIndex1);
				   try {
					   String cellValue =cell1.getStringCellValue();
					   expectedMonthOrder.add(cellValue);
					   //System.out.println(cellValue);
				} catch (IllegalStateException e) {
					long cellNum = (long)cell1.getNumericCellValue();
					String numToString = new StringBuilder().append(cellNum).toString(); 
					//System.out.println(numToString);
					if (i==0) {
						expectedDayOrder.add(numToString);
					}else {
						expectedYearOrder.add(numToString);
					}
				}	 
			}
			    
		}	
	}
	workbook.close();
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	WebDriverWait wait = new WebDriverWait(driver, 10);
	driver.get("https://www.facebook.com/signup/");
	List<String> actualDayOrder=new ArrayList<String>();
	List<String> actualMonthOrder = new ArrayList<String>();
	List<String> actualYearOrder=new ArrayList<String>();
	WebElement dayDropdown = driver.findElement(By.id("day"));
	Select daySelect = new Select(dayDropdown);
	List<WebElement> allDayOptions = daySelect.getOptions();
	for (WebElement dayOption : allDayOptions) 
	{
		String dayVisibleText = dayOption.getText();
		actualDayOrder.add(dayVisibleText);
	}
	System.out.println(expectedDayOrder);
	System.out.println(actualDayOrder);
	if (actualDayOrder.equals(expectedDayOrder)) 
	{
		System.out.println("Pass: The Day Dropdown options Order is correct and it is verified.");
	}else {
		System.out.println("Fail: The Day Dropdown Options order is incorrect and It is verified.");
	}

	WebElement monthDropdown = driver.findElement(By.id("month"));
	Select monthSelect = new Select(monthDropdown);
	List<WebElement> allMonthOptions = monthSelect.getOptions();
	for (WebElement monthOption : allMonthOptions)
	{
		String monthVisibleText = monthOption.getText();
		actualMonthOrder.add(monthVisibleText);
	}
	System.out.println(expectedMonthOrder);
	System.out.println(actualMonthOrder);
	if (actualMonthOrder.equals(expectedMonthOrder)) 
	{
		System.out.println("Pass: The Month Dropdown options Order is correct and it is verified.");
	}else {
		System.out.println("Fail: The Month Dropdown Options order is incorrect and It is verified.");
	}

	WebElement yearDropdown = driver.findElement(By.id("year"));	
	Select yearSelect = new Select(yearDropdown);
	List<WebElement> allYearOptions = yearSelect.getOptions();
	for (WebElement yearOption : allYearOptions) {
		String yearVisibleText = yearOption.getText();
		actualYearOrder.add(yearVisibleText);
	}
	System.out.println(expectedYearOrder);
	System.out.println(actualYearOrder);
	if (actualYearOrder.equals(expectedYearOrder)) 
	{
		System.out.println("Pass: The Year Dropdown options Order is correct and it is verified.");
	}else {
		System.out.println("Fail: The Year Dropdown Options order is incorrect and It is verified.");
	}

	//driver.manage().window().minimize();
	driver.quit();
	
}
}