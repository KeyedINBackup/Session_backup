package com.ExecutionEngine;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;

import com.utility.*;

import config.ActionKeywords;
import config.constants;

public class DriverScript {
	public static Properties OR;
	//This is a class object, declared as 'public static'
	//So that it can be used outside the scope of main[] method
	public static ActionKeywords actionKeywords;
	public static String sActionKeyword;
	//This is reflection class object, declared as 'public static'
	//So that it can be used outside the scope of main[] method
	public static Method method[];
 
	
	public static void main(String[] args) throws Exception{
		
		ExcelUtilis.setExcelFile(constants.Path_TestData, constants.Sheet_TestSteps);
		
		actionKeywords = new ActionKeywords();
		//This will load all the methods of the class 'ActionKeywords' in it.
                //It will be like array of method, use the break point here and do the watch
		method = ActionKeywords.class.getMethods();
		
		//Declaring String variable for storing Object Repository path
    	String Path_OR = constants.Path_OR;
		//Creating file system object for Object Repository text/property file
		FileInputStream fs = new FileInputStream(Path_OR);
		//Creating an Object of properties
		OR= new Properties(System.getProperties());
		//Loading all the properties from Object Repository property file in to OR object
		OR.load(fs);
		//This will return the total number of test cases mentioned in the Test cases sheet
		int iTotalTestSteps = ExcelUtilis.getRowCount(constants.Sheet_TestSteps);
		System.out.println("Total number of Scenarios:" +iTotalTestSteps);
		//This loop will execute number of times equal to Total number of test cases
		for (int iRow = 1;iRow <= iTotalTestSteps;iRow++){
		    //This to get the value of column Action Keyword from the excel
    		sActionKeyword = ExcelUtilis.getCellData(iRow, constants.Col_ActionKeyword);
    		
            //A new separate method is created with the name 'execute_Actions'
			//You will find this method below of the this test
			//So this statement is doing nothing but calling that piece of code to execute
    		//Comparing the value of Excel cell with all the project keywords
    		if(sActionKeyword.equals("openBrowser")){
                        //This will execute if the excel cell value is 'openBrowser'
    			//Action Keyword is called here to perform action
    			ActionKeywords.openBrowser();}
    		else if(sActionKeyword.equals("openURL")){
    			ActionKeywords.openURL();}
    		else if(sActionKeyword.equals("input_Username")){
    			ActionKeywords.input_Username();}
    		else if(sActionKeyword.equals("input_Password")){
    			ActionKeywords.input_Password();}
    		else if(sActionKeyword.equals("click_Login")){
    			ActionKeywords.click_Login();}
    		else if(sActionKeyword.equals("waitFor")){
    			ActionKeywords.waitFor();}
    		else if(sActionKeyword.equals("loginValidation")){
    			ActionKeywords.loginValidation();}
    		else if(sActionKeyword.equals("click_Vendor")){
    			ActionKeywords.click_Vendor();}
    		else if(sActionKeyword.equals("click_CreateVendor")){
    			ActionKeywords.click_CreateVendor();}
    		else if(sActionKeyword.equals("input_CreateVendorForm")){
    			ActionKeywords.input_CreateVendorForm();}
    		else if(sActionKeyword.equals("clikc_Save")){
    			ActionKeywords.clikc_Save();}
    		else if(sActionKeyword.equals("input_Vendorname")){
    			ActionKeywords.input_Vendorname();}
    		else if(sActionKeyword.equals("click_Search")){
    			ActionKeywords.click_Search();}
    		else if(sActionKeyword.equals("searchValidation")){
    			ActionKeywords.searchValidation();}
    		else if(sActionKeyword.equals("click_view")){
    			ActionKeywords.click_view();}
    		else if(sActionKeyword.equals("sleep")){
    			ActionKeywords.sleep();}
    		else if(sActionKeyword.equals("click_logout")){
    			ActionKeywords.click_logout();}
    		else if(sActionKeyword.equals("quit")){
    			ActionKeywords.quit();}
    		ExcelUtilis.PrintResult("Test Pass", iRow, constants.Col_Status);
    		}
    	}
   }	
