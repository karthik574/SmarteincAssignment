package locators;
import org.openqa.selenium.By;
public class Locators {
	public static class HomePage{
		public static class button{
			public static By closeLoginPopup = By.xpath("/html/body/div[2]/div/div/button");
			public static By Login = By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[3]/div/div/div/a");
			public static By processorBrand = By.xpath("//*[@id=\"container\"]/div/div[3]/div[2]/div/div[1]/div[2]/div[1]/div/section[16]/div");
			
		}
	public static class textbox{
		 public static By searchBox = By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[2]/form/div/div/input");
	}
	public static class dropdown{
		 public static By priceMax = By.xpath("//*[@id=\"container\"]/div/div[3]/div[2]/div/div[1]/div[2]/div[1]/div/section[2]/div[4]/div[3]/select");
	}
	public static class checkbox{
		 public static By ramSize = By.xpath("//*[@id=\"container\"]/div/div[3]/div[2]/div/div[1]/div[2]/div[1]/div/section[4]/div[2]/div/div");
		 public static By requiredRamSize = By.xpath("//*[@id=\"container\"]/div/div[3]/div[2]/div/div[1]/div[2]/div[1]/div/section[4]/div[2]/div/div[");
		 public static By processorBrandTypes = By.xpath("//*[@id=\"container\"]/div/div[3]/div[2]/div/div[1]/div[2]/div[1]/div/section[16]/div[2]/div/div");
	}
	
	}

}
