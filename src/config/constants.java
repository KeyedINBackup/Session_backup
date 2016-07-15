package config;
 
public class constants {
 
	//This is the list of System Variables
    //Declared as 'public', so that it can be used in other classes of this project
    //Declared as 'static', so that we do not need to instantiate a class object
    //Declared as 'final', so that the value of this variable can be changed
    // 'String' & 'int' are the data type for storing a type of value	
	public static final String URL = "http://202.129.196.139:2231/QuoteGen/";
	public static final String Path_TestData = "C:\\Selenium\\com.session.keyword\\src\\com\\DataEngine\\DataEngine.xlsx";
	public static final String Path_OR = "C:\\Selenium\\com.session.keyword\\src\\config\\OR.txt";

	public static final String File_TestData = "DataEngine.xlsx";
 
	//List of Data Sheet Column Numbers
	public static final int Col_TestCaseID = 0;	
	public static final int Col_TestScenarioID =1 ;
	//This column is shifted from 3 to 4
	public static final int Col_ActionKeyword =3 ;
	//New entry in Constant variable
	public static final int Col_Status =4 ;
	
 
	//List of Data Engine Excel sheets
	public static final String Sheet_TestSteps = "Test Steps";
 
	//List of Test Data
	public static final String UserName = "Administrator";
	public static final String Password = "QuoteGen@123";
 
}