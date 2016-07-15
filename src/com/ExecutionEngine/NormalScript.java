package com.ExecutionEngine;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class NormalScript {
	static WebDriver dr=new FirefoxDriver();
	
	public static void main(String[] args) throws Exception{
		
		dr.get("http://202.129.196.139:2231/QuoteGen/");
		dr.findElement(By.id("UserName")).sendKeys("Administrator");
		dr.findElement(By.id("Password")).sendKeys("QuoteGen@123");
		dr.findElement(By.xpath(".//*[@value='Log in']")).submit();
		String PS=dr.getPageSource();
		if(PS.contains("Administrator !")){
			System.out.println("Login successfully");
		} else {
			System.out.println("Try again... !");
		}
		dr.findElement(By.xpath(".//*[@class='nav navbar-nav']/li[5]/a")).click();
		dr.findElement(By.xpath(".//*[@class='row btn-row']/a")).click();
		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		dr.findElement(By.id("VendorName")).sendKeys("TESVEN_367");
		dr.findElement(By.id("FirstName")).sendKeys("VENDOR001");
		dr.findElement(By.id("LastName")).sendKeys("ID001");
		dr.findElement(By.id("Designation")).sendKeys("Test Designation");
		dr.findElement(By.id("Address")).sendKeys("Test Location");
		Select sel =new Select(dr.findElement(By.id("Country")));
		sel.selectByIndex(3);
		Select stat =new Select(dr.findElement(By.id("State")));
		stat.selectByIndex(2);
		dr.findElement(By.id("Mobile1")).sendKeys("09874563215");
		dr.findElement(By.id("Email1")).sendKeys("testuser367@extremail.ru");
		dr.findElement(By.id("Website")).sendKeys("WWW.Test-Website.test");
		Select VenCat =new Select(dr.findElement(By.id("CategoryID")));
		VenCat.selectByIndex(3);
		dr.findElement(By.xpath(".//*[@value='Save']")).click();
		dr.findElement(By.id("Vendor")).sendKeys("TESVEN_367");
		dr.findElement(By.id("btnSearch")).click();
		WebElement Name =dr.findElement(By.xpath("html/body/div[1]/div[4]/section[2]/div/form/div[3]/div/table/tbody/tr[2]/td[3]"));
		String VendorName=Name.getText();
		if(VendorName.equalsIgnoreCase("TESVEN_367"))
		{
			System.out.println("Searching done succesfully");
		} else {
			System.out.println("Try again... !");
		}
		dr.findElement(By.className("btn-view")).click();
	}
}