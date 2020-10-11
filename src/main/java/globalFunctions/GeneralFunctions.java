package globalFunctions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import variables.Global;

public class GeneralFunctions {
	public static void  captureScreenshot(String sFileName)
	{

		try {
			File srcFile = ((TakesScreenshot) Global.driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File(sFileName+".png"));	

		} catch (Exception e) {
//			Messages.errorMsg = e.getMessage();
			e.printStackTrace();
		}

	}
	public static XSSFSheet readExcel() throws IOException{
		FileInputStream fs = new FileInputStream("./Data/TestData.xlsx");
		//Creating a workbook
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheetAt(0);
		return sheet;
	}

}


