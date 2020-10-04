package tip_selenium;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Trip {

	static WebDriver driver;
	WebDriverWait wait;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;
	String sr;
	String dc;

	public static void main(String[] args) {
		Trip obj = new Trip();
		obj.createDriver();

		obj.websiteAccess();
		try {
			obj.getData();
		} catch (Exception e) {
			System.out.println("Exception handled");
		}
		obj.travelDetails();
		obj.sortingResult();
		obj.displayExcel();
		obj.closeWindow();
	}

	//Driver setup
	public WebDriver createDriver() {
		DriverSetup d = new DriverSetup();
		driver = DriverSetup.getWebDriver();
		return driver;
	}

	//Access the website
	public void websiteAccess() {


		driver.navigate().to("https://www.easemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	//Get input data from the excel
	public void getData() throws IOException {

		//Set the location of the excel file
		File src = new File("C:\\Users\\870653\\Documents\\tripexcel.xlsx");

		// Load the file.
		FileInputStream finput = new FileInputStream(src);

		// Load he workbook.
		workbook = new XSSFWorkbook(finput);

		// Load the sheet in which data is stored.
		sheet = workbook.getSheetAt(0);


		// Import data for From(source).
		cell = sheet.getRow(1).getCell(0);
		sr = cell.getStringCellValue();

		// Import data for To(destination).
		cell = sheet.getRow(1).getCell(1);
		dc = cell.getStringCellValue();
	}

	public void travelDetails() {

		//Match the from value
		driver.findElement(By.id("FromSector_show")).click();
		driver.findElement(By.xpath("//span[contains(text(),'" + sr + "')]")).click();

		//Match the To value
		driver.findElement(By.id("Editbox13_show")).click();
		driver.findElement(By.xpath("//div[@id='toautoFill']//span[contains(text(),'" + dc + "')]")).click();

		//Selection of date- 25/09/2020
		driver.findElement(By.id("ddate")).click();
		driver.findElement(By.id("frth_5_25/09/2020")).click();

		driver.findElement(By.id("search")).click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	//Sorting the flights in decreasing order of the price
	public void sortingResult() {

		driver.navigate().refresh();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//*[contains(@class,'fa pri2 fa-long-arrow-up pad-4')]")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[contains(@class,'fa pri2 pad-4 fa-long-arrow-down')]")).click();
	}

	//To display the name and price in console and excel
	public void displayExcel() {


		DataExcel de = new DataExcel();
		try {
			de.display(driver);
		} catch (Exception e) {
			System.out.println("Exception handled");
		}
	}

	//Closing the window
	public void closeWindow() {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.close();
	}
}
