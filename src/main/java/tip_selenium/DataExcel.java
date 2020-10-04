package tip_selenium;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class DataExcel {


	public void display(WebDriver driver) throws IOException {


		//To store the names of flights
		String[] str = new String[5];

		//To store the price
		String[] pri = new String[5];

		//List for flight names
		List<WebElement> name = driver.findElements(By.xpath("//*[contains(@class,'col-md-7 col-sm-7 padd-lft airl-txt-n')]"));

		//List for flight price
		List<WebElement> price = driver.findElements(By.xpath("//*[contains(@class,'col-md-8 col-sm-8 col-xs-9 txt-r6-n ng-binding')]"));

		int j = 0;
		for (int i = 0; i < 5; i++) {
			//Printing the details
			if (!price.get(j).getText().equals("")) {
				System.out.println("Flight Name :" + name.get(i).getText() + "-----Price : " + price.get(j).getText());
				j = j + 2;
			}

		}

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("sheet");

		//To input the headings in excel
		XSSFRow firstRow = sheet.createRow(0);
		XSSFCell firstCell = firstRow.createCell(0);
		firstCell.setCellValue("Flight Name");
		XSSFCell SecondCell = firstRow.createCell(1);
		SecondCell.setCellValue("Price");

		//To input first flight's name and price
		XSSFRow SecondRow = sheet.createRow(1);
		XSSFCell SecondFirstCell = SecondRow.createCell(0);
		SecondFirstCell.setCellValue(name.get(0).getText());
		XSSFCell SecondSecondCell = SecondRow.createCell(1);
		SecondSecondCell.setCellValue(price.get(0).getText());

		//To input second flight's name and price
		XSSFRow ThirdRow = sheet.createRow(2);
		XSSFCell ThirdFirstCell = ThirdRow.createCell(0);
		ThirdFirstCell.setCellValue(name.get(1).getText());
		XSSFCell ThirdSecondCell = ThirdRow.createCell(1);
		ThirdSecondCell.setCellValue(price.get(2).getText());

		//To input third flight's name and price
		XSSFRow FourthRow = sheet.createRow(3);
		XSSFCell FourthFirstCell = FourthRow.createCell(0);
		FourthFirstCell.setCellValue(name.get(2).getText());
		XSSFCell FourthSecondCell = FourthRow.createCell(1);
		FourthSecondCell.setCellValue(price.get(4).getText());

		//To input fourth flight's name and price
		XSSFRow FifthRow = sheet.createRow(4);
		XSSFCell FifthFirstCell = FifthRow.createCell(0);
		FifthFirstCell.setCellValue(name.get(3).getText());
		XSSFCell FifthSecondCell = FifthRow.createCell(1);
		FifthSecondCell.setCellValue(price.get(6).getText());

		//To input fifth flight's name and price
		XSSFRow SixthRow = sheet.createRow(5);
		XSSFCell SixthFirstCell = SixthRow.createCell(0);
		SixthFirstCell.setCellValue(name.get(4).getText());
		XSSFCell SixthSecondCell = SixthRow.createCell(1);
		SixthSecondCell.setCellValue(price.get(8).getText());

		FileOutputStream writeFile = new FileOutputStream("Mini_Project.xlsx");
		workbook.write(writeFile);

	}
}
