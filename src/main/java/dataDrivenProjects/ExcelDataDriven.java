package dataDrivenProjects;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*public class ExcelDataDriven {
	public static void main(String[] args) throws FileNotFoundException {
		System.setProperty("WebDriver.Chrome.driver", "/.drivers.chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("www.facebook.com");
		FileInputStream fis= new FileInputStream("./excelfile/exceldata.xlsx");
		Workbook wb = new WorkbookFactory().create(fis);
		Sheet sh = wb.getSheet("sheet1");
		Row row = sh.getRow(0);
		row.getCell(1);
		
		

	
		
				
	}
}*/


import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import java.util.ArrayList;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExcelDataDriven {
public static void main(String[] args) throws Throwable {
	FileInputStream fis = new FileInputStream("./excelfile/dropdowndata.xlsx");
	Workbook workbook =WorkbookFactory.create(fis);
	Sheet sheet = workbook.getSheet("dropdown");
	
	List<String> expectedDayOptions = new ArrayList<String>();
	List<String> expectedMonthOptions = new ArrayList<String>();
	List<String> expectedYearOptions = new ArrayList<String>();
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
					   expectedMonthOptions.add(cellValue);
					   //System.out.println(cellValue);
				} catch (IllegalStateException e) {
					long cellNum = (long)cell1.getNumericCellValue();
					String numToString = new StringBuilder().append(cellNum).toString(); 
					//System.out.println(numToString);
					if (i==0) {
						expectedDayOptions.add(numToString);
					}else {
						expectedYearOptions.add(numToString);
					}
				}	 
			}
			    
		}	
	}
	workbook.close();
	System.out.println(expectedDayOptions.size());
	System.out.println(expectedDayOptions);
	System.out.println(expectedMonthOptions.size());
	System.out.println(expectedMonthOptions);
	System.out.println(expectedYearOptions.size());
	System.out.println(expectedYearOptions);
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
	WebDriverWait wait = new WebDriverWait(driver, 2);
	driver.get("https://www.facebook.com/signup/");
	WebElement dayDropDown = driver.findElement(By.id("day"));
	Select daySelect = new Select(dayDropDown);
	for (String dayVisisbleText : expectedDayOptions) {
		daySelect.selectByVisibleText(dayVisisbleText);
		if (daySelect.getFirstSelectedOption().isSelected()) {

			System.out.println("Pass: The Day OPtion "+daySelect.getFirstSelectedOption().getText()+ " is Selected");
		}else {
			System.out.println("Fail: The Day Option "+daySelect.getFirstSelectedOption().getText()+" is not selected");
			
		}
	}
	WebElement monthDropDown = driver.findElement(By.id("month"));
	Select monthSelect =new Select(monthDropDown);
	for (String monthVisisbleText : expectedMonthOptions) {
		monthSelect.selectByVisibleText(monthVisisbleText);
		if (monthSelect.getFirstSelectedOption().isSelected()) {
			System.out.println("Pass: The Month "+ monthSelect.getFirstSelectedOption().getText()+" is Selected.");
		}else {
			System.out.println("Fail: The Month "+ monthSelect.getFirstSelectedOption().getText()+" is not selected.");
		}
	}
	WebElement yearDropDown = driver.findElement(By.id("year"));
	Select yearSelect = new Select(yearDropDown);
	for (String yearVisisbleText : expectedYearOptions) {
		yearSelect.selectByVisibleText(yearVisisbleText);
		if (yearSelect.getFirstSelectedOption().isSelected()) {
			System.out.println("Pass: The year "+ yearSelect.getFirstSelectedOption().getText()+" is Sellected" );
		}else {
			System.out.println("Fail: The Year " +yearSelect.getFirstSelectedOption().getText()+" is not Selected");
		}
	}
	//driver.manage().window().minimize();
	driver.quit();
}
}
