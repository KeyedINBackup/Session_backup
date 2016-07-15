package config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


import static com.ExecutionEngine.DriverScript.OR;

public class ActionKeywords {

	public static WebDriver dr;
	
	public static void openBrowser(){
		dr=new FirefoxDriver();		
	}
	
	public static void openURL(){
		dr.get(constants.URL);		
	}
	
	public static void input_Username(){
		dr.findElement(By.id(OR.getProperty("login_username"))).sendKeys(constants.UserName);		
	}
	
	public static void input_Password(){
		dr.findElement(By.id(OR.getProperty("login_pass"))).sendKeys(constants.Password);		
	}
	
	public static void click_Login(){
		dr.findElement(By.xpath(OR.getProperty("login_btn"))).submit();		
	}
	
	public static void waitFor(){
		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);		
	}
	
	public static void loginValidation(){
		String PS=dr.getPageSource();
		if(PS.contains("Administrator !")){
			System.out.println("Login successfully");
		} else {
			System.out.println("Try again... !");
		}		
	}
	
	public static void click_Vendor(){
		dr.findElement(By.xpath(OR.getProperty("vendor_btn"))).click();		
	}
	
	public static void click_CreateVendor(){
		dr.findElement(By.xpath(OR.getProperty("createVendor_btn"))).click();		
	}
	
	public static void input_CreateVendorForm(){
		dr.findElement(By.id("VendorName")).sendKeys("TESVEN_666");
		dr.findElement(By.id("FirstName")).sendKeys("VENDOR036");
		dr.findElement(By.id("LastName")).sendKeys("ID001");
		dr.findElement(By.id("Designation")).sendKeys("Test Designation");
		dr.findElement(By.id("Address")).sendKeys("Test Location");
		Select sel =new Select(dr.findElement(By.id("Country")));
		sel.selectByIndex(3);
		Select stat =new Select(dr.findElement(By.id("State")));
		stat.selectByIndex(2);
		dr.findElement(By.id("Mobile1")).sendKeys("09874563215");
		dr.findElement(By.id("Email1")).sendKeys("testuser666@extremail.ru");
		dr.findElement(By.id("Website")).sendKeys("WWW.Test-Website.test");
		Select VenCat =new Select(dr.findElement(By.id("CategoryID")));
		VenCat.selectByIndex(3);		
	}
	
	public static void clikc_Save(){
		dr.findElement(By.xpath(OR.getProperty("save_btn"))).click();
		System.out.println("Vendor details created successfully");
	}
	
	public static void input_Vendorname(){
		dr.findElement(By.id(OR.getProperty("vendor_name"))).sendKeys("TESVEN_666");		
	}
	
	public static void click_Search(){
		dr.findElement(By.id(OR.getProperty("search_btn"))).click();
	}
	
	public static void searchValidation(){
		WebElement Name =dr.findElement(By.xpath(OR.getProperty("vendorName_column")));
		String VendorName=Name.getText();
		if(VendorName.equalsIgnoreCase("TESVEN_666"))
		{
			System.out.println("Searching done succesfully");
		} else {
			System.out.println("Try again... !");
		}		
	}
	
	public static void click_view(){
		dr.findElement(By.className(OR.getProperty("view_btn"))).click();		
	}
	
	public static void sleep() throws InterruptedException{
		TimeUnit.SECONDS.sleep(3);
		System.out.println("Succesfully viewed the record...!");
	}
	
	public static void click_logout(){
		System.out.println("logout");
		dr.findElement(By.id(OR.getProperty("click_logout"))).click();		
	}
	
	public static void quit(){
		dr.close();
		dr.quit();
	}
	
	
	
}
