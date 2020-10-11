package localFunctions;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import globalFunctions.GeneralFunctions;
import locators.Locators;
import variables.Global;

public class AppicationFunctions {
	private static Boolean bstatus;
	public static boolean NavigateToApp(String URL) {
		try {
		Global.driver.get(URL);
		Global.driver.manage().window().maximize();
		Global.wait = new WebDriverWait(Global.driver,30);
		Global.wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.HomePage.button.closeLoginPopup));
		Global.driver.findElement(Locators.HomePage.button.closeLoginPopup).click();
		bstatus = Global.driver.findElement(Locators.HomePage.button.Login).isDisplayed();
		if (!bstatus) {
			return false;
		}
		else {
			return true;
		}
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Login button is not present");
			return false;
		}
	}
	public static boolean searchText(String toSearch){
		try {
		bstatus = Global.driver.findElement(Locators.HomePage.textbox.searchBox).isDisplayed();
		if (!bstatus) {
			Assert.assertFalse(bstatus, "Search Text box is not visible");
			return false;
		}
		else {
			Assert.assertTrue(true,"Search Text box is visible");
			Global.driver.findElement(locators.Locators.HomePage.textbox.searchBox).sendKeys(toSearch);
			Global.driver.findElement(locators.Locators.HomePage.textbox.searchBox).sendKeys(Keys.ENTER);
		        return true;			 
		}
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Serch text box is not visible");
			return false;
		}
	}
	public static boolean maxPriceDropDown(String maxPrice) {
			try {
				Global.wait = new WebDriverWait(Global.driver,30);
				Global.wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.HomePage.dropdown.priceMax));
				bstatus = Global.driver.findElement(Locators.HomePage.dropdown.priceMax).isDisplayed();
				if (!bstatus) {
					Assert.assertFalse(bstatus, "Maximum price dropdown is not visible");
					return false;
				}
				else {
					Assert.assertTrue(true,"Maximum price dropdown is visible");
					Select drpPrice = new Select(Global.driver.findElement(Locators.HomePage.dropdown.priceMax));
					drpPrice.selectByVisibleText(maxPrice);
					return true;
				}
			}
				catch (Exception e) {
					e.printStackTrace();
					System.out.println("Maximum price dropdown is not is not visible");
					Assert.assertFalse(bstatus, "Maximum price dropdown is not visible");
					return false;
				}
				}
	public static boolean selectRamSize(String reqramsize) {
			try {
				Global.wait = new WebDriverWait(Global.driver,30);
				Global.wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.HomePage.checkbox.ramSize));
				bstatus = Global.driver.findElement(Locators.HomePage.checkbox.ramSize).isDisplayed();
				if (!bstatus) {
					Assert.assertFalse(bstatus, "Ram size filter is not visible");
					return false;
				}
				else {
					Assert.assertTrue(true,"Ram size filter is visible");
					int ramSizeTypes = Global.driver.findElements(Locators.HomePage.checkbox.ramSize).size();
					for (int i = 1; i < ramSizeTypes; i++) {
						  String ramSize = Global.driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[2]/div/div[1]/div[2]/div[1]/div/section[4]/div[2]/div/div["+i+"]")).getText();
						  if(ramSize.equals(reqramsize)) {
							  Global.driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[2]/div/div[1]/div[2]/div[1]/div/section[4]/div[2]/div/div["+i+"]")).click();
						  }                                      
						}
					return true;
				}
			}
				catch (Exception e) {
					e.printStackTrace();
					System.out.println("Ram size filter is not visible");
					Assert.assertFalse(bstatus, "Ram size filter is not visible");
					return false;
				}
				}	
	public static boolean selectPrcessorBrand(String processorType) {
			try {
				Global.wait = new WebDriverWait(Global.driver,30);
				Global.wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.HomePage.button.processorBrand));
				bstatus = Global.driver.findElement(Locators.HomePage.button.processorBrand).isDisplayed();
				if (!bstatus) {
					Assert.assertFalse(bstatus, "Processor brand column is not visible");
					return false;
				}
				else {
					Assert.assertTrue(true,"Processor brand column is visible");
					Global.driver.findElement(Locators.HomePage.button.processorBrand).click();                        
					int ProcessorBrand = Global.driver.findElements(Locators.HomePage.checkbox.processorBrandTypes).size();
					for (int j = 1; j < ProcessorBrand; j++) {
						  String brand = Global.driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[2]/div/div[1]/div[2]/div[1]/div/section[16]/div[2]/div/div["+j+"]")).getText();              
						  if(brand.equals(processorType)){  
							  Global.driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[2]/div/div[1]/div[2]/div[1]/div/section[16]/div[2]/div/div["+j+"]")).click();
						  }
					}
					return true;
				}
			}
				catch (Exception e) {
					e.printStackTrace();
					System.out.println("Processor brand column is not visible");
					Assert.assertFalse(bstatus, "Processor brand column is not visible");
					return false;
				}
				}
	public static void getSearchResults() throws InterruptedException {
	    	Thread.sleep(6000);
		   GeneralFunctions.captureScreenshot("./Results/TestEvidenceScreenShot");   
		   int noOfResults = Global.driver.findElements(By.xpath("//*[@id=\"container\"]/div/div[3]/div[2]/div/div[2]/div")).size();
			 Map<String, String> kk1 = new HashMap<String, String>();
			 for (int k=2;k<noOfResults;k++) {
				 String result = Global.driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[2]/div/div[2]/div["+k+"]/div/div/div/a/div[2]/div[1]/div[1]")).getText();
				 result = result.replace(',','-');
				 String resultPrice = Global.driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[2]/div/div[2]/div["+k+"]/div/div/div/a/div[2]/div[2]/div[1]/div/div")).getText();
				 resultPrice = resultPrice.replace(',',' ');	
				 resultPrice = resultPrice.replace('₹',' ');
				 resultPrice = resultPrice.replaceAll("\\s", "");
	             kk1.put(result, resultPrice);		             
			 }
		        String eol = System.getProperty("line.separator");
		        try (Writer writer1 = new FileWriter("./Results/ResultSet.csv")) {
		        	writer1.append("Mobile Name") .append(',') .append("Price") .append(eol);
		        	for (Map.Entry<String, String> entry : kk1.entrySet()) {
		        		writer1.append(entry.getKey()) .append(',') .append(entry.getValue()) .append(eol);
		        		} 
		        	}
		        catch (IOException ex) { ex.printStackTrace(System.err); 
		        }
	    }
}


