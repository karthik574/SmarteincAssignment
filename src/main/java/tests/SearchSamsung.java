package tests;


import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import globalFunctions.GeneralFunctions;
import localFunctions.AppicationFunctions;
import variables.Global;

public class SearchSamsung {

	@BeforeTest
	public void LaunchApp() {
		System.out.println("Printed Before test");
		System.setProperty("webdriver.chrome.driver","D:\\Karthik\\chromedriver.exe");
		Global.driver = new ChromeDriver();
	AppicationFunctions.NavigateToApp("https://www.flipkart.com/");

	}
	@Test(priority=0)
	public void searchForProduct() throws IOException {
		XSSFSheet sh = GeneralFunctions.readExcel();
		String ProductToSearch = sh.getRow(1).getCell(0).getStringCellValue();
		AppicationFunctions.searchText(ProductToSearch);
	}
	@Test(priority=1)
	public void selectMaxPrice() throws IOException {
		XSSFSheet sh = GeneralFunctions.readExcel();
		String maxPrice = sh.getRow(1).getCell(1).getStringCellValue();
		AppicationFunctions.maxPriceDropDown("₹"+maxPrice);
	}
	@Test(priority=2)
	public void selectRam() throws IOException {
		XSSFSheet sh = GeneralFunctions.readExcel();
		String ramSize = sh.getRow(1).getCell(2).getStringCellValue();
		AppicationFunctions.selectRamSize(ramSize);
	}
	@Test(priority=3)
	public void selectProcessorBrand() throws IOException {
		XSSFSheet sh = GeneralFunctions.readExcel();
		String proBrand = sh.getRow(1).getCell(3).getStringCellValue();
		AppicationFunctions.selectPrcessorBrand(proBrand);
	}
	@Test(priority=4)
	public void serchResults() throws InterruptedException {
		AppicationFunctions.getSearchResults();
	}
	@AfterTest
	public void driverQuit() {
		Global.driver.quit();
	}
}
